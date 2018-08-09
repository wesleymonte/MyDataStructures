package heap;

public interface Heap<T extends Comparable<T>> {
	
	public abstract boolean isEmpty();
	
	public abstract void insert(T element);
	
	public abstract T rootElement();
	
	public abstract T extractRootElement();
	
	public abstract void buildHeap(T[] array);
	
	public abstract T[] heapsort(T[] array);
	
	public abstract T[] toArray();
	
	public int size();
}
