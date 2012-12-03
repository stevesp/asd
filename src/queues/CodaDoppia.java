package queues;

public interface CodaDoppia {
	public boolean isEmpty();

	public void enqueue(Object e);

	public Object first();

	public void dequeue();

	public void push(Object e);

	public Object top();

	public void pop();
}
