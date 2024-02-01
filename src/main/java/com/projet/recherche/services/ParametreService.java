package com.projet.recherche.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.recherche.models.Parametre;
import com.projet.recherche.repository.ParametreRepository;

@Service
public class ParametreService {

    @Autowired
    private ParametreRepository parametreRepository;

    public List<Parametre> getAllParametre() {
        return parametreRepository.findAll();
    }
}
