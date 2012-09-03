package lab20110915;

import lab20110915.autori.Autore;
import lab20110915.autori.Autori;
import lab20110915.collaborazione.Collaborazione;
import lab20110915.collaborazione.Collaborazioni;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collaborazioni asd = new Collaborazioni();
		Collaborazioni info = new Collaborazioni();
		
		Autore dona = new Autore(new String("Donato"),new String("Malerba"),new String("LACAM"));
		Autore nico = new Autore(new String("Nicola"),new String("Di Mauro"),new String("LACAM"));
		Autore peppe = new Autore(new String("Giuseppe"),new String("Visaggio"),new String("SERLAB"));
		Autore ni = new Autore(new String("Nicola"),new String("Fanizzi"),new String("LACAM"));
		Autore fa = new Autore(new String("Fabio"),new String("Fumarola"),new String("LACAM"));
		Autore giovi = new Autore(new String("Giovanna"),new String("Castellano"),new String("LACAM"));
		Autore nicola = new Autore(new String("Pasquale"),new String("Ardimento"),new String("SERLAB"));
		Autore gio = new Autore(new String("Giovanni"),new String("Dimauro"),new String("SERLAB"));
		
		Autori lista1 = new Autori();
		lista1.add(dona);
		lista1.add(nico);
		
		Autori lista2 = new Autori();
		lista2.add(peppe);
		lista2.add(ni);
		
		Autori lista3 = new Autori();
		lista3.add(dona);
		lista3.add(fa);
		
		Autori lista4 = new Autori();
		lista4.add(giovi);
		lista4.add(fa);
		
		Autori lista5 = new Autori();
		lista5.add(peppe);
		lista5.add(nicola);
		lista5.add(gio);
		
		asd.aggiungiColl(lista1, new String("libro1"), 1929);
		asd.aggiungiColl(lista2, new String("libro2"), 1988);
		asd.aggiungiColl(lista3, new String("libro3"), 2005);
		asd.aggiungiColl(lista4, new String("libro4"), 2007);
//		asd.aggiungiColl(lista1, new String("libro5"), 2023);
		
		info.aggiungiColl(lista5, new String("LibroITPS1"), 1990);
		info.aggiungiColl(lista2, new String("LibroITPS2"), 1970);
		info.aggiungiColl(lista1, new String("libroITPS3"), 1929);
		info.aggiungiColl(lista1, new String("Libro2"), 1980);
		info.aggiungiColl(lista3, new String("Libro1"), 1939);
		info.aggiungiColl(lista1, new String("libro1"), 1929);
		info.aggiungiColl(lista1, new String("libro1"), 1929);
		info.aggiungiColl(lista2, new String("libro2"), 1988);
		info.aggiungiColl(lista3, new String("libro3"), 2005);
		info.aggiungiColl(lista4, new String("libro4"), 2007);
		
		for(Collaborazione c:asd)
			System.out.println("ASD: "+ c);
				
		for(Collaborazione d:info)
			System.out.println("INFO: "+ d);
		
		if (asd.incluso(info))
			System.out.println("asd è incluso in info");
		else
			System.out.println("asd non è incluso in info");
	}
}
