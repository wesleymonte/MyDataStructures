package binarySearchTree;

import binaryTree.BTNode;

public class BSTNode<T extends Comparable<T>> extends BTNode<T> {

	public BSTNode() {
		super();
	}

	public static class Builder<T> {
		T data;
		BTNode<T> left;
		BTNode<T> right;
		BTNode<T> parent;

		public BSTNode.Builder<T> data(T data) {
			this.data = data;
			return this;
		}

		public BSTNode.Builder<T> left(BTNode<T> left) {
			this.left = left;
			return this;
		}

		public BSTNode.Builder<T> right(BTNode<T> right) {
			this.right = right;
			return this;
		}

		public BSTNode.Builder<T> parent(BTNode<T> parent) {
			this.parent = parent;
			return this;
		}

		public BSTNode build() {
			return new BSTNode(this);
		}
	}

	private BSTNode(BSTNode.Builder<T> builder) {
		this.data = builder.data;
		this.left = builder.left;
		this.right = builder.right;
		this.parent = builder.parent;

	}

}
