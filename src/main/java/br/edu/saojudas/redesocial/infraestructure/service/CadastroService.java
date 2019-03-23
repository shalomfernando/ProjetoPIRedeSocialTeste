package br.edu.saojudas.redesocial.infraestructure.service;

import br.edu.saojudas.redesocial.domain.persistence.UsuarioEntity;
import br.edu.saojudas.redesocial.infraestructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    public void CadastrarUsusario(UsuarioEntity usuarioEntity) {
        usuarioRepository.save(usuarioEntity);
    }

    public List<UsuarioEntity> Mostrar() {
        List<UsuarioEntity> list = usuarioRepository.findAll();

        for (UsuarioEntity usuarioEntity : list)
            usuarioEntity.getName();

        return list;
    }

    public boolean logar(UsuarioEntity usuarioEntity) {
        return usuarioRepository.findOneByUsernameAndPassword(usuarioEntity.getUsername(), usuarioEntity.getPassword()) != null;
    }
}
