package lab20120210;

import lab20120210.orologio.OrologioDaPolso;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		System.out.println("Creo il primo orologio");
		OrologioDaPolso orologio1 = new OrologioDaPolso();
		System.out.println("Creo il secondo orologio");
		OrologioDaPolso orologio2 = new OrologioDaPolso();
		
		System.out.println();
		System.out.println("Avvio: ");
		orologio1.start();
		
		System.out.println();
		if(orologio1.equals(orologio2))
			System.out.println("Gli orologi sono uguali");
		else
			System.out.println("Gli orologi NON sono uguali");
	}

}
