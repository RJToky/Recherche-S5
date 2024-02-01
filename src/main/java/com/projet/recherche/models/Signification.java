package com.projet.recherche.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Signification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mot;
    private String significationSql;
    private int position;

    public Signification() {

    }

    public Signification(int id, String mot, String significationSql, int position) {
        setId(id);
        setMot(mot);
        setSignificationSql(significationSql);
        setPosition(position);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getSignificationSql() {
        return significationSql;
    }

    public void setSignificationSql(String significationSql) {
        this.significationSql = significationSql;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
