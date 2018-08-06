package stack.extended;

import stack.StackImpl;
import stack.StackUnderflowException;

public class StackExtendedImpl<T extends Comparable<T>> extends StackImpl<T> implements StackExtended<T> {

	public StackExtendedImpl(int size) {
		super(size);
	}

	@Override
	public void sort() {
		if (!isEmpty()) {
			try {
				T temp = pop();
				sort();
				sortedInsert(temp);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	private void sortedInsert(T element) throws Exception {
		if (!isEmpty() && top().compareTo(element) < 0) {
			T temp = pop();
			sortedInsert(element);
			push(temp);
		} else {
			push(element);
		}
	}
	
	public void reverseStack() {
		reverseStack(1);
	}
	
	private void reverseStack(int i) {
		if(i <= top) {
			bringToTheTop(i);
			reverseStack(i + 1);
		}
	}
	
	public void bringToTheTop(int depth) {
		try {
			if(depth == 1) {
				swapTop();
			} else if(depth > 1){
				T temp1 = pop();
				bringToTheTop(depth - 1);
				push(temp1);
				swapTop();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	private void swapTop() {
		try {
			T temp1 = pop();
			T temp2 = pop();
			push(temp1);
			push(temp2);	
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void deleteMiddle() {
		if(!isEmpty()) {
			int middle = top / 2;
			deleteMiddle(middle);
		}
	}
	
	private void deleteMiddle(int k) {
		try {
			if(k == 0) {
				pop();
			} else {
				T temp = pop();
				deleteMiddle(k -1);
				push(temp);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
