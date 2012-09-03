package labs.lab20120117;

import java.util.Random;

import labs.lab20120117.articoli.*;
import labs.lab20120117.spesa.Carrello;
import labs.lab20120117.spesa.Item;
import labs.lab20120117.spesa.MarketBasketAnalysis;

public class Test {
	public static void main(String[] args){
		
		Articolo[] articoli = new Articolo[]{new Pane(),
											 new Burro(),
											 new Spaghetti(),
											 new Cereali(),
											 new Sapone(),
											 new Dentifricio(),
											 new Tovagliolini(),
											 new Piatti()};
		
		Carrello[] carrelli = new Carrello[10];
		
		Random rndNumElementi = new Random();
		Random rndQuantita = new Random();
		
		for(int i=0; i<carrelli.length; i++){
			carrelli[i] = new Carrello();
			if (i % 2 == 0)
				carrelli[i].backward();
			else
				carrelli[i].forward();
			
			int numElementi = 0;
			while(numElementi < 1)
				numElementi = rndNumElementi.nextInt(articoli.length + 1) + 1;
				
			for(int j = 0; j < numElementi; j++){
				int quantita = rndQuantita.nextInt(6) + 1;
				carrelli[i].add(new Item(articoli[j],quantita));
			}
		}
		
		MarketBasketAnalysis m = new MarketBasketAnalysis();
		
		for(int i=0; i < carrelli.length; i++){
			System.out.println("Carrello "+(i+1)+": ");
			m.add(carrelli[i]);
		}

		System.out.println();
		System.out.println(m);
	}
}
