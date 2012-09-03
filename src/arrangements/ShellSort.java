package arrangements;

public class ShellSort {

	private static Integer ordinaSingolaCatena(Integer A[], Integer i, Integer inc){
		Integer numeroConfronti = new Integer(0);
		
		Integer k = i+inc;
		while( k < A.length ){
			boolean inserito = false;
			Integer x = new Integer( A[k] );
			Integer corrente = k, precedente = corrente-inc;
			
			while( precedente >= i && ! inserito ){
				numeroConfronti++;
				if( x < A[precedente] ){
					// shift a destra dell'elemento A[precedente]
					A[corrente] = A[precedente];
					corrente = precedente;
					precedente = precedente-inc;
				} else
					inserito = true; // corrente rappresenta la posizione dove inserire l'elemento
			}
			A[corrente] = x;
			k = k+inc;
		}
		
		return numeroConfronti;
	}
	
	/*
	 * ShellSort
	 */
	public static Integer sort(Integer A[]){
		Integer numeroConfronti = new Integer(0);
		
		Integer inc = new Integer( A.length/2 );
		while( inc >= 1 ){
			for( Integer i = new Integer(0); i < inc; i++ )
				numeroConfronti = numeroConfronti + ordinaSingolaCatena(A, i, inc);
			inc = inc/2;
		}
		
		return numeroConfronti;
	}
	
}
