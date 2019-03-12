package br.edu.saojudas.redesocial.infraestructure.controller;

import br.edu.saojudas.redesocial.domain.web.UsuarioTO;
import br.edu.saojudas.redesocial.infraestructure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/efetuarLogi")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("efetuarLogin");

        mv.addObject(new UsuarioTO());
        return mv;
    }

    @PostMapping
    @RequestMapping("Login")
    public String efetuarLogin(UsuarioTO usuarioTO, HttpSession session){
    boolean result = usuarioService.logar(usuarioTO,session);
    return result? "redirect:/home" : "redirect:/login";
    }
}
