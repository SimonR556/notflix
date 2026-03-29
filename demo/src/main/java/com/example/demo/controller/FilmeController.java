package com.example.demo.controller;

import com.example.demo.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Comentario;
import com.example.demo.repository.ComentarioRepository;
//import java.util.List;
@Controller 
@RequestMapping("/filmes")

public class FilmeController {

    @Autowired
    private FilmeService filmeService;
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @GetMapping("/{id}")
    public String verFilme(@PathVariable int id, Model model) {
    var filme = filmeService.buscarFilme(id);
    model.addAttribute("filme", filme);

    model.addAttribute("comentarios", comentarioRepository.findByFilmeId(id)); 
    
    return "detalhes"; 
}


    @PostMapping("/{id}/comentar")
    public String salvarComentario(@PathVariable int id, @RequestParam String texto) {
        Comentario novoComentario = new Comentario();
        novoComentario.setFilmeId(id);
        novoComentario.setAutor("Usuário Anônimo"); 
        novoComentario.setTexto(texto);

        comentarioRepository.save(novoComentario);

        return "redirect:/filmes/" + id; 
    }
}