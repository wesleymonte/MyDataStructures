package bst;

import bt.BT;

public interface BST<T extends Comparable<T>> extends BT<T> {
	
	public BSTNode<T> maximum();
	
	public BSTNode<T> minimum();
	
	public BSTNode<T> predecessor(T element);
	
	public BSTNode<T> sucessor(T element);
}
