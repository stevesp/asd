package queues;

public interface Coda {
	public boolean isEmpty();
	public void enqueue(Object e);
	public Object first();
	public void dequeue();
}


