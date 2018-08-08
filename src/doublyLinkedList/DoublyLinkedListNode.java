package doublyLinkedList;

import singlyLinkedList.iterative.SinglyLinkedListNode;

public class DoublyLinkedListNode<T> extends SinglyLinkedListNode<T> {
	protected DoublyLinkedListNode<T> previous;

	public DoublyLinkedListNode() {

	}

	public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> previous, DoublyLinkedListNode<T> next) {
		super(data, next);
		this.previous = previous;
	}

	public DoublyLinkedListNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedListNode<T> previous) {
		this.previous = previous;
	}
}
