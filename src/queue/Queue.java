package queue;

public interface Queue<T> {
	
	public void enqueue(T element) throws QueueOverflowException;
	
	public void dequeue() throws QueueUnderflowException;
	
	public T head();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
}
