import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
	
	private Node first;
	private int count;
	
	private class Node{
		Item item;
		Node next;
		
		public Node(Node next,Item item){
			this.next = next;
			this.item = item;
		}
	}
	
	public Bag(){
		first = null;
		count = 0;
	}
	
	public void add(Item item){
		if(item == null)
			throw new NullPointerException();
		
		Node oldFirst = first;
		first = new Node(oldFirst,item);
		count++;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return count;
	}

	public Iterator<Item> iterator() {
		return new LinkedStackIterator();
	}
	
	private class LinkedStackIterator implements Iterator<Item>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();		
		}
		
	}
	
	@Override
	public String toString(){
		return "Linked Bag. size " + count;
	}
}

