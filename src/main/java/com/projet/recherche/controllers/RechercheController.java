package com.projet.recherche.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.recherche.services.VDetailsRapportProduitService;

@Controller
public class RechercheController {

    @Autowired
    private VDetailsRapportProduitService vDetailsRapportProduitService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String recherche, Model model) {
        if (recherche != null && recherche != "") {
            model.addAttribute("recherche", recherche);
            try {
                model.addAttribute("listProduit", vDetailsRapportProduitService.getAllResult(recherche));
            } catch (Exception e) {
                model.addAttribute("listProduit", List.of());
            }
        } else if (recherche == null || recherche == "") {
            model.addAttribute("listProduit", vDetailsRapportProduitService.getAll());
        }
        return "index";
    }
}
