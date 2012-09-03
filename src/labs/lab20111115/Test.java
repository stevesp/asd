package labs.lab20111115;

import java.util.ArrayList;
import java.util.Random;

import labs.lab20111115.elezione.Elezione;
import labs.lab20111115.elezione.ListaElettorale;
import labs.lab20111115.elezione.Voto;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Elezione e = new Elezione(50);
		
		ListaElettorale[] liste = new ListaElettorale[]{new ListaElettorale("W l'Italia",new ArrayList<String>()),
								  new ListaElettorale("In medio stat virtus",new ArrayList<String>()),
								  new ListaElettorale("Ecumenismo a sinistra",new ArrayList<String>()),
								  new ListaElettorale("Metamorfosi",new ArrayList<String>())};

		e.aggiungiLista(liste[0]);
		e.aggiungiLista(liste[1]);
		e.aggiungiLista(liste[2]);
		e.aggiungiLista(liste[3]);
		
		Voto v = null;
		
		for (int i=0; i<30; i++){
			int random = new Random().nextInt(6);
				
			switch(random){
				case 0: v = new Voto(liste[0]); break;
				case 1: v = new Voto(liste[1]); break;
				case 2: v = new Voto(liste[2]); break;
				case 3: v = new Voto(liste[3]); break;
				case 4: v = new Voto(); break;
				default: v = new Voto(null);
			}
			
			System.out.println("Voto: "+v);
			e.scrutinaVoto(v);
		}		

		System.out.println("Schede Bianche: "+e.bianche());
		System.out.println("Schede Nulle: "+e.nulle());
		e.elencoOrdinato();
		
	}

}
