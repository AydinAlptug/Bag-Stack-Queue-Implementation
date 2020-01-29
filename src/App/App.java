package App;

import Bag.*;
import Queue.*;
import Stack.*;

public class App {
	public static void main(String[] args) {
		System.out.println("BAG TEST");
		IBag<Item> bag = new InventoryBag<Item>();
		Item item1 = new Item("item1");
		bag.add(item1);
		bag.add(new Item("item2"));
		bag.add(new Item("item3"));
		bag.add(new Item("item4"));
		bag.add(new Item("item5"));
		bag.displayItems();
		bag.getIndexOf(item1);
		bag.remove(item1);
		System.out.println("Does the item exists: "+ bag.contains(item1));
		System.out.println("Item count:"+ bag.getItemCount());
		bag.dump();
		bag.displayItems();
		System.out.println("\nSTACK TEST");
		IStack<Item> stack = new StackADT<Item>(10);
		stack.push(item1);
		System.out.println("On Top: " +stack.peek().toString());
		System.out.println("Is Empty: " +stack.isEmpty());
		stack.pop();
		System.out.println("Is Empty: " +stack.isEmpty());
		System.out.println("\nQUEUE TEST");
		IQueue<Item> queue = new QueueADT<Item>(5);
		queue.enqueue(item1);
		System.out.println("On front: "+queue.getFront().toString());
		queue.dequeue();
		System.out.println("Is Empty after front removed: "+ queue.isEmpty());
	}
}
