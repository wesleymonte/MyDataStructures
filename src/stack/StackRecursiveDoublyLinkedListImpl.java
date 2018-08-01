package stack;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.RecursiveDoublyLinkedListImpl;

public class StackRecursiveDoublyLinkedListImpl<T> implements Stack<T> {
	
	protected DoublyLinkedList<T> list;
	protected int size;
	
	public StackRecursiveDoublyLinkedListImpl(int size) {
		this.size = size;
		this.list = new RecursiveDoublyLinkedListImpl<T>();
	}
	
	@Override
	public void push(T element) throws StackOverflowException {
		if(element != null) {
			if(list.size() < size) {
				list.insert(element);
			} else {
				throw new StackOverflowException();
			}
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T rtn = top();
		if(rtn != null) {
			((RecursiveDoublyLinkedListImpl<T>) list ).removeLast();
		} else {
			throw new StackUnderflowException();
		}
		return rtn;
	}

	@Override
	public T top() {
		T rtn = null;
		if(!isEmpty()) {
			RecursiveDoublyLinkedListImpl<T> current = (RecursiveDoublyLinkedListImpl<T>) list;
			while(!current.getNext().isEmpty()) {
				current = (RecursiveDoublyLinkedListImpl<T>) current.getNext();
			}
			rtn = current.getData();
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
