package queue.extended;

import queue.QueueImpl;

public class QueueWithRotateImpl<T> extends QueueImpl<T> implements QueueWithRotate<T>{

	public QueueWithRotateImpl(int size) {
		super(size);
	}

	@Override
	public void rotate() {
		int i = (sz + head) % array.length;
		if(array[i] == null) {
			array[i] = array[head];
			array[head] = null;
		}
		head = (head + 1) % array.length;
	}

}
