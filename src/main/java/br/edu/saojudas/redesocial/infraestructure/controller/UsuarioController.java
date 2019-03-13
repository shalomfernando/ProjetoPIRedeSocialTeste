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
    ModelAndView mv = new ModelAndView("2");
    List<UsuarioEntity> user = usuarioService.listUser();

    mv.addObject("user",user);
    mv.addObject(new UsuarioTO());
    return mv;
    }

    @PostMapping
    public String cadastrarUsuario(UsuarioTO usuarioTO) {
        boolean result = usuarioService.createUser(usuarioTO);
        return result? "redirect:/home":"redirect:/home";
    }

}
