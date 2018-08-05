package circularlyLinkedList;

public interface CircularlyLinkedList<T> {
	
	public int size();
	
	public boolean isEmpty();
	
	public T head();
	
	public T tail();
	
	public void rotate();
	
	public void addFirst(T element);
	
	public void addLast(T element);
	
	public T removeFirst();
}
