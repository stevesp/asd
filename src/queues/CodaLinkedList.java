package queues;

import java.util.LinkedList;

public class CodaLinkedList implements Coda {

	private LinkedList q = new LinkedList();

	public void enqueue(Object v) {
		q.addLast(v);
	}

	public Object first() {
		return q.getFirst();
	}

	public void dequeue() {
		q.removeFirst();
	}

	public boolean isEmpty() {
		return q.size() == 0;
	}
}
