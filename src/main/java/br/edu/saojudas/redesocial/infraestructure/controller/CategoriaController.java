package br.edu.saojudas.redesocial.infraestructure.controller;

import br.edu.saojudas.redesocial.domain.persistence.CategoriaEntity;
import br.edu.saojudas.redesocial.domain.web.CategoriaTO;
import br.edu.saojudas.redesocial.infraestructure.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoriaController {
    private final CategoriaService catService;


    @Autowired
    public CategoriaController(CategoriaService catService) {
        this.catService = catService;
    }

    @GetMapping("/categoria")
    public ModelAndView tag() {
        ModelAndView mv = new ModelAndView("cadastroDeCategoria");
        List<CategoriaEntity> categoria = catService.listaDeCategorias();
        mv.addObject("categorias", categoria);
        mv.addObject(new CategoriaTO());
        return mv;
    }

    @PostMapping("/cadastroCategoria")
    public String tagCadastro(CategoriaEntity entity) throws Exception {

        catService.cadastroDeCategorias(entity);
        return "redirect:/categoria";
    }
}
