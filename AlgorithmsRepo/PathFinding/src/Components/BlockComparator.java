package Components;

import java.util.Comparator;


public class BlockComparator implements Comparator<Block>{
	    public int compare(Block o1, Block o2)
	    {
	        int result = ( o1.getStartCost()+o1.getDestCost()) - (o2.getDestCost()+o2.getStartCost());
	        if(result == 0){
	        	return 1;
	        }
	        return result;
	    }
}
