package labs.lab20100222;

import java.util.Random;

import labs.lab20100222.layout.Block;
import labs.lab20100222.layout.EccezionePosizioneNonCorretta;
import labs.lab20100222.layout.Layout;
import labs.lab20100222.layout.Point2D;
import labs.lab20100222.layout.TypeC;
import labs.lab20100222.listaarray.EccezionePosizioneOccupata;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Layout layout = new Layout();
		Random random = new Random();
		
		int MAX = 6;
		Block[] blocchi = new Block[MAX];
		
		TypeC[] tcvalues = TypeC.values();

//		for(int i=0; i < MAX; i++){
//			
//			int jTC = -1;
//			jTC = random.nextInt(tcvalues.length);
//			while (jTC < 0)
//				jTC = random.nextInt(tcvalues.length);
//			
//			int xTL = -1;
//			xTL = random.nextInt(300);
//			while (xTL < 0)
//				xTL = random.nextInt(300);
//						
//			int yTL = -1;
//			yTL = random.nextInt(300);
//			while (yTL < 0)
//				yTL = random.nextInt(300);
//			
//			int xBR = -1;
//			xBR = random.nextInt(300);
//			while (xBR < 0)
//				xBR = random.nextInt(300);
//						
//			int yBR = -1;
//			yBR = random.nextInt(300);
//			while (yBR < 0)
//				yBR = random.nextInt(300);
//			
//			blocchi[i] = new Block(new Point2D(xTL, yTL), 
//					new Point2D(xBR, yBR), tcvalues[jTC]);
//		}
		
			blocchi[0] = new Block(new Point2D(10, 200), 
			new Point2D(50, 180), TypeC.GRAPHICS);

			blocchi[1] = new Block(new Point2D(10, 179), 
			new Point2D(50, 150), TypeC.TEXT);

			blocchi[2] = new Block(new Point2D(10, 149), 
			new Point2D(30, 100), TypeC.TEXT);

			blocchi[3] = new Block(new Point2D(10, 99), 
			new Point2D(30, 20), TypeC.TEXT);

			blocchi[4] = new Block(new Point2D(35, 99), 
			new Point2D(50, 20), TypeC.GRAPHICS);

			blocchi[5] = new Block(new Point2D(31, 149), 
			new Point2D(50, 100), TypeC.GRAPHICS);
	
		try {
			for(Block b : blocchi)
				layout.addBlock(b);
			
			layout.addAbove(blocchi[0], blocchi[1]); 
			layout.addAbove(blocchi[1], blocchi[2]);
			layout.addAbove(blocchi[2], blocchi[3]);
			layout.addLeft(blocchi[2], blocchi[5]);
			layout.addAbove(blocchi[5], blocchi[4]);
			layout.addLeft(blocchi[3], blocchi[4]);
					
		} catch (EccezionePosizioneOccupata e){
			System.out.println(e);
		} catch (EccezionePosizioneNonCorretta e){
			System.out.println(e);
		}
		
		for(Block b : blocchi)
			System.out.println(b+" *** vicini: "+layout.neighbour(b));
	}

}
