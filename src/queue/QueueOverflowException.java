package queue;

public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("Queue is Full");
	}
}
