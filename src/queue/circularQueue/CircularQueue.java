package queue.circularQueue;

import queue.Queue;

public interface CircularQueue<T> extends Queue<T> {
	
	public void rotate();
	
	public int size();
}
