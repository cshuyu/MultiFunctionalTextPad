/**
 * 
 */
package textgen;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet() 
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
			
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}	
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		// TODO: Add more tests here
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {	
		}
		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {	
		}
		String b = shortList.remove(1); 
		assertEquals("Remove: check b is correct", "B", b);
		assertEquals("Remove: check element 0 is correct", (String)"A", shortList.get(0));
		assertEquals("Remove: check size is correct", 1, shortList.size());
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			list1.add(null);
			fail("Check null element");
		}
		catch (NullPointerException e) {
		}
		emptyList.add(0);
		assertEquals("AddEnd: check emptyList is correct", (Integer)0, emptyList.get(0));
		assertEquals("AddEnd: check size of emptyList is correct", 1, emptyList.size());
		list1.add(27);
		assertEquals("AddEnd: check current end element is correct", (Integer)27, list1.get(3));
		assertEquals("AddEnd: check previous end element 2 is correct", (Integer)42, list1.get(2));
		assertEquals("AddEnd: check size of list1 is correct", 4, list1.size());
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check emptyList size is correct", 0, emptyList.size());
		assertEquals("Size: check longerList size is correct", 10, longerList.size());
	}

	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			emptyList.add(1,5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.add(-1,"C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.add(3,"C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.add(1,null);
			fail("Check null element");
		}
		catch (NullPointerException e) {
		}
		emptyList.add(0,5);
		assertEquals("AddAtIndex: check add element of emptyList is correct", (Integer)5, emptyList.get(0));
		assertEquals("AddAtIndex: check the size of emptyList is correct", 1, emptyList.size());
		list1.add(3,27);
		assertEquals("AddAtIndex: check element 3 of list1 is corrct", (Integer)27, list1.get(3));
		assertEquals("AddAtIndex: check element 2 of list1 is corrct", (Integer)42, list1.get(2));
		assertEquals("AddAtIndex: check the size of list1 is correct", 4, list1.size());
		list1.add(1,29);
		assertEquals("AddAtIndex: check element 1 of list1 is corrct", (Integer)29, list1.get(1));
		assertEquals("AddAtIndex: check element 2 of list1 is corrct", (Integer)21, list1.get(2));
		assertEquals("AddAtIndex: check element 0 of list1 is corrct", (Integer)65, list1.get(0));
		assertEquals("AddAtIndex: check the size of list1 is correct", 5, list1.size());
	}
	
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			shortList.set(-1,"C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {}
		
		try {
			shortList.set(1,null);
			fail("Check null element");
		}
		catch (NullPointerException e) {}
		
		try {
			shortList.set(3,"C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {}
		
		try {
			emptyList.set(0,5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {}
		
		assertEquals("Set: check the return element", (Integer)42, list1.set(2,27));
		assertEquals("Set: check the set element", (Integer)27, list1.get(2));
		assertEquals("Set: check the element 1", (Integer)21, list1.get(1));
		assertEquals("Set: check the size", 3, list1.size());
	}
	
}
