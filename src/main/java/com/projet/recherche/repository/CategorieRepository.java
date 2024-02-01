package com.projet.recherche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.recherche.models.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    public Categorie findByNom(String nom);
}
