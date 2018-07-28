package bt;

public class BTNode<T> {

	protected T data;
	protected BTNode<T> left;
	protected BTNode<T> right;
	protected BTNode<T> parent;

	public BTNode(T data, BTNode<T> left, BTNode<T> right, BTNode<T> parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public BTNode() {
	}

	public boolean isEmpty() {
		return data == null;
	}

	public boolean isLeaf() {
		return this.data != null && this.left.isEmpty() && this.right.isEmpty();
	}

	@Override
	public String toString() {
		String str = "NIL";
		if (!this.isEmpty()) {
			str = this.data.toString();
		}
		return str;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj instanceof BTNode) {
			if (!this.isEmpty() && !((BTNode<T>) obj).isEmpty()) {
				resp = this.data.equals(((BTNode<T>) obj).data);
			} else {
				resp = this.isEmpty() && ((BTNode<T>) obj).isEmpty();
			}
		}
		return resp;
	}

	public T getData() {
		return this.data;
	}

	public BTNode<T> getLeft() {
		return this.left;
	}

	public BTNode<T> getRight() {
		return this.right;
	}

	public BTNode<T> getParent() {
		return this.parent;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(BTNode<T> left) {
		this.left = left;
	}

	public void setRight(BTNode<T> right) {
		this.right = right;
	}

	public void setParent(BTNode<T> parent) {
		this.parent = parent;
	}
}
