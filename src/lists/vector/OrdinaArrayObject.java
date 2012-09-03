package lists.vector;

import arrangements.BubbleSort;
import objects.Persona;
import objects.Studente;

public class OrdinaArrayObject {
	
	/*
	 * Stampa gli elementi contenuti nell'array A
	 * @param A
	 */
	private static void stampaArray(Object A[]){
		for(int i=0;i<A.length;i++)
			System.out.println(A[i]);
	}
	
	public static void main(String args[]) {

		Persona A[]= { new Persona("Malerba Donato"),
								new Persona("Appice Annalisa"),
								new Persona("Ceci Michelangelo"),
								new Persona("Visaggio Giuseppe"),
								new Persona("Fanelli Anna Maria"),
								new Persona("Plantamura Vito Leonardo"),
								new Persona("Plantamura Paola"),
								new Persona("Malerba Donato") };
		stampaArray(A);
		System.out.println("Ordinamento");
		BubbleSort.sort(A);
		stampaArray(A);

		Integer B[]= { new Integer(3),
							 new Integer(5),
							 new Integer(12),
							 new Integer(3),
							 new Integer(3),
							 new Integer(5),
							 new Integer(7),
							 new Integer(1) };
		stampaArray(B);
		System.out.println("Ordinamento");
		BubbleSort.sort(B);
		stampaArray(B);
		
		Studente C[] = new Studente[10];
		for (int i=0; i<C.length; i++)
			C[i]=new Studente();
		stampaArray(C);
		System.out.println("Ordinamento");
		BubbleSort.sort(C);
		stampaArray(C);
	}

}
