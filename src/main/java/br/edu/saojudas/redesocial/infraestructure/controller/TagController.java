package br.edu.saojudas.redesocial.infraestructure.controller;

import br.edu.saojudas.redesocial.domain.persistence.TagEntity;
import br.edu.saojudas.redesocial.domain.persistence.UploadLogEntity;
import br.edu.saojudas.redesocial.domain.web.TagTO;
import br.edu.saojudas.redesocial.infraestructure.repository.TagRepository;
import br.edu.saojudas.redesocial.infraestructure.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tag")
    public ModelAndView tag() {
        ModelAndView mv = new ModelAndView("cadastroDeTags");
        List<TagEntity> tag = tagService.listaDeTags();
        mv.addObject("tags", tag);
        mv.addObject(new TagTO());
        return mv;
    }

    @PostMapping("/cadastroTag")
    public String tagCadastro(TagEntity entity) throws Exception {

        tagService.cadastroDeTags(entity);
        return "redirect:/tag";
    }
}
