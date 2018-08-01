package stack;

public class StackUnderflowException extends Exception {
	
	public StackUnderflowException() {
		super("Empty Stack");
	}
}
