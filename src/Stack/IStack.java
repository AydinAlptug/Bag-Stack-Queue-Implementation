package Stack;

import java.util.NoSuchElementException;

public interface IStack<T> {
	
	/**
	 * Adds new entry to the top of the stack
	 * @param newEntry
	 */
public void push(T newEntry);

/**
 * Removes and returns the stack's top entry
 * @return Top element of stack
 *  @throws NoSuchElementException if the queue is empty
 */
public T pop();

/**
 * Retrieves the top entry of the stack
 * @return Top element of stack
 * @throws NoSuchElementException if the queue is empty
 */
public T peek();

/**
 * Method that checks emptiness of bag. 
 * @return Is empty or not
 */
public boolean isEmpty();

/**
 * Method that removes all items in the stack.
 */
public void clear();
}
