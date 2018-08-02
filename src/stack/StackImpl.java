package stack;

public class StackImpl<T> implements Stack<T> {
	
	protected T[] array;
	protected int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (element != null) {
			if (!isFull()) {
				array[++top] = element;
			} else {
				throw new StackOverflowException();
			}
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T rtn = top();
		if(rtn != null) {
			array[top--] = null;
		} else {
			throw new StackUnderflowException();
		}
		return rtn;
	}

	@Override
	public T top() {
		T rtn =  null;
		if(top != -1) {
			rtn = array[top];
		}
		return rtn;
	}

	@Override
	public boolean isEmpty() {
		return top == - 1;
	}

	@Override
	public boolean isFull() {
		return top == array.length - 1;
	}
}
