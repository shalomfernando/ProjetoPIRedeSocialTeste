package br.edu.saojudas.redesocial.infraestructure.controller;


import br.edu.saojudas.redesocial.domain.persistence.UploadLogEntity;
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

    private UploadService service;

    @Autowired
    public UploadController(UploadService service)
    {
        this.service = service;
    }

    @GetMapping("/upload")
    public ModelAndView uploadFile() {
        ModelAndView mv = new ModelAndView("uploadForm");
        List<UploadLogEntity> registros = service.listUser();
        mv.addObject("registro",registros);
        return mv;
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {

        String message = service.uploadLog(file);
        redirectAttributes.addFlashAttribute("message",message + "!");

        return "redirect:/upload";
    }

}