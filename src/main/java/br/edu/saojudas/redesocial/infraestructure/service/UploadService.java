package br.edu.saojudas.redesocial.infraestructure.service;

import br.edu.saojudas.redesocial.infraestructure.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.FileOutputStream;

@Service
public class UploadService {

    @Autowired
    private UploadRepository repository;

    public boolean UploadArq(String file){
            try{
                FileOutputStream stream = new FileOutputStream(file);
                return true;
            }catch (Exception e){
                return false;
            }
    }
}
