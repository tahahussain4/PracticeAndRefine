package LinkedListAlgorithms;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import arrayLists.LinkedListAlgorithms;

public class LinkedListAdder {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void addLinkedListRepresentedNumbers_1NumberEach() {
		LinkedList<Integer> list1  = new LinkedList();
		list1.add(9);
		
		LinkedList<Integer> list2  = new LinkedList();
		list2.add(8);
		
		LinkedList<Integer> expectedList = new LinkedList();
		expectedList.add(7);
		expectedList.add(1);
		
		assertEquals(expectedList, LinkedListAlgorithms.addLinkedListRepresentedNumbers(list1, list2));
	}
	
	@Test
	public void addLinkedListRepresentedNumbers_2NumberEach() {
		LinkedList<Integer> list1  = new LinkedList();
		list1.add(9);
		list1.add(1);
		
		LinkedList<Integer> list2  = new LinkedList();
		list2.add(8);
		list2.add(2);
		
		LinkedList<Integer> expectedList = new LinkedList();
		expectedList.add(7);
		expectedList.add(4);
		
		assertEquals(expectedList, LinkedListAlgorithms.addLinkedListRepresentedNumbers(list1, list2));
	}
	
	@Test
	public void addLinkedListRepresentedNumbers_2NumberL1_3NumbersL2() {
		LinkedList<Integer> list1  = new LinkedList();
		list1.add(9);
		list1.add(1);
		
		LinkedList<Integer> list2  = new LinkedList();
		list2.add(8);
		list2.add(2);
		list2.add(2);
		
		LinkedList<Integer> expectedList = new LinkedList();
		expectedList.add(7);
		expectedList.add(4);
		expectedList.add(2);
		
		assertEquals(expectedList, LinkedListAlgorithms.addLinkedListRepresentedNumbers(list1, list2));
	}
	
	@Test
	public void addLinkedListRepresentedNumbers_3NumberL1_2NumbersL2() {
		LinkedList<Integer> list1  = new LinkedList();
		list1.add(9);
		list1.add(1);
		list1.add(1);
		
		LinkedList<Integer> list2  = new LinkedList();
		list2.add(8);
		list2.add(2);

		
		LinkedList<Integer> expectedList = new LinkedList();
		expectedList.add(7);
		expectedList.add(4);
		expectedList.add(1);
		
		assertEquals(expectedList, LinkedListAlgorithms.addLinkedListRepresentedNumbers(list1, list2));
	}
	

	@Test
	public void pushToList_1Number() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedListAlgorithms.pushToList(4, list1);
		assertEquals(4, list1.get(0).intValue());
	}
	
	@Test
	public void pushToList_2Number() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedListAlgorithms.pushToList(45, list1);
		LinkedList<Integer> testList = new LinkedList<Integer>();
		testList.add(5);
		testList.add(4);
		
		assertEquals(list1,testList);
	}
	
	@Test 
	public void getLastDigit_1DigitNumber(){
		int testNumber = 1;
		assertEquals(1, LinkedListAlgorithms.getLastDigit(testNumber));
	}
	
	@Test 
	public void getLastDigit_2DigitNumber(){
		int testNumber = 23;
		assertEquals(3, LinkedListAlgorithms.getLastDigit(testNumber));
	}
	
}
