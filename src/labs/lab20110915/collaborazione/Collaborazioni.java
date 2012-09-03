package lab20110915.collaborazione;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lab20110915.autori.Autore;
import lab20110915.autori.Autori;

public class Collaborazioni implements Iterable<Collaborazione>{

	Autore[] nodi = new Autore[0]; 
	Collaborazione[] archi = new Collaborazione[0];
	
	public Collaborazioni() { 
	}
	
	public void aggiungiColl(Autori autori, String titolo, int anno){
		for(Autore a:autori)
			if(!presente(a))
				add(a);
		
		for(Autore a:autori)
			for(Autore b:autori){
				try {
					Collaborazione c = new Collaborazione(a, b, titolo, anno);
					if (!presente(c))
						add(c);
				} catch(EccezioneAnnoNonValido e){
					throw e;
				} catch(EccezioneStessoAutore e){
					System.out.println(e);
				}
			}
	}
	
	private boolean presente(Collaborazione collaborazione) {
		try {
			for(Collaborazione c:this.archi)
				if(c.compareTo(collaborazione) == 0)
					return true;
		} catch(EccezioneStessoAutore e) {
		} catch(EccezioneAnnoNonValido e) {
		}
		
		return false;
	}

	private boolean presente(Autore autore) {
		for(Autore a:this.nodi)
			if(a.compareTo(autore) == 0 )
				return true;
		
		return false;
	}

	private void add(Collaborazione collaborazione) {
		this.archi = Arrays.copyOf(this.archi, this.archi.length + 1);
		
		this.archi[this.archi.length-1] = collaborazione;
	}
	
	private void add(Autore autore) {
		this.nodi = Arrays.copyOf(this.nodi, this.nodi.length + 1);
		
		this.nodi[this.nodi.length-1] = autore;
	}
	
	public Autori collaboratori(Autore autore){
		
		if (!presente(autore))
			throw new AutoreNonEsistenteException();
		
		Autori collaboratori = new Autori();
	
		for(Collaborazione c : this.archi)
			if(c.autoreA.compareTo(autore) == 0)
				collaboratori.add(c.autoreB);
	
		return collaboratori;
	}
	
	public int numAutori(){
		return this.nodi.length;
	}
	
	public int numCollaborazioni(){
		Set<String> setArticoli = new HashSet<String>();
		
		for (Collaborazione c : this.archi)
			setArticoli.add(c.titolo +" "+ c.anno);
		
		return setArticoli.size();
	}
	
	public boolean collaborano(Autori autori){
		for(Autore a : autori){
			Autori adiacenti = collaboratori(a);
			adiacenti.add(a);
			
			if(!incluso(adiacenti, autori))
				return false;
		}
		
		return true;
	}

	private boolean incluso(Autori adiacenti, Autori autori) {
		for(Autore a : autori)
			if (!presente(a))
				throw new AutoreNonEsistenteException();
		
		for(Autore a : autori){
			for(Autore b : adiacenti){
				if(a.compareTo(b) != 0)
					return false;
			}
		}
		
		return true;
	}

	public Autori autori(String titolo, int anno){
		Autori autori = new Autori();
		
		for(Collaborazione c : this.archi)
			if((c.titolo.compareTo(titolo) == 0) && c.anno == anno)
				autori.add(c.autoreA);
		
		return autori;
	}
	
	public boolean incluso(Collaborazioni collaborazione){
		for(Autore a : this.nodi)
			if(!collaborazione.presente(a))
				return false;
		
		for(Collaborazione c : this.archi)
			if(!collaborazione.presente(c))
				return false;
				
		return true;
	}

	@Override
	public Iterator<Collaborazione> iterator() {
		return new CollaborazioniIterator(this);
	}
}
