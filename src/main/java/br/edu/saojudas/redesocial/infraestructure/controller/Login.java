package br.edu.saojudas.redesocial.infraestructure.controller;

import br.edu.saojudas.redesocial.domain.persistence.UsuarioEntity;
import br.edu.saojudas.redesocial.infraestructure.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {
    @Autowired
    private CadastroService cadastroService;

    @GetMapping(value = {"/login","/"})
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");
        mv.addObject(new UsuarioEntity());
        return mv;
    }
    @PostMapping("/fazerLogin")
    public String fazer_login(HttpServletRequest request , UsuarioEntity usuarioEntity){
        if(cadastroService.logar(usuarioEntity)){
            request.getSession().getAttribute("usuarioLogado"   );
                return "redirect:upload";
        }
        else
            return "login";
    }
}
