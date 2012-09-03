package lists.vector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RicercaArray {
		
	/*
	 * Algoritmo di ricerca sequenziale di un elemento in un array
	 */
	static boolean sequentialSearch(int A[], int x, int numeroConfronti[]){
		numeroConfronti[0]=0;
		boolean trovato=false;
		for(int i=0;i<A.length;i++){
			numeroConfronti[0]++;
			if(A[i]==x){
				trovato=true;
				break;
			}
		}
		return trovato;
	}

	/*
	 * Algoritmo di ricerca binaria di un elemento in un array ordinamento
	 */
	static boolean binarySearch(int A[], int x, int numeroConfronti[]){
		numeroConfronti[0]=0;
		boolean trovato=false;
		int inizio=0, fine=A.length-1;
		
		while(inizio<=fine && !trovato){
			int centro=(inizio+fine)/2;
			numeroConfronti[0]++;
			if(x==A[centro]){
				trovato=true;
			} else {
				numeroConfronti[0]++;
				if(x>A[centro]){
					inizio=centro+1;	
				} else {
					fine=centro-1;
				}
			}
		}
		
		return trovato;
	}
		
	/*
	 * Inizializza l'array di interi A con i numeri interi 1, 2, 3,..., A.length
	 * @param A
	 */
	static void inizializzaArrayCrescente(int A[]){
		int i;
		for(i=0;i<A.length;i++)
			A[i]=i+1;
	}
	
	/*
	 * Stampa gli elementi contenuti nell'array A
	 * @param A
	 */
	static void stampaArray(int A[]){
		int i;
		for(i=0;i<A.length;i++)
			System.out.print(A[i]+ " ");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int A[] = new int[20];
		int numeroConfronti[] = new int[1];
		
		inizializzaArrayCrescente(A);
		
		try{
			System.out.print("Elemento da cercare: ");
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