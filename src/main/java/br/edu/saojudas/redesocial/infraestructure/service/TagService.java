package br.edu.saojudas.redesocial.infraestructure.service;

import br.edu.saojudas.redesocial.domain.web.TagTO;
import br.edu.saojudas.redesocial.infraestructure.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TagService {

    @Autowired
    public TagRepository tagRepository;

    public List<TagTO> listaDeTags(){
        return Collections.singletonList ((TagTO )tagRepository.findAll());
    }

}
