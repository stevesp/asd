package arrangements;

public class MergeSort {
	
	private static void swap(Integer A[], Integer x, Integer y){
		Integer tmp = new Integer( A[x] );
		A[x] = A[y];
		A[y] = tmp;
	}

	private static Integer merge(Integer A[], Integer p, Integer q, Integer r){
		Integer numeroConfronti = new Integer(0);
		Integer p1 = new Integer(p);
		Integer q1 = new Integer(q+1);
		Integer k = new Integer(0);
		Integer aus[] = new Integer[A.length];
		
		numeroConfronti++;
		while( ( p1 <= q ) && ( q1 <= r ) ){
			numeroConfronti++;
			if( A[p1] < A[q1] ){
				aus[k] = A[p1];
				p1++;
			} else {
				aus[k] = A[q1];
				q1++;
			}
			k++;
		}
		if( p1 <= q ){
			Integer inizio = q;
			for( Integer fine = r; fine >= p+k; fine-- ){
				swap(A, fine, inizio);
				inizio--;
			}
		}
		for( Integer inizio = new Integer(0); inizio <= k-1; inizio++ )
			A[p+inizio] = aus[inizio];
		
		return numeroConfronti;
	}
	
	/*
	 * MergeSort
	 */
	public static Integer sort( Integer A[], Integer inf, Integer sup){
		Integer numeroConfronti = new Integer(0);
		
		if( inf < sup ){
			Integer m = new Integer( (inf+sup)/2 );
			sort( A, inf, m );
			sort( A, m+1, sup );
			numeroConfronti = numeroConfronti + merge( A, inf, m, sup );
		}
		
		return numeroConfronti;
	}

}
