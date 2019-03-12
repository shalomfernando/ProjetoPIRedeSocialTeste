package br.edu.saojudas.redesocial.infraestructure.service;

import br.edu.saojudas.redesocial.domain.persistence.UsuarioEntity;
import br.edu.saojudas.redesocial.domain.web.UsuarioTO;
import br.edu.saojudas.redesocial.infraestructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class UsuarioService {

    public static final String SESSION = "usuario";

    @Autowired
    public UsuarioRepository usuarioRepository;

    public boolean createUser(UsuarioTO usuarioTO) {
        try {

            UsuarioEntity usuarioEntity = new UsuarioEntity(null, usuarioTO.getUsername(), usuarioTO.getPassword(), usuarioTO.getName(), usuarioTO.getLastName());
            usuarioRepository.save(usuarioEntity);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public List<UsuarioEntity> listUser() {
        return usuarioRepository.findAll();
    }

    public boolean logar(UsuarioTO usuarioTO, HttpSession session) {

        List<UsuarioEntity> usuarioEntity = usuarioRepository.findAll();

        for(UsuarioEntity x : usuarioEntity){
            if(x.getUsername().equals(usuarioTO.getUsername()) && x.getPassword().equals(usuarioTO.getPassword())){
                session.setAttribute(SESSION, new UsuarioEntity());
                return true;
            }
        }
        return false;
    }

}
