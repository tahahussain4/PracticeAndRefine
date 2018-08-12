package misc;

import java.util.ArrayList;
import java.util.HashSet;

public class SubsetGenerator {
	
	public SubsetGenerator() {
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		HashSet<String> testSet = new HashSet<String>();
		testSet.add("a");
		testSet.add("b");
		testSet.add("c");
		testSet.add("d");
		testSet.add("e");
		
		SubsetGenerator generator = new SubsetGenerator();
		ArrayList<ArrayList<String>> subsets = generator.generateSubsets(testSet);
		System.out.println(subsets.toString());
	}
	
	public ArrayList<ArrayList<String>> generateSubsets(HashSet<String> set){
		if (set == null) {
			return null;
		}
		
		ArrayList<ArrayList<String>> subsets = new ArrayList<ArrayList<String>>();
		ArrayList<String> zeroElementList = new ArrayList<String>();
//		zeroElementList.add("");
		zeroElementList.add(null);
		subsets.add(zeroElementList);
		
		for(String element : set) {
			//clone list
			ArrayList<ArrayList<String>> cloneList = new ArrayList<ArrayList<String>>();
			for(ArrayList<String> subset : subsets) {
				cloneList.add((ArrayList<String>) subset.clone());
			}
			
			//add elemnent to cloned list
			this.add(cloneList,element);
			
			//add all coonelist elements to original subset list
			subsets.addAll(cloneList);
		
		}
		return subsets;
	}
	
	public void add(ArrayList<ArrayList<String>> cloneList,String element){
		int sizeOfSubsets = cloneList.size(); 
		for(int subsetsPos=0;subsetsPos < sizeOfSubsets;subsetsPos++) {
			//go thorugh all prvious list and add
			ArrayList<String> workingList = cloneList.get(subsetsPos);
			if(workingList.get(0) == null) {
				workingList.add(0, element);
			} else {
				workingList.add(element);
			}
		}
	}
}
