package binarySearchTree;

import binarySearchTree.BSTNode;
import binaryTree.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	@Override
	public BTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.getData() == null;
	}

	@Override
	public int height() {
		return height(castNode(getRoot())) - 1;
	}

	private int height(BSTNode<T> node) {
		int height = 0;
		if (!node.isEmpty()) {
			height = 1 + Math.max(height(castNode(node.getLeft())), height(castNode(node.getRight())));
		}
		return height;
	}

	@Override
	public int size() {
		return size(castNode(this.getRoot()));
	}

	private int size(BSTNode<T> node) {
		int size = 0;
		if (!node.isEmpty()) {
			size = 1 + size(castNode(node.getLeft())) + size(castNode(node.getRight()));
		}
		return size;

	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, castNode(this.getRoot()));
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> rtn = new BSTNode<T>();
		if (!node.isEmpty() && element != null) {
			int compare = node.getData().compareTo(element);
			if (compare > 0) {
				rtn = search(element, castNode(node.getLeft()));
			} else if (compare < 0) {
				rtn = search(element, castNode(node.getRight()));
			} else {
				rtn = node;
			}
		}
		return rtn;
	}

	@Override
	public void insert(T element) {
		insert(element, castNode(this.getRoot()));
	}

	private void insert(T element, BSTNode<T> node) {
		if (element != null) {
			if (node.isEmpty()) {
				node.setData(element);
				setChildrenNIL(node);
			} else {
				if (element.compareTo(node.getData()) > 0) {
					insert(element, castNode(node.getRight()));
				} else {
					insert(element, castNode(node.getLeft()));
				}
			}
		}
	}

	@Override
	public void remove(T key) {

	}

	public void remove(BSTNode<T> node) {
		if (node.isLeaf()) {
			clearNode(node);
		} else {
			if (!node.getRight().isEmpty()) {
				BSTNode<T> minimum = treeMinimum(castNode(node.getRight()));
				node.setData(minimum.getData());
				remove(minimum);
			}
			else {
				BSTNode<T> maximum = treeMaximum(castNode(node.getLeft()));
				node.setData(maximum.getData());
				remove(maximum);
			}

		}
	}

	@Override
	public T[] preOrder() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size()];
		preOrder(array, 0, castNode(getRoot()));
		return array;
	}
	
	private int preOrder(T[] array, int index, BSTNode<T> node) {
		if(!node.isEmpty()) {
			array[index++] = node.getData();
			index = preOrder(array, index, castNode(node.getLeft()));
			index = preOrder(array, index, castNode(node.getRight()));
		}
		return index;
	}

	@Override
	public T[] order() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size()];
		order(array, 0, castNode(getRoot()));
		return array;
	}
	
	private int order(T[] array, int index, BSTNode<T> node) {
		if(!node.isEmpty()) {
			index = preOrder(array, index, castNode(node.getLeft()));
			array[index++] = node.getData();
			index = preOrder(array, index, castNode(node.getRight()));
		}
		return index;
	}

	@Override
	public T[] postOrder() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size()];
		postOrder(array, 0, castNode(getRoot()));
		return array;
	}
	
	private int postOrder(T[] array, int index, BSTNode<T> node) {
		if(!node.isEmpty()) {
			index = preOrder(array, index, castNode(node.getLeft()));
			index = preOrder(array, index, castNode(node.getRight()));
			array[index++] = node.getData();
		}
		return index;
	}

	@Override
	public BSTNode<T> maximum() {
		return treeMaximum(castNode(getRoot()));
	}
	
	public BSTNode<T> treeMaximum(BSTNode<T> root){
		BSTNode<T> maximum = new BSTNode<T>();
		if (!root.isEmpty()) {
			while (!maximum.getRight().isEmpty()) {
				maximum = castNode(maximum.getLeft());
			}
		}
		return maximum;
	}

	@Override
	public BSTNode<T> minimum() {
		return treeMinimum(castNode(getRoot()));
	}

	public BSTNode<T> treeMinimum(BSTNode<T> root) {
		BSTNode<T> minimum = new BSTNode<T>();
		if (!root.isEmpty()) {
			while (!minimum.getLeft().isEmpty()) {
				minimum = castNode(minimum.getLeft());
			}
		}
		return minimum;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> predecessor = search(element);
		if(!predecessor.isEmpty()) {
			if(!predecessor.getLeft().isEmpty()) {
				predecessor = treeMaximum(castNode(predecessor.getLeft()));
			} else {
				BSTNode<T> parent = castNode(predecessor.getParent());
				while(parent != null && parent.getLeft().equals(predecessor)) {
					predecessor = parent;
					parent = castNode(predecessor.getParent());
				}
			}
		}
		return predecessor;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> sucessor = search(element);
		if(!sucessor.isEmpty()) {
			if(sucessor.getRight().isEmpty()) {
				sucessor = treeMinimum(castNode(sucessor.getRight()));
			} else {
				BSTNode<T> parent = castNode(sucessor.getParent());
				while(parent != null && parent.getRight().equals(sucessor)) {
					sucessor = parent;
					parent = castNode(sucessor.getParent());
				}
			}
		}
		return sucessor;
	}

	@SuppressWarnings("unchecked")
	private BSTNode<T> castNode(Object node) {
		BSTNode<T> rtn = null;
		if (node instanceof BSTNode<?>) {
			rtn = ((BSTNode<T>) node);
		}
		return rtn;
	}

	private void setChildrenNIL(BSTNode<T> node) {
		BSTNode<T> NIL = new BSTNode<T>();
		NIL.setParent(node);
		node.setLeft(NIL);
		node.setRight(NIL);
	}
	
	private void clearNode(BSTNode<T> node) {
		node.setData(null);
		node.setLeft(null);
		node.setRight(null);
	}

}
