package br.edu.saojudas.redesocial.infraestructure.service;

import br.edu.saojudas.redesocial.domain.persistence.UsuarioEntity;
import br.edu.saojudas.redesocial.domain.web.UsuarioTO;
import br.edu.saojudas.redesocial.infraestructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public boolean createUser(UsuarioTO usuarioTO){
        try {

            UsuarioEntity usuarioEntity = new UsuarioEntity(null,usuarioTO.getUsername(),usuarioTO.getPassword(),usuarioTO.getName(),usuarioTO.getLastName());
            usuarioRepository.save(usuarioEntity);
            return true;

        }catch (Exception e){
            return false;
        }

    }

    public List<UsuarioEntity> listUser(){
        return usuarioRepository.findAll();
    }

}
