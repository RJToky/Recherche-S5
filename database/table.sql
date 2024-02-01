CREATE DATABASE recherche;

\c recherche

drop table categorie cascade;
drop table produit cascade;
drop table parametre cascade;
drop table signification cascade;

CREATE TABLE categorie(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250)
);

CREATE TABLE produit(
    id SERIAL PRIMARY KEY,
    id_categorie INT,
    nom VARCHAR(250),
    prix DOUBLE PRECISION,
    qualite INT
);

CREATE TABLE parametre(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250)
);

CREATE TABLE signification(
    id SERIAL PRIMARY KEY,
    mot VARCHAR(250),
    signification_sql VARCHAR(250),
    position INT
);
