package AStar;

import java.awt.Color;
import java.util.ArrayList;
import java.util.PriorityQueue;
/* x is vetical ,y is horizontal
{
{}
{}
{}
{}
}

*/
import java.util.concurrent.TimeUnit;

//import org.apache.tomcat.jni.Time;

import Components.Block;
import Components.BlockComparator;
import Components.Grid;

public class AStar {
	GUIPathFinding gui;
	ArrayList<Double> sleepTimes = new ArrayList<Double>();
	
	public AStar(GUIPathFinding gui) {
		super();
		this.gui = gui;
	}

	public void findPath(Grid grid,Coordinates start,Coordinates end,boolean diagonal){
		ArrayList<Block> selected = new ArrayList<Block>();
		PriorityQueue<Block> explored = new PriorityQueue<Block>(6, new BlockComparator());
		//add first node to explored
		grid.getGrid()[start.getX()][start.getY()].setStartCost(0);
		explored.add(grid.getGrid()[start.getX()][start.getY()]);
		
		gui.display(grid, end,selected,explored);
		
		while(true){
			
			//start selecting nodes in the explored list
			this.select(explored.poll(),grid,start,end,selected,explored,diagonal);
			
			//if the explored has end at its peek then the path has been found
			if(explored.peek() == null){
				System.out.println("no available path");
				break;
			}
			
			if(explored.peek().getPos().equals(end)){
				System.out.println("dest reached");
				Block currentBlock = explored.peek();
				break;
			}
		}
		gui.displayFinalPath(grid, end,selected,explored);
	}
	
	public void select(Block currentBlock,Grid grid,Coordinates start,Coordinates end,ArrayList<Block> selected, PriorityQueue<Block> explored,boolean diagonal){
		int dimensionX = grid.getLenght();
		int dimensionY = grid.getWidth();
		selected.add(currentBlock);
		
		int currentX = currentBlock.getPos().getX();
		int currentY = currentBlock.getPos().getY();
		int directionOptions[][] = getDirectionMatrix(diagonal);
		gui.renderBlock(currentBlock.getPos().getX(), currentBlock.getPos().getY(), "selected", end,"");

		for(int directions = 0;directions < directionOptions.length;directions++){
			int nextX = currentX+directionOptions[directions][0];
			int nextY = currentY+directionOptions[directions][1];
			
			if(inBounds(nextX, dimensionX, nextY, dimensionY)){
					Block nextBlock = grid.getGrid()[nextX][nextY];
					if(selectable(selected, nextBlock) ){
						int startCost = getStartCost(currentBlock, directionOptions, directions);
						int destCost = getDestCost(end, nextX, nextY);
						updateNextBlock(explored, currentBlock, nextBlock, destCost, startCost);
						
						if(!explored.contains(nextBlock)){
							explored.add(nextBlock);
							gui.renderBlock(nextBlock.getPos().getX(), nextBlock.getPos().getY(), "explored", end,String.valueOf(nextBlock.getDestCost()));
						}
					}
					
					double startSleep = System.nanoTime();
					try {
						TimeUnit.MILLISECONDS.sleep(SliderState.getSliderValue());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					double endSleep= System.nanoTime();
					sleepTimes.add(endSleep-startSleep);
			}
		}	
	}

	private int[][] getDirectionMatrix(boolean diagonal) {
		if(diagonal){
			int directionOptions[][] = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
			return directionOptions;
		}else{
			int directionOptions[][] = {{0,1},{1,0},{-1,0},{0,-1}};
			return directionOptions;
		}
	}

	private boolean inBounds(int nextX,int dimensionX,int nextY,int dimensionY){
		if(nextX < dimensionX && nextX>=0 && nextY<dimensionY && nextY>=0){
			return true;
		}
		return false;
	}
	
	private boolean selectable(ArrayList<Block> selected,Block nextBlock){
		if(!selected.contains(nextBlock)  && nextBlock.getBlockType() != BlockType.OBSTACLE){
			return true;
		}
		return false;
	}
	
	private int getStartCost(Block currentBlock,int[][] directionOptions,int directions){
		return currentBlock.getStartCost() + 
		(int) Math.sqrt(
				Math.pow((directionOptions[directions][0] *10),2) + 
				Math.pow((directionOptions[directions][1]*10 ),2) 
				) ;
	}
	
	private int getDestCost(Coordinates end,int nextX,int nextY){
		return (int) Math.sqrt(
				Math.pow(Math.abs(nextX - end.getX()),2) * 100 + 
				Math.pow(Math.abs(nextY - end.getY()),2) * 100
				) ;
	}
	
	private void updateNextBlock(PriorityQueue<Block> explored,Block currentBlock,Block nextBlock,int destCost,int startCost){
		if(!explored.contains(nextBlock) ||
				(explored.contains(nextBlock) && (nextBlock.getDestCost() + nextBlock.getStartCost()) > (destCost + startCost))){
					nextBlock.setDestCost(destCost);
					nextBlock.setStartCost(startCost);
					nextBlock.setPreviousBlock(currentBlock);
		}
	}
	
	public double getSleepTimesMilli(){
		double sum = 0;
		for(int index=0;index<sleepTimes.size();index++){
			sum = sum + sleepTimes.get(index);
		}
		return sum/1000000.0;
	}
}
