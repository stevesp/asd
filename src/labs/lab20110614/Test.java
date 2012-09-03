package labs.lab20110614;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import labs.lab20110614.referendum.Quesito;
import labs.lab20110614.referendum.Referendum;
import labs.lab20110614.referendum.Voto;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int votanti = 20;
		Referendum r = new Referendum(votanti);
		List<Quesito<Voto>> quesiti = new ArrayList<Quesito<Voto>>(4);
		
		Quesito<Voto> q1 = new Quesito<Voto>();
		q1.quesito = "abrograzione delle prove di esame";
		quesiti.add(q1);
		
		Quesito<Voto> q2 = new Quesito<Voto>();
		q2.quesito = "abrograzione della frequenza obbligatoria";
		quesiti.add(q2);
		
		Quesito<Voto> q3 = new Quesito<Voto>();
		q3.quesito = "abrograzione delle tasse universitarie";
		quesiti.add(q3);
		
		Quesito<Voto> q4 = new Quesito<Voto>();
		q4.quesito = "abrograzione del diritto allo studio";
		quesiti.add(q4);
		
		Random rndNumVoti = new Random();
		Random rndVoto = new Random();
		
		int numComplessivoVoti = 0;
		
		for(Quesito<Voto> q:quesiti){
			r.aggiungiQuesito(q);
			int numVoti = rndNumVoti.nextInt(14) + 7;
			numComplessivoVoti += numVoti;
			for (int i = 0; i < numVoti; i++){
				Voto v = Voto.values()[rndVoto.nextInt(Voto.values().length)];
				r.scrutinaVoto(q, v);
			}	
		}
		
		for (Quesito<Voto> q : quesiti) {
			System.out.println("-------------------------------------");
			System.out.println(q);
			System.out.println("numero voti: "+ numComplessivoVoti);
		
			if (r.quorum(q))
				System.out.println("quorum raggiunto");
			else
				System.out.println("quorun non raggiunto");
		}
		
		
	
	}

}
