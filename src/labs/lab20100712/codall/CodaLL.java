package labs.lab20100712.codall;

import java.util.LinkedList;

import labs.lab20100712.pq.PQ;
import labs.lab20100712.pq.Priority;
import labs.lab20100712.pql.PQL;

public class CodaLL<Item> extends PQL<Item> {
	
	public CodaLL() {
		coda = new LinkedList<Item>();
	}
	
	public static void main(String[] args){
		PQ<String> pq = new CodaLL<String>();
		
		pq.insert(new String("/bin/bash"), new Priority(1));
		pq.insert(new String("/bin/test"), new Priority(6));
		
		System.out.println("Size: "+pq.size());
		
		System.out.println(pq.first());
		pq.delFirst();
		System.out.println(pq.first());
		System.out.println(pq.getPriority(pq.first()));
		
		pq.changePriority(pq.first(), new Priority(18));
		System.out.println(pq.getPriority(pq.first()));
		
		System.out.println("Size: "+pq.size());
	}

}
