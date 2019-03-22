package br.edu.saojudas.redesocial.infraestructure.service;

import br.edu.saojudas.redesocial.domain.persistence.TagEntity;
import br.edu.saojudas.redesocial.infraestructure.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    public TagRepository tagRepository;

    public List<TagEntity> listaDeTags(){
        return tagRepository.findAll();
    }

    public void cadastroDeTags(TagEntity entity){
        tagRepository.save(entity);
    }
}
