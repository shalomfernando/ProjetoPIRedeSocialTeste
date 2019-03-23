package br.edu.saojudas.redesocial.infraestructure.controller;

import br.edu.saojudas.redesocial.domain.persistence.UsuarioEntity;
import br.edu.saojudas.redesocial.infraestructure.repository.UsuarioRepository;
import br.edu.saojudas.redesocial.infraestructure.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CadastroUser {

    private final CadastroService cadastroService;
    private final UsuarioRepository repo;

    @Autowired
    public CadastroUser(CadastroService cadastroService, UsuarioRepository repo) {
        this.cadastroService = cadastroService;
        this.repo = repo;
    }

    @GetMapping("/pogba") //quaquer nome para colocar no localhost:port/pogba
    public ModelAndView listarAlunos() {

        ModelAndView mv = new ModelAndView("cadastro"); // Pagina a ser visualizado
        List<UsuarioEntity> usuarioEntiys = cadastroService.Mostrar();
        mv.addObject("usuarioEntiys", usuarioEntiys );
        mv.addObject(new UsuarioEntity());

        return mv;
    }

    @PostMapping("/pogba")
    public String Cadastro(UsuarioEntity usuarioEntity){
        cadastroService.CadastrarUsusario(usuarioEntity);
        return "redirect:pogba";
    }



}
