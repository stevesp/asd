package labs.lab20100712.pq;

public interface PQ<Item> {

	public boolean isNew();

	public void insert(Item item, Priority priority);

	public Item first();

	public void delFirst();

	public void changePriority(Item item, Priority priority);

	public Priority getPriority(Item item);

	public int size();

}
