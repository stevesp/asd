package arrangements;

public class BubbleSort {

	private static void swap(Comparable<Object> A[], Integer x, Integer y) {
		Comparable<Object> tmp = A[x];
		A[x] = A[y];
		A[y] = tmp;
	}

	private static void swap(Integer A[], Integer x, Integer y) {
		Integer tmp = new Integer(A[x]);
		A[x] = A[y];
		A[y] = tmp;
	}

	/*
	 * Algoritmo bubblesort per l'ordinamento di un array di oggetti A per
	 * iquali sia definita una relazione d'ordine totale "<="
	 * 
	 * @param A
	 */
	public static Integer sort(Comparable<Object> A[]) {
		Integer numeroConfronti = new Integer(0);

		for (Integer i = new Integer(1); i <= A.length - 1; i++) {
			boolean scambiAvvenuti = false;

			for (Integer j = new Integer(1); j <= A.length - i; j++) {
				numeroConfronti++;

				if (A[j].compareTo(A[j - 1]) < 0) {
					swap(A, j, j - 1);
					scambiAvvenuti = true;
				}
			}

			if (!scambiAvvenuti)
				break;
		}

		return numeroConfronti;
	}

	public static Integer sort(Integer A[]) {
		Integer numeroConfronti = new Integer(0);

		for (Integer i = new Integer(1); i <= A.length - 1; i++) {
			boolean scambiAvvenuti = false;

			for (Integer j = 1; j <= A.length - i; j++) {
				numeroConfronti++;

				if (A[j].compareTo(A[j - 1]) < 0) {
					swap(A, j, j - 1);
					scambiAvvenuti = true;
				}
			}

			if (!scambiAvvenuti)
				break;
		}

		return numeroConfronti;
	}
}
