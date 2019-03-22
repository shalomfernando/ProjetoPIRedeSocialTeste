package br.edu.saojudas.redesocial.infraestructure.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.edu.saojudas.redesocial.domain.persistence.UploadLogEntity;
import br.edu.saojudas.redesocial.infraestructure.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {


//    @PersistenceContext
//    private EntityManager entityManager;
    private Path rootLocation;
    private String caminho = "upload-redesocial";



    @Autowired
    public UploadService() {
        rootLocation = Paths.get(caminho);
    }

    @Autowired
    private UploadRepository repository;

    public String uploadLog(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        String path = "";
        String horaAtual = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String[] aux = filename.split("\\.");
        String nameArq = horaAtual+"."+aux[aux.length-1];
        String tipo = "";
        try {
            try (InputStream inputStream = file.getInputStream()) {
                switch ((aux[aux.length - 1].toLowerCase())) {
                    case "jpg":
                    case "png":
                        path = caminho + "/imagens/" + nameArq;
                        tipo = "IMAGEM";
                        Files.copy(inputStream, (rootLocation = Paths.get(caminho + "/imagens")).resolve(nameArq),
                                StandardCopyOption.REPLACE_EXISTING);
                        break;

                    case "mp4":
                    case "mov":
                        path = caminho + "/videos/" + nameArq;
                        tipo = "VIDEO";
                        Files.copy(inputStream, (rootLocation = Paths.get(caminho + "/videos")).resolve(nameArq),
                                StandardCopyOption.REPLACE_EXISTING);
                        break;
                    case "mp3":
                        path = caminho + "/audios/" + nameArq;
                        tipo = "AUDIO";
                        Files.copy(inputStream, (rootLocation = Paths.get(caminho + "/audios")).resolve(nameArq),
                                StandardCopyOption.REPLACE_EXISTING);
                        break;
                    default:
                        return "O tipo de arquivo escolhido não é aceito.(." + aux[aux.length - 1] + ")";
                }

                UploadLogEntity uploadLogEntity = new UploadLogEntity(null,filename,path,horaAtual,tipo);
                repository.save(uploadLogEntity);
                return filename + " Salvo com sucesso!";
            }
        }
        catch (Exception e) {
            Files.delete(Paths.get(path));
            return("Falha ao armazenar o arquivo " + filename);
        }
    }

//    Busca as Imagens ou os videos.(Caminho deles.)
    public Path loadVideos(String filename) {
        return (rootLocation = Paths.get(caminho+"/videos")).resolve(filename);
    }

    public Path loadImagens(String filename) {
        return (rootLocation = Paths.get(caminho+"/imagens")).resolve(filename);
    }

    public void init() throws Exception {
        try {
            Files.createDirectories(rootLocation);
            Files.createDirectories(rootLocation = Paths.get(caminho+"/videos"));
            Files.createDirectories(rootLocation = Paths.get(caminho+"/imagens"));
            Files.createDirectories(rootLocation = Paths.get(caminho+"/audios"));
        }
        catch (IOException e) {
            throw new Exception("Não foi possível inicializar o armazenamento", e);
        }
    }

    public List<UploadLogEntity> listUser() {
        return repository.findAll();
    }
}
