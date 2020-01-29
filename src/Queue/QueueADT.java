package Queue;
import java.util.NoSuchElementException;

public class QueueADT<T> implements IQueue <T> {
	private T[] que;
	private int frontIndex;
	private int backIndex;
	private int items;
	
	/**
	 * Constructor
	 */
	public QueueADT(int capacity) {
		items = 0;
		frontIndex = 0;
		backIndex = -1;
		@SuppressWarnings("unchecked")
		T[] temp  = (T[]) new Object[capacity+1];
		que = temp;
	}
	
	 /** 
	  * Method that increases capacity if necessary
	  */
	private void ensureCapacity() {
		if(isFull()) {
			T[] oldQueue = que;
			int oldSize = oldQueue.length;
			@SuppressWarnings("unchecked")
			T[] temp  = (T[]) new Object[oldQueue.length*2];
			que = temp;
			
			for(int index=0; index < oldSize-1; index++) {
				que[index]=oldQueue[frontIndex];
			}
			frontIndex=0;
			backIndex = oldSize-2;
		}
		
	}
	
	/**
	 * Method that checks the queue is full or not.
	 * @return is full or not
	 */
	private boolean isFull() {
		return frontIndex == ((backIndex + 2) % que.length);
	}
	
	/**
	 * Adds new entry to the back of the queue
	 * @param newEntry
	 * @throws IllegalArgumentException if the newEntry is invalid
	 */
	public void enqueue(T newEntry) {
		if(newEntry!=null) {
			ensureCapacity();
		backIndex = (backIndex+1)%que.length;
		que[backIndex]=newEntry;
		items++;
		}
		else
			throw new IllegalArgumentException();
	}
	
	/**
	 * Removes and returns the entry at the front of the queue
	 * @return The removed element
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException("Empty queue");
		}
		else {
			T front = que[frontIndex];
			que[frontIndex]=null;
			frontIndex = (frontIndex + 1 ) % que.length;
			items--;
			return front;
			
		}
	}
	
	/**
	 * Retrieves the entry at the front of the queue
	 * @return The element on the front
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T getFront() {
		if(isEmpty()) {
			throw new NoSuchElementException("Empty queue");
		}
		else
			return que[frontIndex];
	}
	
	/**
	 * Method that checks emptiness of queue. 
	 * @return is empty or not
	 */
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % que.length);
	}
	
	/**
	 * Method that removes all items in the queue.
	 */
	public void clear() {
		for(int i=0; i<que.length;i++)
			que[i] = null;
	}

}
