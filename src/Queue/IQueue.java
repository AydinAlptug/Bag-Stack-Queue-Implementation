package Queue;

public interface IQueue <T> {
	
	/**
	 * Adds new entry to the back of the queue
	 * @param newEntry
	 * @return nothing
	 */
	public void enqueue(T newEntry);
	
	/**
	 * Removes and returns the entry at the front of the queue
	 * @return The element on the front
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T dequeue();
	
	/**
	 * Retrieves the entry at the front of the queue
	 * @return The element on the front
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T getFront();
	
	/**
	 * Method that checks emptiness of queue. 
	 * @return Is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * Method that removes all items in the queue.
	 */
	public void clear();

}
