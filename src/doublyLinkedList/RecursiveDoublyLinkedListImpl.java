package doublyLinkedList;

import singlyLinkedList.RecursiveSinglyLinkedListImpl;

public class RecursiveDoublyLinkedListImpl<T> extends RecursiveSinglyLinkedListImpl<T> implements DoublyLinkedList<T> {

	protected RecursiveDoublyLinkedListImpl<T> previous;

	public RecursiveDoublyLinkedListImpl() {

	}

	public RecursiveDoublyLinkedListImpl(T data, RecursiveDoublyLinkedListImpl<T> previous,
			RecursiveSinglyLinkedListImpl<T> next) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				setData(element);
				setNext(new RecursiveDoublyLinkedListImpl<T>(null, null, this));
				if (getPrevious() == null) {
					setPrevious(new RecursiveDoublyLinkedListImpl<T>(null, this, null));
				}
			} else {
				castToDoubly(getNext()).insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				insert(element);
			} else {
				RecursiveDoublyLinkedListImpl<T> copy = new RecursiveDoublyLinkedListImpl<T>(getData(), this, getNext());
				setData(element);
				castToDoubly(getNext()).setPrevious(copy);
				setNext(copy);
			}
		}

	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				if (!getData().equals(element)) {
					castToDoubly(getNext()).remove(element);
				} else if (element.equals(getData())) {
					setData(getNext().getData());
					setPrevious(castToDoubly(this.getNext()).getPrevious());
					setNext(getNext().getNext());
				}
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (getNext().isEmpty()) {
				setData(null);
				setNext(null);
				setPrevious(null);
			} else {
				setData(getNext().getData());
				castToDoubly(getNext().getNext()).setPrevious(this);
				setNext(getNext().getNext());
			}
		}

	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.getNext().isEmpty()) {
				if (getPrevious().isEmpty()) {
					setData(null);
					setNext(null);
					setPrevious(null);
				} else {
					setData(null);
					setNext(null);
				}
			} else {
				castToDoubly(getNext()).removeLast();
			}
		}

	}

	@SuppressWarnings("unchecked")
	private RecursiveDoublyLinkedListImpl<T> castToDoubly(Object object) {
		RecursiveDoublyLinkedListImpl<T> rtn = new RecursiveDoublyLinkedListImpl<>();
		if (object instanceof RecursiveSinglyLinkedListImpl) {
			rtn = (RecursiveDoublyLinkedListImpl<T>) object;
		}
		return rtn;
	}

	public RecursiveDoublyLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoublyLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
