package lab20110215;

import lab20110215.circlist.CircList;
import lab20110215.circlist.Direction;
import lab20110215.circlist.ListCircDL;
import lab20110215.processo.Processo;

public class Scheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircList<Processo> processi = new ListCircDL<Processo>();
		processi.setDir(Direction.FORWARD);
		
		final int TIME_SLICE = 100;
		
		int i = 0;
		
		while(true){
			System.out.println("Iterata "+(i+1));
			if (i < 6)
				processi.addCircList(new Processo());
			
			for(Processo p:processi)
				System.out.println(p);
			
			if (processi.value().execute(TIME_SLICE)){
				System.out.println("Processo "+processi.value().getID()+" completato");
				processi.delCircList();
			}
			
			if(processi.isEmpty())
				break;
			
			processi.ruota();
			
			i++;
		}
	}

}
