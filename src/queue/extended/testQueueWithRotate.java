package queue.extended;

import queue.QueueOverflowException;
import queue.QueueUnderflowException;
import queue.QueueUsingStack;

public class testQueueWithRotate {

	public static void main(String[] args) throws Exception {
		QueueWithRotate<Integer> j = new QueueWithRotateImpl<Integer>(4);

		System.out.println("\nTestes Fila");

		j.enqueue(1);
		j.enqueue(2);

		System.out.print(!(j.isFull()) ? "." : "F");
		System.out.print(!(j.isEmpty()) ? "." : "F");
		System.out.print(j.head().equals(1) ? "." : "F");
		
		j.enqueue(1);
		j.enqueue(2);
		j.dequeue();
		j.dequeue();
		j.enqueue(3);
		j.enqueue(4);

		System.out.print(j.isFull() ? "." : "F");
		System.out.print(!j.isEmpty() ? "." : "F");
		System.out.print(j.head().equals(1) ? "." : "F");
		
		j.rotate();
		
		System.out.print(j.head() == 2 ? "." : "F");

		try {
			j.enqueue(5);
			System.out.print("F");
		} catch (QueueOverflowException e) {
			System.out.print(".");
		}

		j.dequeue();

		System.out.print(j.head().equals(3) ? "." : "F");
		System.out.print(!j.isFull() ? "." : "F");
		System.out.print(!j.isEmpty() ? "." : "F");

		j.dequeue();
		j.dequeue();
		j.dequeue();

		System.out.print(j.isEmpty() ? "." : "F");
		System.out.print(!j.isFull() ? "." : "F");
		System.out.print(j.head() == null ? "." : "F");

		try {
			j.dequeue();
			System.out.print("F");
		} catch (QueueUnderflowException e) {
			System.out.print(".");
		}
	}

}
