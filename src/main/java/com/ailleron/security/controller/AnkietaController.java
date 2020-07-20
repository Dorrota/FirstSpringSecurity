package com.ailleron.security.controller;

import com.ailleron.security.domain.Ankieta;
import com.ailleron.security.service.AnkietaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ankieta")
public class AnkietaController {

    private final AnkietaService ankietaService;

    public AnkietaController(AnkietaService ankietaService) {
        this.ankietaService = ankietaService;
    }

    @GetMapping("/all")
    public String viewAll(Model model){
        List<Ankieta> list = ankietaService.findAll();
        model.addAttribute("ankiety", list);
        return "ankieta";
    }
}
