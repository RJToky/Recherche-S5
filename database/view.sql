CREATE OR REPLACE VIEW v_details_rapport_produit AS (
    SELECT 
        p.id AS id_produit, 
        p.nom AS nom_produit, 
        c.id AS id_categorie,
        c.nom AS nom_categorie, 
        p.prix, p.qualite, 
        (qualite/prix) AS rapport
    FROM
        produit AS p
    JOIN categorie AS c ON p.id_categorie = c.id
);