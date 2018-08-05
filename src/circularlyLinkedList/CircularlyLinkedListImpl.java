package circularlyLinkedList;

public class CircularlyLinkedListImpl<T> implements CircularlyLinkedList<T> {
	
	private Node<T> tail;
	private int size;
	
	public CircularlyLinkedListImpl() {
		this.tail = new Node<T>();
		this.size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T head() {
		T rtn = null;
		if(!isEmpty()) {
			rtn = getTail().getNext().getData();
		}
		return rtn;
	}

	@Override
	public T tail() {
		T rtn =  null;
		if(!isEmpty()) {
			rtn = getTail().getData();
		}
		return rtn;
	}

	@Override
	public void rotate() {
		if(!isEmpty()) {
			this.setTail(getTail().getNext());
		}
	}

	@Override
	public void addFirst(T element) {
		if(element != null) {
			if(this.isEmpty()) {
				getTail().setData(element);
				getTail().setNext(getTail());
			} else {
				Node<T> newest = new Node<>(element, getTail().getNext());
				getTail().setNext(newest);
			}
			size++;
		}
	}

	@Override
	public void addLast(T element) {
		if(element != null) {
			addFirst(element);
			rotate();
		}
	}

	@Override
	public T removeFirst() {
		T rtn = null;
		if(!isEmpty()) {
			if(size == 1) {
				rtn = getTail().getData();
				getTail().setData(null);
			} else {
				Node<T> head = getTail().getNext();
				getTail().setNext(head.getNext());
				rtn = head.getData();
			}
			size--;
		}
		return rtn;
		
	}
	
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	public Node<T> getTail(){
		return this.tail;
	}

}
