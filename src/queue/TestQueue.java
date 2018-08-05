package queue;

public class TestQueue {

	public static void main(String[] args) throws Exception {
		QueueUsingStack<Integer> j = new QueueUsingStack<Integer>(4);

		System.out.println("\nTestes Fila");

		j.enqueue(1);
		j.enqueue(2);

		System.out.print(!(j.isFull()) ? "." : "F");
		System.out.print(!(j.isEmpty()) ? "." : "F");
		System.out.print(j.head().equals(1) ? "." : "F");

		j.enqueue(3);
		j.enqueue(4);

		System.out.print(j.isFull() ? "." : "F");
		System.out.print(!j.isEmpty() ? "." : "F");
		System.out.print(j.head().equals(1) ? "." : "F");

		try {
			j.enqueue(5);
			System.out.print("F");
		} catch (QueueOverflowException e) {
			System.out.print(".");
		}

		j.dequeue();

		System.out.print(j.head().equals(2) ? "." : "F");
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
