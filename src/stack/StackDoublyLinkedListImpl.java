package stack;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.DoublyLinkedListImpl;

public class StackDoublyLinkedListImpl<T> implements Stack<T> {

	protected DoublyLinkedList<T> list;
	int size;

	public StackDoublyLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoublyLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (element != null) {
			if (!isFull()) {
				list.insert(element);
			} else {
				throw new StackOverflowException();
			}
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T rtn = null;
		if (!isEmpty()) {
			rtn = ((DoublyLinkedListImpl<T>) list).getLast().getData();
			list.removeLast();
		} else {
			throw new StackUnderflowException();
		}
		return rtn;
	}

	@Override
	public T top() {
		T rtn = null;
		if(list.size() > 0) {
			rtn = ((DoublyLinkedListImpl<T>) list).getLast().getData();
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
