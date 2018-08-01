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
	public void dequeue() throws QueueUnderflowException {
		if(!isEmpty()) {
			list.removeFirst();
		} else {
			throw new QueueUnderflowException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T head() {
		T rtn = null;
		if(list.size() > 0) {
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
