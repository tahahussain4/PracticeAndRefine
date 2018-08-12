package binaryTrees;

import java.util.ArrayList;

public class BalancedBinaryTree<T> {
	private Node<T> rootNode;
	private int numberOfNodes;
	
	public static void main(String[] args) {
		
	}
	
	public BalancedBinaryTree(T value) {
		super();
		rootNode = new Node<T>(value);
		setNumberOfNodes(1);
	}
	
	

	public BalancedBinaryTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(T value) {
		if(getNumberOfNodes()  == 0) {
			setNumberOfNodes(getNumberOfNodes() + 1);
			setRootNode(new Node<T>(value));
			return;
		}
		
		int newNumberOfNodes = numberOfNodes +1;
		int newNodelevel = getLevels(newNumberOfNodes);
		int nodePosition = newNumberOfNodes - getTotalTheoreticalNodes(newNodelevel-1);
		ArrayList<Integer> path = getPathToPosition(nodePosition,newNodelevel);
		
		//get path
		Node<T> tempNode = getRootNode();
		for(int levelIterator=0;levelIterator < newNodelevel - 1;levelIterator++ ) {
			tempNode = tempNode.getChild(path.get(levelIterator));
		}
		tempNode.setChild(path.get( path.size()-1) , value);
		setNumberOfNodes(getNumberOfNodes() +1);
	}
	
	public ArrayList<Integer> getPathToPosition(int nodePositionOnLevel, int nodeLevel) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		if(nodePositionOnLevel <= 0) {
			return null;
		}
		
		int levelMidPoint = getTheoreticalNodesOnLevel(nodeLevel)/2;
		for(int level=0;level < nodeLevel ;level++) {
			
			if(nodePositionOnLevel <= levelMidPoint ) {
				path.add(0);
			} else {
				path.add(1);
				nodePositionOnLevel = nodePositionOnLevel - levelMidPoint;
			}
			levelMidPoint = levelMidPoint / 2;
		}
		return path;
	}

	public int getTheoreticalNodesOnLevel(int levels) {
		return (int) Math.pow(2, levels);
	}

	public int getLevels(int numberOfnodes) {
		int levels = 0;
		double dividedNodes = Double.valueOf(numberOfnodes);
		while((dividedNodes = (double) (dividedNodes / 2.0)) >= 1.0) {
			levels++;
		}
		return levels;
	}
	
	public int getTotalTheoreticalNodes(int level) {
		return (int) (Math.pow(2, level + 1) - 1);
	}

	public Node<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node<T> rootNode) {
		this.rootNode = rootNode;
	}

	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}	
}
