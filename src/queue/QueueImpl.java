package queue;

public class QueueImpl<T> implements Queue<T> {

	protected T[] array;
	protected int tail;
	
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(element != null) {
			if(!isFull()) {
				array[++tail] = element;
			} else {
				throw new QueueOverflowException();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T rtn = head();
		if(rtn != null) {
			array[0] = null;
			shiftLeft();
			tail--;
		} else {
			throw new QueueUnderflowException();
		}
		return rtn;
	}
	
	private void shiftLeft() {
		for(int i = 0; i < tail; i++) {
			array[i] = array[i+1];
		}
	}

	@Override
	public T head() {
		T rtn = null;
		if(!isEmpty()) {
			rtn = array[0];
		}
		return rtn;
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

}
