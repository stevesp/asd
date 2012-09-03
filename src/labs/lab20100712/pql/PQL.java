package labs.lab20100712.pql;

import java.util.List;

import labs.lab20100712.pq.EccezionePrioritaNonValida;
import labs.lab20100712.pq.PQ;
import labs.lab20100712.pq.Priority;

public abstract class PQL<Item> implements PQ<Item> {

	protected List<Item> coda;
	private int size;
	
	@Override
	public boolean isNew() {
		return size == 0;
	}

	@Override
	public void insert(Item item, Priority priority) {
		for(int i = coda.size(); i < priority.getPriority(); i++)
			coda.add(i, null);
		
		coda.add(priority.getPriority(), item);
		size++;
	}

	@Override
	public Item first() {
		if(isNew())
			throw new EccezioneListaVuota();
		
		Item first = coda.get(0);
		
		for(int i = 1; i < coda.size(); i++){
			if(first != null)
				break;
			
			first = coda.get(i);
		}
		
		return first;
	}

	@Override
	public void delFirst() {
		if(isNew())
			throw new EccezioneListaVuota();
		
		Item first = coda.get(0);
		
		for(int i = 1; i < coda.size(); i++){
			if(first != null)
				break;
			
			first = coda.get(i);
		}
		
		coda.set(coda.indexOf(first), null);
		size--;
	}

	@Override
	public void changePriority(Item item, Priority priority) {
		if (coda.indexOf(item) == -1)
			throw new EccezioneElementoNonValido();
		
		coda.set(coda.indexOf(item), null);
		size--;
		insert(item, priority);
	}

	@Override
	public Priority getPriority(Item item) {
		Priority p = null;
		
		try {
			p = new Priority(coda.indexOf(item));
		} catch (EccezionePrioritaNonValida e){
			System.out.println(e);
		}
		
		return p;
	}

	@Override
	public int size() {
		return size;
	}

}
