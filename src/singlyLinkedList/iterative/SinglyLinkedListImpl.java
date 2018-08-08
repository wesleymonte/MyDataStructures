package singlyLinkedList.iterative;

import singlyLinkedList.SinglyLinkedList;

public class SinglyLinkedListImpl<T> implements SinglyLinkedList<T> {

	protected SinglyLinkedListNode<T> head;

	public SinglyLinkedListImpl() {
		this.head = new SinglyLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SinglyLinkedListNode<T> current = this.getHead();
		while (!current.isNIL()) {
			size += 1;
			current = current.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T rtn = null;
		if (!this.isEmpty() && element != null) {
			SinglyLinkedListNode<T> current = this.getHead();
			while (!current.isNIL() && !current.getData().equals(element)) {
				current = current.getNext();
			}
			if (!current.isNIL()) {
				rtn = current.getData();
			}
		}
		return rtn;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SinglyLinkedListNode<T> current = this.getHead();
			while (!current.isNIL()) {
				current = current.getNext();
			}
			current.setData(element);
			current.setNext(new SinglyLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			SinglyLinkedListNode<T> current = this.getHead();
			while (!current.isNIL() && !current.getData().equals(element)) {
				current = current.getNext();
			}
			if (element.equals(current.getData())) {
				current.setData(current.getNext().getData());
				current.setNext(current.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size()];
		SinglyLinkedListNode<T> current = this.getHead();
		int i = 0;
		while (!current.isNIL()) {
			array[i] = current.getData();
			current = current.getNext();
			i += 1;
		}
		return array;
	}

	public SinglyLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SinglyLinkedListNode<T> head) {
		this.head = head;
	}

}
