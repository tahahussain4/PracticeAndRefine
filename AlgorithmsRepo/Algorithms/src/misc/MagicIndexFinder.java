package misc;

import java.util.ArrayList;

public class MagicIndexFinder {
	private MagicIndexFinder(){
		
	}
	
	public static int getMaggixIndexNoDuplicates(ArrayList<Integer> magicList) {
		//breakdown list in two 
		//
		boolean flag = true;
		int firstIndex = 0;
		int lastIndex = magicList.size() - 1;
		int midPoint = -1;
		while(flag) {
			midPoint = (lastIndex + firstIndex) / 2;
			if(midPoint == magicList.get(midPoint)) {
				return midPoint;
			}
			if(midPoint > magicList.get(midPoint)) {
				firstIndex = midPoint + 1;
			}
			if(midPoint < magicList.get(midPoint)) {
				lastIndex = midPoint -1;
			}
			if(lastIndex > firstIndex) {
				return -1;
			}
		}
		return -1;
	}
	
	public static ArrayList<Integer> getMagicIndexDuplicates(ArrayList<Integer> list) {
		if(list == null || list.isEmpty()) {
			return null;
		}
		ArrayList<Integer> magicList = new ArrayList<Integer>();
		search(list,0,list.size()-1,magicList);
		
		return magicList;
	}
	
	public static void search(ArrayList<Integer> list,int firstIndex,int lastIndex,ArrayList<Integer> magicList) {
		
		int midpoint =  (firstIndex+lastIndex)/2;
		
		if(lastIndex < firstIndex) {
			return;
		}
		System.out.println("performing serach in");
		System.out.println(list.subList(firstIndex,lastIndex+1));
		
		
		
		if(midpoint == list.get(midpoint)) {
			magicList.add(midpoint);
		}
		
		if(lastIndex == firstIndex) {
			return;
		}
		//do search on right side
		search(list,Math.max(midpoint + 1,list.get(midpoint)),lastIndex,magicList);
		
		//do search on left Side
		search(list,firstIndex,Math.min(midpoint - 1,list.get(midpoint)),magicList);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-2);
		list.add(-1);
		list.add(2);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(7);
		list.add(7);
		ArrayList<Integer> magicList = MagicIndexFinder.getMagicIndexDuplicates(list);
		System.out.println("final magic list");
		System.out.println(magicList.toString());
	}
}
