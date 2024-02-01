package com.projet.recherche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.recherche.models.Parametre;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Integer> {

}
