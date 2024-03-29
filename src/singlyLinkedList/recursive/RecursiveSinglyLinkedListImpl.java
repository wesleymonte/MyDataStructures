package singlyLinkedList.recursive;

import singlyLinkedList.SinglyLinkedList;

public class RecursiveSinglyLinkedListImpl<T> implements SinglyLinkedList<T> {

	protected T data;
	protected RecursiveSinglyLinkedListImpl<T> next;

	public RecursiveSinglyLinkedListImpl(T data, RecursiveSinglyLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	public RecursiveSinglyLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return (this.getData() == null);
	}

	@Override
	public int size() {
		int i = 0;
		if (!this.isEmpty()) {
			i = 1 + this.getNext().size();
		}
		return i;
	}

	@Override
	public T search(T element) {
		T rtn = null;
		if (element != null && !this.isEmpty()) {
			if (this.getData().equals(element)) {
				rtn = element;
			} else {
				rtn = getNext().search(element);
			}
		}
		return rtn;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSinglyLinkedListImpl<>());
			} else {
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				if (this.getData().equals(element)) {
					setData(getNext().getData());
					setNext(getNext().getNext());
				} else {
					getNext().remove(element);
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size()];
		toArray(array, 0);
		return array;
	}

	private void toArray(T[] array, int index) {
		if (!this.isEmpty()) {
			array[index] = this.getData();
			this.getNext().toArray(array, ++index);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSinglyLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSinglyLinkedListImpl<T> next) {
		this.next = next;
	}

}
