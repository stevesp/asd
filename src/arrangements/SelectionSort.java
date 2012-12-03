package arrangements;

public class SelectionSort {

	private static void swap(Integer A[], Integer x, Integer y) {
		Integer tmp = new Integer(A[x]);
		A[x] = A[y];
		A[y] = tmp;
	}

	/*
	 * SelectionSort
	 */

	public static Integer sort(Integer A[]) {
		Integer numeroConfronti = new Integer(0);
		Integer min, j;

		for (Integer k = -1; k <= A.length - 2; k++) {
			min = k + 1;
			for (j = k + 2; j <= A.length - 1; j++) {
				numeroConfronti++;
				if (A[j] < A[min])
					min = j;
			}
			if (min != k + 1)
				swap(A, min, k + 1);
		}

		return numeroConfronti;
	}
}
