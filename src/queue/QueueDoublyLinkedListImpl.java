package queue;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.DoublyLinkedListImpl;
import singlyLinkedList.SinglyLinkedListImpl;

public class QueueDoublyLinkedListImpl<T> implements Queue<T> {
	
	protected DoublyLinkedList<T> list;
	protected int size;
	
	public QueueDoublyLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoublyLinkedListImpl<T>();
	}
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(element != null) {
			if(!isFull()) {
				list.insert(element);
			} else {
				throw new QueueOverflowException();
			}
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T rtn = head();
		if(rtn != null) {
			list.removeFirst();
		} else {
			throw new QueueUnderflowException();
		}
		return rtn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T head() {
		T rtn = null;
		if(!isEmpty()) {
			rtn = ((SinglyLinkedListImpl<T>) list).getHead().getData();
		}
		return rtn;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() == size;
	}

}
