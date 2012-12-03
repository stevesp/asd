package arrangements;

public class QuickSort {

	private static void swap(Integer A[], Integer x, Integer y) {
		Integer tmp = new Integer(A[x]);
		A[x] = A[y];
		A[y] = tmp;
	}

	/*
	 * Partiziona il vettore rispetto all'elemento x e restiutisce il punto di
	 * separazione
	 */
	private static Integer partition(Integer A[], Integer inf, Integer sup,
			Integer[] numConfronti) {
		Integer i = new Integer(inf);
		Integer j = new Integer(sup);
		numConfronti[0] = 0;
		Integer med = new Integer((inf + sup) / 2);
		Integer x = new Integer(A[med]);

		swap(A, inf, med);

		while (true) {
			numConfronti[0]++;

			while ((i <= sup) && (A[i] <= x)) {
				i++;
				numConfronti[0]++;
			}

			numConfronti[0]++;
			while (A[j] > x) {
				j--;
				numConfronti[0]++;
			}

			if (i < j)
				swap(A, i, j);
			else
				break;
		}
		swap(A, inf, j);

		return j;
	}

	/*
	 * QuickSort
	 */
	public static Integer sort(Integer A[], Integer inf, Integer sup) {
		Integer numeroConfronti[] = new Integer[1];

		if (sup - inf >= 1) {
			Integer pos = partition(A, inf, sup, numeroConfronti);
			if ((pos - inf) < (sup - pos + 1)) {
				sort(A, inf, pos - 1);
				sort(A, pos + 1, sup);
			} else {
				sort(A, pos + 1, sup);
				sort(A, inf, pos - 1);
			}
		}

		return numeroConfronti[0];
	}

}
