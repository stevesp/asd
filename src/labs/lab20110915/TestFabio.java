package labs.lab20110915;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import labs.lab20110915.autori.Autore;
import labs.lab20110915.autori.Autori;
import labs.lab20110915.collaborazione.Collaborazione;
import labs.lab20110915.collaborazione.Collaborazioni;

public class TestFabio {

	public static void main(String[] args) {

		// Inizializza gli autori
		List<Autore> autoriOrig = initAutori();

		for(Autore autore : autoriOrig) {
			System.out.println(autore);
		}
		
		// Inizializza la collaborazione 1
		Collaborazioni collaborazioni1 = initCollaborazione(autoriOrig, 20, 6); // Autori, Articoli, Collaboratori

		int i = 1;
		
		// Stampa la collaborazione 1
		System.out.println("----------------");
		System.out.println("Collaborazione " + i);
		System.out.println("----------------");
		
		for (Collaborazione c : collaborazioni1) {
			System.out.println(c.toString());
		}
		
		System.out.println("----------------------");
		
		boolean contained = false;
		
		// Inizializza la collaborazione 2
		Collaborazioni collaborazioni2 = initCollaborazione(autoriOrig, 1, 3); // Autori, Articoli, Collaboratori
		
		while (!contained) {
			
			i++;
			
			System.out.println("----------------");
			System.out.println("Collaborazione " + i);
			System.out.println("----------------");
			
			// Stampa la collaborazione 2
			for (Collaborazione c : collaborazioni2) {
				System.out.println(c.toString());
			}
			
			System.out.println("----------------------");
			
			// TEST DEL METODO incluso
			contained = collaborazioni2.incluso(collaborazioni1);
		}
		
		if (contained)
			System.out.println("La collaborazione 1 contiene la collaborazione 2.");
		else {
			System.out.println("La collaborazione 1 NON contiene la collaborazione 2.");
		}
		
		// TEST DEL METODO collaboratori
		for (Autore autore1 : autoriOrig) {
			Autori collaboratori = collaborazioni1.collaboratori(autore1);
			
			System.out.println("----------------------");
			System.out.println("Collaboratori di : " + autore1.getNome() + " " + autore1.getCognome());
			System.out.println("----------------------");
			
			// Stampa l'elenco dei collaboratori di autore1
			for (Autore autore2 : collaboratori) {
				System.out.println(autore2);
			}
			
			System.out.println("----------------------");
		}
		
		// TEST DEL METODO numAutori
		System.out.println("Numero di autori: " + collaborazioni1.numAutori()); // Stampa il numero di autori
		
		// TEST DEL METODO numColl
		System.out.println("Numero di collaborazioni "  + collaborazioni1.numCollaborazioni()); // Stampa il numero di collaborazioni
		
		
		Autori listaAutori = new Autori();
		
		// TEST DEL METODO add
		for (Autore a : autoriOrig) {
			listaAutori.add(a);
		}
		
		// TEST DEL METODO collaborano
		boolean collaborano = collaborazioni1.collaborano(listaAutori);
		
		System.out.println(collaborano);

		// Chiede di stampare gli autori della pubblicazione 'Articolo sul...versione 0' del 1980
		Autori autoriLavoro = collaborazioni1.autori("Articolo sul divertentismo negli anni 90 versione 0", 1980);

		System.out.println("Autori della pubblicazione: 'Articolo sul divertentismo negli anni 90 versione 0'");
		
		for (Autore autore : autoriLavoro) {
			System.out.println("\t" + autore);
		}
	}

	
	// INIZIALIZZA L'ELENCO DEGLI AUTORI
	private static List<Autore> initAutori() {
		
		List<Autore> autori = new ArrayList<Autore>();
		
		Autore autore1 = new Autore("Malerba", "Donato", "uniba");
		Autore autore2 = new Autore("Ceci", "Michelangelo", "uniba");
		Autore autore3 = new Autore("Appice", "Annalisa", "uniba");
		Autore autore4 = new Autore("Loglisci", "Corrado", "uniba");
		Autore autore5 = new Autore("Fumarola", "Fabio", "uniba");
		Autore autore6 = new Autore("Ciampi", "Anna", "uniba");
		

		// Aggiunge gli autori alla List
		autori.add(autore1);
		autori.add(autore2);
		autori.add(autore3);
		autori.add(autore4);
		autori.add(autore5);
		autori.add(autore6);
		
		/* Stampa tutti gli autori
		for(Autore aut : autoriOrig) {
			System.out.println(aut);
		}*/
		
		return autori;
	}

	
	// INIZIALIZZA L'ELENCO DELLE COLLABORAZIONI
	private static Collaborazioni initCollaborazione(List<Autore> autori, int numArticoli, int maxCollaboratori) {

		Collaborazioni newColl = new Collaborazioni();

		Random rndColl = new Random();
		Random rndMax = new Random(); // Max. 2 collaboratori
		
		// Imposta il titolo 
		String titolo = "Articolo sul divertentismo negli anni 90 versione ";
		int versione = 0;
		
		// Imposta l'anno
		int anno = 1980;

		// per ogni articolo
		for (int i = 0; i < numArticoli; i++) {
			
			Set<Integer> autoriInseriti = new HashSet<Integer>();
			
			Autori artAutori = new Autori();

			int value = 0;
			
			while (value < 2) {
				value = rndMax.nextInt(maxCollaboratori) + 2;
			}

			for (int j = 0; j < value; j++) {
				int nextAutore = -1;
				
				do {
					nextAutore = rndColl.nextInt(autori.size());
				} while (autoriInseriti.contains(nextAutore));

				artAutori.add(autori.get(nextAutore));
				autoriInseriti.add(nextAutore);
			}
			
			// Aggiunge la nuova collaborazione
			newColl.aggiungiColl(artAutori, titolo + versione, anno);
			
			versione++;
			anno++;
		}

		return newColl;
	}
}