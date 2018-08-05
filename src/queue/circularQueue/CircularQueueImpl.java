package queue.circularQueue;

import circularlyLinkedList.CircularlyLinkedList;
import circularlyLinkedList.CircularlyLinkedListImpl;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class CircularQueueImpl<T> implements CircularQueue<T> {
	
	private CircularlyLinkedList<T> list;
	private int size;
	
	public CircularQueueImpl(int size) {
		this.list = new CircularlyLinkedListImpl<T>();
		this.size = size;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(element != null) {
			if(isFull()) {
				throw new QueueOverflowException();
			} else {
				list.addLast(element);
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T rtn = null;
		if(isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			rtn = list.removeFirst();
		}
		return rtn;
	}

	@Override
	public T head() {
		return list.head();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() == size;
	}

	@Override
	public void rotate() {
		list.rotate();
	}

	@Override
	public int size() {
		return this.list.size();
	}

}
