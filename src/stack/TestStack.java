package stack;

import stack.StackOverflowException;
import stack.StackUnderflowException;

public class TestStack {

	public static void main(String[] args) throws Exception {
		StackDoublyLinkedListImpl<Integer> i = new StackDoublyLinkedListImpl<Integer>(4);
        
        System.out.println("\nTestes Pilha");
        
        System.out.print(i.isEmpty() ? "." : "F");
        System.out.print(!i.isFull() ? "." : "F");
        System.out.print(i.top() == null ? "." : "F");
        
        try {
        	i.pop();
        	System.out.print("F");
        } catch(StackUnderflowException e) {
        	System.out.print(".");
        }
        
        i.push(1);
        i.push(2);
        i.push(3);
        i.push(null);
        
        System.out.print(!i.isEmpty() ? "." : "F");
        System.out.print(!i.isFull() ? "." : "F");
        System.out.print(i.top().equals(3) ? "." : "F");
        
        i.push(4);
        
        System.out.print(!i.isEmpty() ? "." : "F");
        System.out.print(i.isFull() ? "." : "F");
        System.out.print(i.top().equals(4) ? "." : "F");
        
        try {
        	i.push(5);
        	System.out.print("F");
        } catch(StackOverflowException e) {
        	System.out.print(".");
        }
        
        i.pop();
        i.pop();
        
        System.out.print(!i.isEmpty() ? "." : "F");
        System.out.print(!i.isFull() ? "." : "F");
        System.out.print(i.top().equals(2) ? "." : "F");
        
        i.pop();
        i.pop();
        
        System.out.print(i.isEmpty() ? "." : "F");
        System.out.print(!i.isFull() ? "." : "F");
        System.out.print(i.top() == null ? "." : "F");
        
	}

}
