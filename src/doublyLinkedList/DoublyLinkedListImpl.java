package doublyLinkedList;

import singlyLinkedList.SinglyLinkedListImpl;

public class DoublyLinkedListImpl<T> extends SinglyLinkedListImpl<T> implements DoublyLinkedList<T> {
	
	protected DoublyLinkedListNode<T> last;
	
	public DoublyLinkedListImpl() {
		this.head = new DoublyLinkedListNode<T>();
		this.last = castToDoublyNode(head);
	}
	
	@Override
	public void insert(T element) {
		if(element != null) {
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(element, last, null);
			newNode.setNext(createNIL(newNode, null));
			last.setNext(newNode);
			if(last.isNIL()) {
				head = newNode;
			}
			last = newNode;
		}
	}
	
	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(element, null, castToDoublyNode(head));
			newNode.setPrevious(this.createNIL(null, newNode));
			castToDoublyNode(head).setPrevious(newNode);
			if(head.isNIL()) {
				last = newNode;
			}
			head = newNode;
		}
		
	}
	
	@Override
	public void remove(T element) {
		if(!this.isEmpty() && element != null) {
			DoublyLinkedListNode<T> currentLeft = castToDoublyNode(head);
			DoublyLinkedListNode<T> currentRight = last;
			while(!currentLeft.equals(currentRight) && castToDoublyNode(currentLeft.getNext()).equals(currentRight) &&
					!currentLeft.getData().equals(element) && !currentRight.getData().equals(element)) {
				currentLeft = castToDoublyNode(currentLeft.getNext());
				currentRight = last.getPrevious();
			}
			if(currentLeft.equals(element)) {
				currentLeft = castToDoublyNode(currentLeft.getNext());
			} else if(currentRight.equals(element)) {
				currentRight = castToDoublyNode(currentRight.getNext());
			}
		}
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()) {
			if(castToDoublyNode(head).equals(last)) {
				this.head = new DoublyLinkedListNode<T>();
				this.last = castToDoublyNode(head);
			} else {
				this.head = head.getNext();
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty()) {
			if(castToDoublyNode(head).equals(last)) {
				this.head = new DoublyLinkedListNode<T>();
				this.last = castToDoublyNode(head);
			} else {
				this.last = last.getPrevious();
			}
		}
	}
	
	private DoublyLinkedListNode<T> castToDoublyNode(Object object){
		DoublyLinkedListNode<T> rtn = new DoublyLinkedListNode<T>();
		if(object instanceof DoublyLinkedListNode) {
			rtn = (DoublyLinkedListNode<T>) object;
		}
		return rtn;
	}
	
	private DoublyLinkedListNode<T> createNIL(DoublyLinkedListNode<T> previous, DoublyLinkedListNode<T> next){
		return new DoublyLinkedListNode<T>(null, previous, next);
	}
	
}
