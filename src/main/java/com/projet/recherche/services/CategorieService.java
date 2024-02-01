package com.projet.recherche.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.projet.recherche.models.Categorie;
import com.projet.recherche.repository.CategorieRepository;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testAllCategorie(int id) {
        String requete = "SELECT * FROM categorie WHERE id = ?";

        List<Categorie> listCategorie = jdbcTemplate.query(requete, new Object[] { id },
                new BeanPropertyRowMapper<>(Categorie.class));

        for (Categorie categorie : listCategorie) {
            System.out.println(categorie.getNom());
        }
    }

    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    public Categorie getByNom(String nom) {
        return categorieRepository.findByNom(nom);
    }
}
