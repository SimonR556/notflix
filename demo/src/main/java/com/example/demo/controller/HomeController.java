package com.example.demo.controller;

import com.example.demo.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            // Se pesquisou, mostra o resultado da busca
            model.addAttribute("resultados", filmeService.pesquisarFilmes(nome));
            model.addAttribute("tituloPagina", "Resultados para: " + nome);
        } else {
            // Se não pesquisou nada, mostra os populares da semana
            model.addAttribute("resultados", filmeService.buscarPopulares());
            model.addAttribute("tituloPagina", "Filmes Populares");
        }
        return "index";
    }
}