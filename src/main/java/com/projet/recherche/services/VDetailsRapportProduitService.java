package com.projet.recherche.services;

import java.util.List;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.projet.recherche.models.Categorie;
import com.projet.recherche.models.Parametre;
import com.projet.recherche.models.Signification;
import com.projet.recherche.models.VDetailsRapportProduit;
import com.projet.recherche.repository.VDetailsRapportProduitRepository;

@Service
public class VDetailsRapportProduitService {

    @Autowired
    private VDetailsRapportProduitRepository vDetailsRapportProduitRepository;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ParametreService parametreService;

    @Autowired
    private SignificationService significationService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VDetailsRapportProduit> getAll() {
        return vDetailsRapportProduitRepository.findAll();
    }

    public List<VDetailsRapportProduit> getAllResult(String recherche) {
        List<VDetailsRapportProduit> result = null;
        String valeurTraiter = recherche.toLowerCase();
        String startRequete = "SELECT * FROM V_details_rapport_produit";
        StringBuilder requete = new StringBuilder(startRequete);

        String categorie = "";
        String parametre = "";
        List<Categorie> listCategorie = categorieService.getAllCategorie();
        List<Parametre> listParametre = parametreService.getAllParametre();
        List<Signification> listSignification = significationService.getAllSignification();

        int count = 0;

        for (int i = 0; i < listCategorie.size(); i++) {
            if (valeurTraiter.contains(listCategorie.get(i).getNom().toLowerCase())) {
                categorie = listCategorie.get(i).getNom().toLowerCase();
                requete.append(" WHERE nom_categorie ILIKE '%" + categorie + "%'");
                break;
            }
        }

        for (int i = 0; i < listParametre.size(); i++) {
            if (valeurTraiter.contains(listParametre.get(i).getNom().toLowerCase())) {
                parametre = listParametre.get(i).getNom().toLowerCase();
                count = count + 1;
            }
        }

        if (count > 1) {
            parametre = "rapport";
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < listSignification.size(); i++) {
            String motCle = listSignification.get(i).getMot().toLowerCase();
            if (valeurTraiter.contains(motCle)) {
                String significationSqlTemp = listSignification.get(i).getSignificationSql();
                String significationSql = significationSqlTemp;
                String ordre = "";

                if (significationSqlTemp.contains("***")) {
                    int indexMotCle = valeurTraiter.indexOf(motCle);
                    String valeurDroite = valeurTraiter.substring(indexMotCle + motCle.length());

                    String[] parties = valeurDroite.split(" ");
                    String premiereValeur = parties[1];

                    significationSql = significationSqlTemp.replace("***", premiereValeur);
                    map.put(" " + significationSql, listSignification.get(i).getPosition());
                    continue;
                }

                if (significationSqlTemp.contains("---")) {
                    int indexMotCle = valeurTraiter.indexOf(motCle);
                    String valeurDroite = valeurTraiter.substring(indexMotCle + motCle.length());
                    // System.out.println("valeurDroite:" + valeurDroite);
                    String[] parties = valeurDroite.split(" ");
                    String premiereValeur = parties[1];
                    // System.out.println("prem: " + parties[0]);
                    // System.out.println("deux: " + parties[1]);

                    significationSql = significationSqlTemp.replace("---", premiereValeur);
                    map.put(" AND " + significationSql, listSignification.get(i).getPosition());
                    continue;
                }

                if (significationSqlTemp.contains("###")) {
                    significationSql = significationSqlTemp.replace("###", parametre);

                    if ((parametre.equals("prix") && motCle.equals("meilleur"))
                            || (parametre.equals("qualite") && motCle.equals("pire"))
                            || (parametre.equals("rapport") && motCle.equals("pire"))) {
                        ordre = "ASC";
                    } else if ((parametre.equals("prix") && motCle.equals("pire"))
                            || (parametre.equals("qualite") && motCle.equals("meilleur"))
                            || (parametre.equals("rapport") && motCle.equals("meilleur"))) {
                        ordre = "DESC";
                    }

                    map.put(" " + significationSql + " " + ordre, listSignification.get(i).getPosition());
                    continue;
                }

                map.put(" " + significationSql, listSignification.get(i).getPosition());
            }
        }

        // Conversion des entrées de la Map en une liste
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Tri de la liste en fonction des valeurs (ordre ascendant)
        entryList.sort(Comparator.comparing(Map.Entry::getValue));

        for (Map.Entry<String, Integer> entry : entryList) {
            requete.append(entry.getKey());
        }

        System.out.println(requete.toString());
        result = jdbcTemplate.query(requete.toString(), new BeanPropertyRowMapper(VDetailsRapportProduit.class));

        return result;
    }
}
