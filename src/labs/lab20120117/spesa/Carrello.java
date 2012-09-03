package lab20120117.spesa;

import java.util.Iterator;

import lab20120117.list.AddOnlyList;

public class Carrello implements AddOnlyList<Item>, Iterable<Item> {

	private Record dummy;
	private Direction direction = null;
	
	private class Record {
		Item elem;
		Record next, prev;
		
		Record(Item e) {
			this.elem = e;
			this.next = this.prev = this;
		}
	}
	
	public Carrello() {
		this.dummy = new Record(null);
	}
	
	@Override
	public Iterator<Item> iterator() {
		if (direction == null)
			throw new EccezioneDirezioneNonImpostata("Bisogna impostare la direzione FORWARD o BACKWARD");
		
		return new CarrelloIterator();
	}

	@Override
	public void forward() {
		this.direction = Direction.FORWARD;
	}

	@Override
	public void backward() {
		this.direction = Direction.BACKWARD;
	}

	@Override
	public void add(Item e) {
		Record _new = new Record(e);
		
		dummy.prev.next = _new;
		_new.prev = dummy.prev;
		_new.next = dummy;
		dummy.prev = _new;
	}
	
	private class CarrelloIterator implements Iterator<Item> {

		private Record current;
		
		private final Direction dir;

		public CarrelloIterator() {
			this.dir = direction;
			this.current = dummy;
		}
		
		@Override
		public boolean hasNext() {
			boolean value = false;
			
			switch(dir){
			case FORWARD:
				value = current.next != dummy;
				break;
			case BACKWARD:
				value = current.prev != dummy;
				break;
			default:
				throw new IllegalArgumentException();
			}

			return value;
		}

		@Override
		public Item next() {			
			switch(dir){
			case FORWARD:
				current = current.next; 
				break;
			case BACKWARD:
				current = current.prev;
				break;
			default:
				throw new IllegalArgumentException();
			}
			
			return current.elem;
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

	}

}
