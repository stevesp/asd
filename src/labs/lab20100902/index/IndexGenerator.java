package labs.lab20100902.index;

import labs.lab20100902.abr.ABR;
import labs.lab20100902.abrpf.ABRPF;

public class IndexGenerator {
	
	private ABR indice = new ABRPF();
	
	public void buildIndex(String text){
		String[] righe = text.split(" \\* ");
		
		String[] parole;	
		for(int i=0; i < righe.length; i++){
			parole = righe[i].split(" ");
			
			for(String s:parole)
				indice.inserisciABR(new Valore(s, i));
		}
	}
	
	public void showIndex(){
		for(Object i:indice)
			System.out.println(i);
	}
	
}
