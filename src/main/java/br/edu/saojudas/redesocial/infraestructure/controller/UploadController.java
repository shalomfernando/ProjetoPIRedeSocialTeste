package br.edu.saojudas.redesocial.infraestructure.controller;


import br.edu.saojudas.redesocial.domain.persistence.TagEntity;
import br.edu.saojudas.redesocial.domain.web.TagTO;
import br.edu.saojudas.redesocial.domain.web.UploadLogTO;
import br.edu.saojudas.redesocial.infraestructure.service.TagService;
import br.edu.saojudas.redesocial.infraestructure.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class UploadController {

    private UploadService uploadService;
    private TagService tagService;

    @Autowired
    public UploadController(UploadService service)
    {
        this.uploadService = service;
    }

    @GetMapping("/upload")
    public ModelAndView uploadFile() {
        ModelAndView mv = new ModelAndView("uploadForm");
        List<UploadLogTO> registros = uploadService.listUser();
        mv.addObject("registro",registros);
        List<TagTO> tags = tagService.listaDeTags();
        mv.addObject("tags",tags);
        return mv;
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, List<TagEntity> entityList) throws Exception {

        String message = uploadService.uploadLog(file,entityList);
        redirectAttributes.addFlashAttribute("message",message + "!");

        return "redirect:/upload";
    }

}