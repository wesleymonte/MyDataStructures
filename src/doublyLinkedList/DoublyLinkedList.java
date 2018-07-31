package doublyLinkedList;

import singlyLinkedList.SinglyLinkedList;

public interface DoublyLinkedList<T> extends SinglyLinkedList<T> {
	
	public void insertFirst(T element);
	
	public void removeFirst();
	
	public void removeLast();
}
