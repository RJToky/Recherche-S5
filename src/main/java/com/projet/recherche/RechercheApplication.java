package com.projet.recherche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RechercheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RechercheApplication.class, args);

		String temp = "meilleurs prix telephone";
		boolean containsMeilleur = temp.matches(".*\\bmeilleur\\b.*");
		boolean containsMeilleurs = temp.matches(".*\\bmeilleurs\\b.*");
		boolean containsPrix = temp.matches(".*\\bprix\\b.*");

		// System.out.println("m sans s:" + containsMeilleur);
		// System.out.println("m avec s:" + containsMeilleurs);
		// System.out.println("prix:" + containsMeilleurs);
	}

}
