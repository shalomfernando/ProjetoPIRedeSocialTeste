package br.edu.saojudas.redesocial.infraestructure.controller;

import br.edu.saojudas.redesocial.domain.persistence.UsuarioEntity;
import br.edu.saojudas.redesocial.domain.web.UsuarioTO;
import br.edu.saojudas.redesocial.infraestructure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/home")
    public ModelAndView Home(){
    ModelAndView mv = new ModelAndView("home");
    List<UsuarioEntity> user = usuarioService.listUser();

    mv.addObject("user",user);
    mv.addObject(new UsuarioTO());
    return mv;
    }

    @PostMapping
    public String cadastrarUsuario(UsuarioTO usuarioTO) {
 //       usuarioService.login(usuarioTO.getUsername(),usuarioTO.getPassword());
        boolean result = usuarioService.createUser(usuarioTO);
        return result? "redirect:/home":"redirect:/home";
    }

}
