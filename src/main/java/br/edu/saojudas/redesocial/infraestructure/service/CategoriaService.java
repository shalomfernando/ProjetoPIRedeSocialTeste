package br.edu.saojudas.redesocial.infraestructure.service;

import br.edu.saojudas.redesocial.domain.persistence.CategoriaEntity;
import br.edu.saojudas.redesocial.infraestructure.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaEntity> listaDeCategorias(){
        return categoriaRepository.findAll();
    }

    public void cadastroDeCategorias(CategoriaEntity entity){
        categoriaRepository.save(entity);
    }
}
