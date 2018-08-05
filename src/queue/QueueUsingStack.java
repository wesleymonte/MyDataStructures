package queue;

import stack.Stack;
import stack.StackImpl;
import stack.StackOverflowException;
import stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	protected Stack<T> stack1;
	protected Stack<T> stack2;
	protected int size;

	public QueueUsingStack(int size) {
		this.stack1 = new StackImpl<T>(size);
		this.stack2 = new StackImpl<T>(size);
		this.size = size;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null) {
			if (isFull()) {
				throw new QueueOverflowException();
			} else {
				try {
					if (stack2.isEmpty()) {
						stack2.push(element);
					} else {
						transfer(stack2, stack1);
						stack1.push(element);
						transfer(stack1, stack2);
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T rtn = null;
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			try {
				rtn = stack2.pop();
			} catch (Exception e) {

			}
		}
		return rtn;
	}

	@Override
	public T head() {
		return stack2.top();
	}

	@Override
	public boolean isEmpty() {
		return stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack2.isFull();
	}

	private void transfer(Stack<T> s1, Stack<T> s2) throws StackOverflowException, StackUnderflowException {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
	}

}
