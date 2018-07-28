package bt;

public interface BT<T> {
	
	public BTNode<T> getRoot();
	
	public boolean isEmpty();
	
	public int height();
	
	public int size();
	
	public void insert(T element);
	
	public BTNode<T> search(T element);
	
	public void remove(T key);
	
	public T[] preOrder();
	
	public T[] order();
	
	public T[] postOrder();
	
}
