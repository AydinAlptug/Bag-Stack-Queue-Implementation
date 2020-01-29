package Bag;

public interface IBag <T> {
	/**
	 * Method that adds an item.
	 * @param newItem 
	 * @return addition is done or not
	 */
	public boolean add(T newItem);
	/**
	 * Method that checks emptiness of bag. 
	 * @return Is empty or not
	 */
	public boolean isEmpty();
	/**
	 * Method that checks the bag is full or not.
	 * @return Is full or not
	 */
	public boolean isFull();
	/**
	 * Method that removes an item.
	 * @param index 
	 * @return removed item
	 */
	public T removeByIndex(int index);
	/**
	 * Method that removes an item.
	 * @return removed item
	 */
	public T remove();
	/**
	 * Method that removes an item.
	 * @param item 
	 * @return removed item
	 */
	public T remove(T item);
	/**
	 * Method that counts items in the bag. 
	 * @return total items number
	 */
	public int getItemCount();
	/**
	 * Method that finds the index of the item.
	 * @param item 
	 * @return index of item
	 */
	public int getIndexOf(T item);
	/**
	 * Method that checks if the item exists.
	 * @param item
	 * @return item is exists or not
	 */
	public boolean contains(T item);
	/**
	 * Method that prints all items. 
	 * @return nothing
	 */
	public void displayItems();
	/**
	 * Method that removes all items in the bag.
	 * @return nothing
	 */
	public void dump();
	/**
	 * Method that transfers the item to another bag
	 * @param targetBag  
	 * @param item  
	 * @return done or not
	 */
	public boolean transferTo(IBag<T> targetBag, T item);
	
	
	
	
	
	

}
