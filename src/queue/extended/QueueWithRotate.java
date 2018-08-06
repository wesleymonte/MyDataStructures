package queue.extended;

import queue.Queue;

public interface QueueWithRotate<T> extends Queue<T> {
	
	public void rotate();
	
}
