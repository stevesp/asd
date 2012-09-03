package labs.lab20100712;

import java.util.Random;

import labs.lab20100712.codall.CodaLL;
import labs.lab20100712.pq.EccezionePrioritaNonValida;
import labs.lab20100712.pq.PQ;
import labs.lab20100712.pq.Priority;
import labs.lab20100712.pql.Process;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PQ<Process> unrunnable = new CodaLL<Process>();
		PQ<Process> runnable = new CodaLL<Process>();
		PQ<Process> stopped = new CodaLL<Process>();
		
		Process[] processi = new Process[15];
		Random random = new Random();
		
		System.out.println("*** Genero i processi ***");
		for(int i=0; i < 15; i++){
			processi[i] = new Process("processo "+i, random.nextInt(101));
			System.out.println("Creato il nuovo processo "+processi[i]);
			try {
				unrunnable.insert(processi[i], new Priority(processi[i].getPriority()));
			} catch (EccezionePrioritaNonValida e){
				System.out.println(e);
			}
		}
		System.out.println("UNRUNNABLE.size() = "+unrunnable.size());
		
		System.out.println("*** Rendo i processi eseguibili ***");
		Process tmp;
		while(unrunnable.size() != 0){
			tmp = unrunnable.first();
			tmp.setState(1);
			System.out.println("Sposto "+tmp+" in RUNNABLE");
			runnable.insert(tmp, unrunnable.getPriority(tmp));
			unrunnable.delFirst();
		}
		System.out.println("RUNNABLE.size() = "+runnable.size());
		
		int stato = 1;
		System.out.println("*** Sposto i processi nelle code unrunnable/stopped ***");
		while(runnable.size() != 0){
			tmp = runnable.first();
			
			while(stato == 1)
				stato = random.nextInt(3);
			
			tmp.setState(stato);
			tmp.setPriority(random.nextInt(101));
			if(stato == 0){
				System.out.println("Sposto il processo "+tmp+" in UNRUNNABLE");
				unrunnable.insert(tmp, runnable.getPriority(tmp));
			} else {
				System.out.println("Sposto il processo "+tmp+" in STOPPED");
				stopped.insert(tmp, runnable.getPriority(tmp));
			}
			
			runnable.delFirst();
			stato = 1;
		}
		System.out.println("UNRUNNABLE.size() = "+unrunnable.size());
		System.out.println("RUNNABLE.size() = "+runnable.size());
		System.out.println("STOPPED.size() = "+stopped.size());
	}

}