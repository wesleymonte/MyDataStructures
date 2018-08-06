package stack.extended;

import stack.StackOverflowException;
import stack.StackUnderflowException;

public class TestStackWithSort {

	public static void main(String[] args) throws Exception{
		StackExtendedImpl<Integer> i = new StackExtendedImpl<Integer>(4);
        
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
        
        i.push(7);
        i.push(9);
        i.push(10);
        
        i.sort();
        
        System.out.print(i.pop() == 7 ? "." : "F");
        System.out.print(i.pop() == 9 ? "." : "F");
        System.out.print(i.pop() == 10 ? "." : "F");
        
        i.push(7);
        i.push(9);
        i.push(10);
        i.reverseStack();
        
        System.out.print(i.pop() == 7 ? "." : "F");
        System.out.print(i.pop() == 9 ? "." : "F");
        System.out.print(i.pop() == 10 ? "." : "F");
        
        i.push(7);
        i.push(9);
        i.push(10);
        i.deleteMiddle();
        
        System.out.print(i.pop() == 10 ? "." : "F");
        System.out.print(i.pop() == 7 ? "." : "F");
	}

}
