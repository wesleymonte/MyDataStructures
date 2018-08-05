package queue;

public class QueueImpl<T> implements Queue<T> {

	protected T[] array;
	protected int head;
	protected int sz;		//current number of elements
	
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		head = 0;
		sz = 0;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(element != null) {
			if(isFull()) {
				throw new QueueOverflowException();
			} else {
				int i = (head + sz) % array.length;
				array[i] = element;
				sz++;
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T rtn = null;
		if(isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			rtn = array[head];
			array[head] = null;
			head = (head + 1) % array.length;
			sz--;
		}
		return rtn;
	}

	@Override
	public T head() {
		T rtn = null;
		if(!isEmpty()) {
			rtn = array[head];
		}
		return rtn;
	}

	@Override
	public boolean isEmpty() {
		return sz == 0;
	}

	@Override
	public boolean isFull() {
		return sz == array.length;
	}

}
