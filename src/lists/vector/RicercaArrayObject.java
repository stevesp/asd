package lists.vector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import arrangements.BubbleSort;

import objects.Studente;

public class RicercaArrayObject {

	/*
	 * Algoritmo di ricerca sequenziale di un elemento in un array
	 */
	static boolean sequentialSearch(Comparable<Object> A[], int x, int numeroConfronti[]) {
		numeroConfronti[0]=0;
		boolean trovato=false;
		
		for(int i=0;i<A.length;i++){
			numeroConfronti[0]++;
			if(((Studente) A[i]).getNroLodi()==x){
				trovato=true;
				break;
			}
		}
		
		return trovato;
	}
	
	/*
	 * Algoritmo di ricerca binaria di un elemento in un array ordinamento
	 */
	static boolean binarySearch(Comparable<Object> A[], int x, int numeroConfronti[]) {
		numeroConfronti[0]=0;
		boolean trovato=false;
		int inizio=0, fine=A.length-1;
		
		while(inizio<=fine && !trovato){
			int centro=(inizio+fine)/2;
			numeroConfronti[0]++;
			if(((Studente) A[centro]).getNroLodi()==x){
				trovato=true;
			} else {
				numeroConfronti[0]++;
				if(((Studente) A[centro]).getNroLodi()<x)
					inizio=centro+1;
				else
					fine=centro;
			}
		}
		
		return trovato;
	}
	
	/*
	 * Stampa gli elementi contenuti nell'array A
	 * @param A
	 */
	private static void stampaArray(Comparable<Object> A[]){
		for(int i=0;i<A.length;i++)
			System.out.println(A[i]+ " ");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Studente A[] = new Studente[10];
		for (int i=0; i<A.length; i++)
			A[i]=new Studente();
		int numeroConfronti[] = new int[1];
		
		stampaArray(A);
		BubbleSort.sort(A);
		stampaArray(A);
		
		try {
			System.out.print("Numero Lodi: ");
			int elemento=Integer.parseInt(in.readLine());
			if(binarySearch(A, elemento, numeroConfronti))
				System.out.println(elemento+" trovato con "+numeroConfronti[0]+" confronti");
			else
				System.out.println(elemento+" NON trovato con "+numeroConfronti[0]+" confronti");
		} catch (IOException e){
			System.out.println(e);
		}
	}

}