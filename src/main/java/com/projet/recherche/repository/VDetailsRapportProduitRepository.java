package com.projet.recherche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.recherche.models.VDetailsRapportProduit;

@Repository
public interface VDetailsRapportProduitRepository extends JpaRepository<VDetailsRapportProduit, Integer> {

}
