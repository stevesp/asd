package arrangements;

public class InsertionSort {

	private static void swap(Integer A[], Integer x, Integer y) {
		Integer tmp = new Integer(A[x]);
		A[x] = A[y];
		A[y] = tmp;
	}

	private static Integer indiceElementoMinimo(Integer A[]) {
		Integer minimo = new Integer(0);

		for (Integer i = new Integer(0); i < A.length; i++)
			if (A[minimo] > A[i])
				minimo = i;

		return minimo;
	}

	/*
	 * InsertionSort
	 */
	public static Integer sort(Integer A[]) {
		Integer numeroConfronti = new Integer(A.length - 1); // perchè la
																// ricerca del
																// minimo
																// richiederà
																// n-1 confronti
		Integer minJ = indiceElementoMinimo(A);
		Integer k, j, h;

		swap(A, minJ, 0);
		for (k = new Integer(1); k <= A.length - 2; k++) {
			Integer X = new Integer(A[k + 1]);
			for (j = k; j >= 1; j--) {
				numeroConfronti++;
				if (A[j] < X)
					break;
			}
			for (h = k; h >= j + 1; h--)
				A[h + 1] = A[h];
			A[j + 1] = X;
		}

		return numeroConfronti;
	}

}
