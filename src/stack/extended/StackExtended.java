package stack.extended;

import stack.Stack;

public interface StackExtended<T extends Comparable<T>> extends Stack<T> {
	
	public void sort();
	
}
