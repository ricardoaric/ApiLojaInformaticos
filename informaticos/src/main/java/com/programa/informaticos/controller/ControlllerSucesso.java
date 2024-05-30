package com.programa.informaticos.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControlllerSucesso {

    @GetMapping("/cadastro-sucesso")
    public String cadastroSucesso(@RequestParam("mensagem") String mensagem, Model model) {
        model.addAttribute("mensagem", mensagem);
        return "cadastro-sucesso";
    }
}
