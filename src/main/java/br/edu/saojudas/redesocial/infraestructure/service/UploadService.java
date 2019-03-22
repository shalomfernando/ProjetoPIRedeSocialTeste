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

    private Path rootLocation;
    private String caminho = "upload-redesocial";
    private final UploadRepository repository;

    @Autowired
    public UploadService(UploadRepository repository) {
        rootLocation = Paths.get(caminho);
        this.repository = repository;
    }

    public String uploadLog(MultipartFile file,UploadLogEntity logEntity) throws IOException {
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
                logEntity.setCaminho(path);
                logEntity.setData(horaAtual);
                logEntity.setNome(filename);
                logEntity.setTipo(tipo);
                repository.save(logEntity);
                return filename + " Salvo com sucesso!";
            }
        }
        catch (Exception e) {
            Files.delete(Paths.get(path));
            return("Falha ao armazenar o arquivo " + filename);
        }
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

    public List<UploadLogEntity> listUpload() {
        return  repository.findAll();
    }
}
