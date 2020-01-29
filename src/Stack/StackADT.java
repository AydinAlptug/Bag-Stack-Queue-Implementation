package Stack;
import java.util.*;

public class StackADT<T> implements IStack<T>{
	private T [] stack;
	private int topIndex;
	
	/**
	 * Constructor
	 */
	public StackADT(int capacity) {
		@SuppressWarnings("unchecked")
		T [] temp = (T[]) new Object [capacity];
		stack = temp;
		topIndex = -1;
	}
	
	/**
	 * Adds new entry to the top of the stack
	 * @param newEntry
	 * @throws IllegalArgumentException if the newEntry is invalid
	 */
	public void push(T newEntry) {
		if(newEntry!=null) {
			ensureCapacity();
			stack[topIndex+1] = newEntry;
			topIndex++;
		}
		else
			throw new IllegalArgumentException();
	}
	
	 /** 
	  * Method that increases capacity if necessary
	  */
	private void ensureCapacity() {
		if(topIndex == stack.length+1) {
			stack = Arrays.copyOf(stack, stack.length*2);
		}
	}
	
	/**
	 * Retrieves the top entry of the stack
	 * @return Top element of stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public T peek() {
			if(isEmpty()) 
				throw new EmptyStackException();
			else 
				return stack[topIndex];
	}
	
	/**
	 * Removes and returns the stack's top entry
	 * @return Top element of stack
	 * @throws EmptyStackException() if the stack is empty
	 */
	public T pop() {
		if(isEmpty()) 
			throw new EmptyStackException();
		
		else {
		T top = stack[topIndex];
		stack[topIndex] = null;
		topIndex--;
		return top;
		}
	}
	
	
	/**
	 * Retrieves total item numbers
	 * @return total amount
	 */
	public int getAmount() {
		return topIndex+1;
	}
	
	/**
	 * Method that checks emptiness of stack. 
	 * @return is empty or not
	 */
	public boolean isEmpty() {
		return topIndex == -1;
		}

	/**
	 * Method that removes all items in the stack.
	 */
	public void clear() {
		while(topIndex>-1) {
			stack[topIndex] = null;
			topIndex--;
		}
	}

	
}
