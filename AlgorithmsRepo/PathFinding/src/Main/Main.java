package Main;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

import AStar.AStar;
import AStar.AnimationThread;
import AStar.BlockType;
import AStar.Coordinates;
import AStar.GUIPathFinding;
import AStar.MouseEventQueue;
import AStar.ScheduledHover;
import Components.Block;
import Components.BlockComparator;
import Components.Grid;

public class Main {
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Timer time = new Timer(); 
		int gridWidth  = 100;
		int gridHeight = 100;
		boolean goDiagonal = true;
		boolean putDataInFile = false;
		Grid grid = new Grid(gridHeight,gridWidth);
		
		System.out.println("start2");
		
		grid.randomObstacleGenerator(gridHeight*gridWidth/4);
//		Coordinates start = getUserDefinedCoords(grid);
//		Coordinates end = getUserDefinedCoords(grid);
		
		GUIPathFinding gui = new GUIPathFinding(grid);
		AStar aStar = new AStar(gui);
		
		gui.renderGridFirst(grid);
		
		AnimationThread animator = new AnimationThread(gui);
		time.schedule(animator,0, 100);
		
		ScheduledHover hoverThread = new ScheduledHover(gui);
		time.schedule(hoverThread, 0, 5);
		
		Queue<Coordinates> mouseQueue = MouseEventQueue.getMouseQueue();
		
		//start
		gui.updateHeader("Select a Starting point");
		Coordinates start = getUserSelectedCoords(grid);
 		gui.renderBlock(start.getX(), start.getY(), "selected", null, "");

 		//getting end coordiantes
 		gui.updateHeader("Select an ending point");
 		Coordinates end = getUserSelectedCoords(grid);
 		gui.renderBlock(end.getX(), end.getY(), "path", null, "");
 		
 		//sotp the hovering action
 		hoverThread.cancel();
		
 		//running algorithm
		double timeStart = System.nanoTime();
		aStar.findPath(grid, start,end,goDiagonal);
		double timeEnd = System.nanoTime();
		
		System.out.println("time it took for the algorithnm to run bro: " + (timeEnd/1000000.0 - timeStart/1000000.0 - aStar.getSleepTimesMilli()) + "ms");
		System.out.println("total sleep time : " + aStar.getSleepTimesMilli() + " ms");
		Main.renderConsoleGrid(grid, end,putDataInFile);
	}
	
	public static Coordinates getUserSelectedCoords(Grid grid){
		Queue<Coordinates> mouseQueue = MouseEventQueue.getMouseQueue();
 		while(mouseQueue.isEmpty()){}
 		
 		Coordinates coorindates = new Coordinates((int)mouseQueue.peek().getX() ,(int)mouseQueue.peek().getY());
 		mouseQueue.remove();
 		return coorindates;
	}
	
	public static void renderConsoleGrid(Grid grid,Coordinates end,boolean writeToFile){
		ArrayList<Block> pathList = new ArrayList<Block>();
		Block currentBlock = grid.getGrid()[end.getX()][end.getY()];
		
		while(true){
			pathList.add(currentBlock);
			if(currentBlock.getPreviousBlock() == null){
				break;
			}
			else{
				currentBlock = currentBlock.getPreviousBlock();
			}
		}
		
		
		try {
			PrintWriter print_line;
			FileWriter write = new FileWriter( "generatedPath.txt" , false);
			print_line = new PrintWriter(write);
			
			for(int x=0;x<grid.getLenght();x++){
				for(int y=0;y<grid.getWidth();y++){
					if(pathList.contains(grid.getGrid()[x][y])){
						write(print_line,"| ",writeToFile);
					}
					else if(grid.getGrid()[x][y].getBlockType() == BlockType.OBSTACLE){
						write(print_line,"B ",writeToFile);
					}
					else{
						write(print_line,"- ",writeToFile);
					}
				}
				write(print_line,"\n ",writeToFile);
			}
			
			if(writeToFile){
				print_line.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static void write(PrintWriter writer ,String data,boolean writeToFile){
		if(writeToFile){
			writer.printf("%s",data);
		}else{
			System.out.print(data);
		}
	}
	
	public static Coordinates getUserDefinedCoords(Block[][] grid){
		int height,width;
		int gridHeight = grid.length;
		int gridWidth = grid[0].length;
		
		String errorMsg = "Error!! Please enter again";
		while(true){
			while(true){
				System.out.println("enter the Y coordinate of the point,Should be between " + 0 + "(inclusive) and " + gridHeight + "(exclusive)");
				height = ScannerSupport.getInt();
				if(height >= 0 && height <gridHeight){
					break;
				}
				System.out.println(errorMsg);
			}
			
			while(true){
				System.out.println("enter the X coordinate of the point,Should be between " + 0 + "(inclusive) and " + gridWidth + "(exclusive)");
				width = ScannerSupport.getInt();
				if(width >= 0 && width <gridWidth){
					break;
				}
				System.out.println(errorMsg);				
			}
			
			if(grid[height][width].getBlockType() != BlockType.OBSTACLE){
				break;
			}
			System.out.println("ERROR : user defined point is an obstacle");
		}
		
		
		return new Coordinates(height , width);
	}
}
