package com.projet.recherche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.recherche.models.Signification;

@Repository
public interface SignificationRepository extends JpaRepository<Signification, Integer> {

}
