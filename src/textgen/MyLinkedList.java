package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException
	{
		if(element==null) throw new NullPointerException();
		LLNode<E> node = new LLNode<E>(element);
		if(tail == null){
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index>=size || index<0)
			throw new IndexOutOfBoundsException();
		LLNode<E> ptr = head;
		for(int i=1; i<=index; i++)
			ptr = ptr.next;
		return ptr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws NullPointerException, IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if(element==null) throw new NullPointerException();
		if(index<0 || index>size) throw new IndexOutOfBoundsException();
		LLNode<E> addNode = new LLNode<E>(element);
		if(size == 0) head = tail = addNode;
		if(index == size) {
			tail.next = addNode;
			addNode.prev = tail;
		}
		if(index == 0) {
			addNode.next = head;
			head.prev = addNode;
			head = addNode;
		}
		else {
			LLNode<E> ptr = head;
			for(int i=1; i<index; i++)
				ptr = ptr.next;
			addNode.next = ptr.next;
			addNode.prev = ptr;
			addNode.next.prev = addNode;
			ptr.next = addNode;
		}
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if(index<0 ||index>this.size-1) throw new IndexOutOfBoundsException();
		if(index == 0) {
			E element = head.data;
			head = head.next;
			head.prev = null;
			size--;
			return element;
		}
		if(index == size-1) {
			E element = tail.data;
			tail = tail.prev;
			tail.next = null;
			size--;
			return element;
		}
		LLNode<E> ptr = head;
		for(int i=1; i<index; i++) {
			ptr = ptr.next;
		}
		E element = ptr.next.data;
		ptr.next = ptr.next.next;
		ptr.next.prev = ptr;
		size--;
		return element;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws NullPointerException,IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if(element==null) throw new NullPointerException();
		if(index<0 ||index>this.size-1 || element==null) throw new IndexOutOfBoundsException();
		LLNode<E> ptr = head;
		for(int i=1; i<index; i++) {
			ptr = ptr.next;
		}
		E returnValue = ptr.next.data;
		ptr.next.data = element;
		return returnValue;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
