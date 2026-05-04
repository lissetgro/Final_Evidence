package com.example.demo.controller;

import com.example.demo.model.Receta;
import com.example.demo.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecetaController {

    @Autowired
    private RecetaRepository repository;

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("totalRecetas", repository.count());
        return "index";
    }

    @GetMapping("/recetas")
    public String listarRecetas(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "lista-recetas";
    }

    @GetMapping("/recetas/nuevo")
    public String formularioNueva(Model model) {
        model.addAttribute("receta", new Receta());
        return "formulario";
    }

    @PostMapping("/recetas/guardar")
    public String guardar(@ModelAttribute("receta") Receta receta) {
        repository.save(receta);
        return "redirect:/recetas";
    }

    @GetMapping("/recetas/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Receta receta = repository.findById(id).orElse(null);
        model.addAttribute("receta", receta);
        return "formulario";
    }

    @GetMapping("/recetas/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/recetas";
    }
}