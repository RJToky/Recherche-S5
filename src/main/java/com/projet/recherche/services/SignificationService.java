package com.projet.recherche.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.recherche.models.Signification;
import com.projet.recherche.repository.SignificationRepository;

@Service
public class SignificationService {

    @Autowired
    private SignificationRepository significationRepository;

    public List<Signification> getAllSignification() {
        return significationRepository.findAll();
    }
}
