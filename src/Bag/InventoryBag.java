package Bag;
import java.util.Arrays;

public class  InventoryBag <T>  implements IBag<T>{

	private int items;
	private int capacity;
	private T [] inventory;
	
	/**
	 * Constructor
	 */
	public InventoryBag() {
		this.capacity = 1;
		@SuppressWarnings("unchecked")
		T [] tempbag = (T[]) new Object[capacity];
		inventory = tempbag;
		this.items = 0;
	}
	 /** 
	  * Method that increases capacity if necessary
	  */
	private void ensureCapacity() {
		if(isFull()) {
			capacity = capacity+1;
			T[] temp = Arrays.copyOf(inventory, capacity);
			inventory = temp;
		}
	}

	/**
	 * Method adds new item to the inventory array
	 * @param newItem
	 * @return done or not
	 */
	public boolean add(T newItem) {
		if(newItem == null)
			throw new IllegalArgumentException("Item does not exist");
		ensureCapacity();		
		inventory[items] = newItem;
		items++;
		return true;
	}
	/**
	 * Method that checks emptiness of bag. 
	 * @return Is empty or not
	 */
	public boolean isEmpty() {
		return items == 0;
	}
	/**
	 * Method that checks the bag is full or not.
	 * @return Is full or not
	 */
	public boolean isFull(){
		return items>= inventory.length;
	}

	/**
	 * Method that removes an item.
	 * @param index 
	 * @return removed item
	 */
	public T removeByIndex(int index) {
		T rt= null;
		if(index > items - 1)
			throw new IllegalArgumentException("Index number can not be more than items");
		if(!isEmpty() && index>=0) {
			int j=0;
			rt = inventory[index];
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[inventory.length];
			for(int i = 0; i<inventory.length; i++) {
				if(i != index){	
					temp[j]=inventory[i];
					j++;
					}
			}
			temp[items-1] = null;
			items--;
			inventory = temp;
		}
	 return rt;
	}
	
	/**
	 * Method that removes an item.
	 * @return removed item
	 */
	public T remove(){
		T result = null;
		if(items>0) {
			result = inventory[items-1];
			inventory[items-1]=null;
			items--;
		}
		return result;
		
	}
	/**
	 * Method that removes an item.
	 * @param item 
	 * @return removed item
	 */
	public T remove(T item) {
		if(!contains(item))
			throw new IllegalArgumentException("There is no such an item");
	return removeByIndex(getIndexOf(item));
	}

	/**
	 * Method that counts items in the bag. 
	 * @return total items number
	 */
	public int getItemCount() {
		return items;
	}

	/**
	 * Method that finds the index of the item.
	 * @param item 
	 * @return index of item
	 */
	public int getIndexOf(T item) {	
		if(item == null)
			throw new IllegalArgumentException("There is no such an item");
		for(int i = 0; i < items; i++) {
			if(inventory[i].equals(item))
				return i;
		}
		return -1;
	}
	
	/**
	 * Method that checks if the item exists.
	 * @param item
	 * @return item is exists or not
	 */
	public boolean contains(T item) {
		if(item == null)
			throw new IllegalArgumentException("There is no such an item");
		if(getIndexOf(item) != -1)
			return true;
		return false;
	}
	
	/**
	 * Method that prints all items. 
	 * @return nothing
	 */
	public void displayItems() {
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] !=null) {
				System.out.println(i+".index "+ inventory[i].toString());
			}
		}
			//System.out.println();
	}

	/**
	 * Method that removes all items in the bag.
	 * @return nothing
	 */
	public void dump() {
		while(!isEmpty())
			remove();
	}

	/**
	 * Method that transfers the item to another bag
	 * @param targetBag  
	 * @param item  
	 * @return done or not
	 */
	public boolean transferTo(IBag<T> targetBag, T item) {
		if(targetBag == null || item == null) 
			throw new IllegalArgumentException("Check the Item and the destination Bag");
		if(isEmpty())
			return false;
		else {
			targetBag.add(remove((T) item));
			return true;
			}
	}

	
	
	
}
