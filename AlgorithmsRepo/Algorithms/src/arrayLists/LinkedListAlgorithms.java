package arrayLists;

import java.util.LinkedList;

import javax.print.attribute.standard.Chromaticity;

public class LinkedListAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> number1 = new LinkedList<Integer>();
		number1.add(9);
		number1.add(9);
		number1.add(9);

		LinkedList<Integer> number2 = new LinkedList<Integer>();
		number2.add(9);
		number2.add(9);
		number2.add(9);
		
		System.out.println(addLinkedListRepresentedNumbers(number1, number2).toString());
	}

	public static LinkedList<Integer> addLinkedListRepresentedNumbers(LinkedList<Integer> number1,LinkedList<Integer> number2) {
		LinkedList<Integer> resultList = new LinkedList<Integer>();
		int carry=0;
		int linkedSize1 = number1.size();
		int linkedSize2 = number2.size();
		int maxSize = Math.max(linkedSize1,linkedSize2) ;
		int addedNumber;
		int digit1;
		int digit2;
		int lastDigit;
	
		String addedNumberString;
		for(int digit=0;digit < maxSize ; digit++) {
			digit1 = (digit < linkedSize1 ) ? number1.get(digit)  : 0;
			digit2 = (digit < linkedSize2 ) ? number2.get(digit)  : 0;
			
			addedNumber = digit1 + digit2 + carry;
			
			if(digit < maxSize - 1) {
				carry = addedNumber / 10;
				lastDigit = getLastDigit(addedNumber);
				resultList.add(lastDigit);
			} else {
				pushToList(addedNumber,resultList);
			}
		}
		return resultList;
	}
	
	public static void pushToList(int numberToPush, LinkedList<Integer> list) {
		int digitToAdd ;
		int numberLeft = numberToPush;
		while((digitToAdd = getLastDigit(numberLeft)) != 0 ) {
			list.add(digitToAdd);
			numberLeft = numberLeft / 10;
		}
	}
	
	public static int getLastDigit(int addedNumber) {
		String addedNumberString = String.valueOf(addedNumber);
		return Character.getNumericValue(addedNumberString.charAt(addedNumberString.length()-1));
	}
}
