package com.projet.recherche.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_details_rapport_produit")
public class VDetailsRapportProduit {

    @Id
    private int idProduit;
    private String nomProduit;
    private int idCategorie;
    private String nomCategorie;
    private double prix;
    private int qualite;
    private double rapport;

    public VDetailsRapportProduit() {

    }

    public VDetailsRapportProduit(int idProduit, String nomProduit, int idCategorie, String nomCategorie, double prix,
            int qualite, double rapport) {
        setIdProduit(idProduit);
        setNomProduit(nomProduit);
        setIdCategorie(idCategorie);
        setNomCategorie(nomCategorie);
        setPrix(prix);
        setQualite(qualite);
        setRapport(rapport);
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQualite() {
        return qualite;
    }

    public void setQualite(int qualite) {
        this.qualite = qualite;
    }

    public double getRapport() {
        return rapport;
    }

    public void setRapport(double rapport) {
        this.rapport = rapport;
    }
}
