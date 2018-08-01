package doublyLinkedList;

import singlyLinkedList.SinglyLinkedListImpl;

public class DoublyLinkedListImpl<T> extends SinglyLinkedListImpl<T> implements DoublyLinkedList<T> {

	protected DoublyLinkedListNode<T> last;

	public DoublyLinkedListImpl() {
		this.head = new DoublyLinkedListNode<T>();
		this.last = castToDoublyNode(head);
	}

	@Override
	public T search(T element) {
		T rtn = null;
		if (element != null && !this.isEmpty()) {
			DoublyLinkedListNode<T> currentLeft = castToDoublyNode(getHead());
			DoublyLinkedListNode<T> currentRight = getLast();
			while (!currentLeft.equals(currentRight) && !castToDoublyNode(currentLeft.getNext()).equals(currentRight)
					&& !currentLeft.getData().equals(element) && !currentRight.getData().equals(element)) {
				currentLeft = castToDoublyNode(currentLeft.getNext());
				currentRight = currentRight.getPrevious();
			}
			if (currentLeft.getData().equals(element)) {
				rtn = currentLeft.getData();
			} else if (currentRight.getData().equals(element)) {
				rtn = currentRight.getData();
			}
		}
		return rtn;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(element, getLast(), null);
			newNode.setNext(createNIL(newNode, null));
			getLast().setNext(newNode);
			if (getLast().isNIL()) {
				setHead(newNode);
			}
			setLast(newNode);
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(element, null, castToDoublyNode(getHead()));
			newNode.setPrevious(createNIL(null, newNode));
			castToDoublyNode(getHead()).setPrevious(newNode);
			if (getHead().isNIL()) {
				setLast(newNode);
			}
			setHead(newNode);
		}

	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			DoublyLinkedListNode<T> currentLeft = castToDoublyNode(getHead());
			DoublyLinkedListNode<T> currentRight = this.getLast();
			while (!currentLeft.equals(currentRight) && !castToDoublyNode(currentLeft.getNext()).equals(currentRight)
					&& !currentLeft.getData().equals(element) && !currentRight.getData().equals(element)) {
				currentLeft = castToDoublyNode(currentLeft.getNext());
				currentRight = currentRight.getPrevious();
			}
			if (currentLeft.getData().equals(element)) {
				if (currentLeft.getPrevious().isNIL()) {
					removeFirst();
				} else {
					currentLeft.setData(currentLeft.getNext().getData());
					currentLeft.setNext(currentLeft.getNext().getNext());
				}
			} else if (currentRight.getData().equals(element)) {
				if (currentRight.getNext().isNIL()) {
					removeLast();
				} else {
					currentRight.setData(currentRight.getNext().getData());
					currentRight.setNext(currentRight.getNext().getNext());
				}
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (getHead().getNext().isNIL() && castToDoublyNode(getHead()).getPrevious().isNIL()) {
				setHead(new DoublyLinkedListNode<T>());
				setLast(castToDoublyNode(getHead()));
			} else {
				setHead(getHead().getNext());
				castToDoublyNode(getHead()).setPrevious(createNIL(null, castToDoublyNode(getHead())));
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (getHead().getNext().isNIL() && castToDoublyNode(this.getHead()).getPrevious().isNIL()) {
				setHead(new DoublyLinkedListNode<T>());
				setLast(castToDoublyNode(getHead()));
			} else {
				setLast(getLast().getPrevious());
				getLast().setNext(createNIL(getLast(), null));
			}
		}
	}

	public DoublyLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoublyLinkedListNode<T> last) {
		this.last = last;
	}

	@SuppressWarnings("unchecked")
	private DoublyLinkedListNode<T> castToDoublyNode(Object object) {
		DoublyLinkedListNode<T> rtn = new DoublyLinkedListNode<T>();
		if (object instanceof DoublyLinkedListNode) {
			rtn = (DoublyLinkedListNode<T>) object;
		}
		return rtn;
	}

	private DoublyLinkedListNode<T> createNIL(DoublyLinkedListNode<T> previous, DoublyLinkedListNode<T> next) {
		return new DoublyLinkedListNode<T>(null, previous, next);
	}

}
