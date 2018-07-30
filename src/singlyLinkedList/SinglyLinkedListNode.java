package singlyLinkedList;

public class SinglyLinkedListNode<T> {

	protected T data;
	protected SinglyLinkedListNode<T> next;

	public SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public SinglyLinkedListNode() {

	}
	
	public boolean isNIL() {
		return (this.data == null);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SinglyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyLinkedListNode<T> next) {
		this.next = next;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) {
		boolean resp = false;
		if(object instanceof SinglyLinkedListNode) {
			if(!this.isNIL() && !((SinglyLinkedListNode<T>) object).isNIL()) {
				resp = this.data.equals(((SinglyLinkedListNode) object).getData());
			} else {
				resp = this.isNIL() && ((SinglyLinkedListNode<T>) object).isNIL();
			}
		}
		return resp;
	}
	
	@Override
	public String toString() {
		String resp = null;
		if (!isNIL()) {
			resp = this.data.toString();
		} else {
			resp = "NIL";
		}
		return resp;
	}

}
