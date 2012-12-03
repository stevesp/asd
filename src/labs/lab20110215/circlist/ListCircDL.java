package labs.lab20110215.circlist;

import java.util.Iterator;

public class ListCircDL<T> implements CircList<T> {

	private Cella<T> listHead;
	private Direction direction;
	private int count;

	public ListCircDL() {
		this.listHead = null;
		this.direction = null;
	}

	private class Cella<T> {
		T elem;
		Cella<T> next, prev;

		Cella(T elem) {
			this.elem = elem;
			this.next = this.prev = this;
		}
	}

	@Override
	public Iterator<T> iterator() {
		if (direction == null)
			throw new EccezioneDirezioneVuota("Direzione non impostata");

		return new ListCircDLIterator<T>();
	}

	@Override
	public void addCircList(T object) {
		Cella<T> _new = new Cella<T>(object);

		if (isEmpty())
			listHead = new Cella<T>(object);
		else {
			switch (direction) {
			case FORWARD:
				listHead.prev.next = _new;
				_new.prev = listHead.prev;
				_new.next = listHead;
				listHead.prev = _new;
				break;
			case BACKWARD:
				listHead.next.prev = _new;
				_new.next = listHead.next;
				_new.prev = listHead;
				listHead.next = _new;
				break;
			default:
				throw new EccezioneDirezioneVuota("Direzione non impostata");
			}
		}

		this.count++;
	}

	@Override
	public void delCircList() {
		if (isEmpty())
			throw new EccezioneListaVuota();

		if (listHead.next == listHead)
			listHead = null;
		else
			switch (direction) {
			case FORWARD:
				listHead.next.prev = listHead.prev;
				listHead = listHead.next;
				listHead.prev.next = listHead;
				break;
			case BACKWARD:
				listHead.prev.next = listHead.next;
				listHead = listHead.prev;
				listHead.next.prev = listHead;
				break;
			default:
				throw new EccezioneDirezioneVuota("Direzione non impostata");
			}

		this.count--;
	}

	@Override
	public T value() {
		if (isEmpty())
			throw new EccezioneListaVuota();

		switch (direction) {
		case FORWARD:
			return listHead.elem;
		case BACKWARD:
			return listHead.elem;
		default:
			throw new EccezioneDirezioneVuota("Direzione non impostata");
		}
	}

	@Override
	public boolean isEmpty() {
		return listHead == null;
	}

	@Override
	public int numItem() {
		return count;
	}

	@Override
	public void setDir(Direction d) {
		switch (d) {
		case FORWARD:
			direction = d;
			break;
		case BACKWARD:
			direction = d;
			break;
		default:
			throw new EccezioneDirezioneVuota("Direzione non impostata");
		}
	}

	@Override
	public void ruota() {
		if (isEmpty())
			throw new EccezioneListaVuota();

		switch (direction) {
		case FORWARD:
			listHead = listHead.next;
			break;
		case BACKWARD:
			listHead = listHead.prev;
			break;
		default:
			throw new EccezioneDirezioneVuota("Direzione non impostata");
		}
	}

	private class ListCircDLIterator<T> implements Iterator<T> {

		private Cella<T> current;
		private int pos;

		public ListCircDLIterator() {
			this.current = (Cella<T>) listHead;
			this.pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < numItem();
		}

		@Override
		public T next() {
			Cella<T> tmp = this.current;

			switch (direction) {
			case FORWARD:
				this.current = this.current.next;
				pos++;
				break;
			case BACKWARD:
				this.current = this.current.prev;
				pos++;
				break;
			default:
				throw new EccezioneDirezioneVuota("Direzione non impostata");
			}

			return tmp.elem;
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

	}

}
