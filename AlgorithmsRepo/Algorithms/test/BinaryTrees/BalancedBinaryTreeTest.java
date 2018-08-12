package BinaryTrees;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import binaryTrees.BalancedBinaryTree;
import binaryTrees.Node;


public class BalancedBinaryTreeTest {
	BalancedBinaryTree<Integer> testTree ;
	
	@Test
	public void getLevelsNumberOfNodes_FullLevel() {
		
		testTree = new BalancedBinaryTree<Integer>(4);
		assertEquals(0,testTree.getLevels(0));
		assertEquals(0,testTree.getLevels(1));
		assertEquals(1,testTree.getLevels(2));
		
		assertEquals(1,testTree.getLevels(3));
		assertEquals(2,testTree.getLevels(4));
		assertEquals(2,testTree.getLevels(5));
		
		assertEquals(3,testTree.getLevels(9));
		
	}
	
	@Test
	public void getThereticalNodesFromLevels() {
		testTree = new BalancedBinaryTree<Integer>(5);
		assertEquals(1, testTree.getTotalTheoreticalNodes(0));
		assertEquals(3, testTree.getTotalTheoreticalNodes(1));
		assertEquals(7, testTree.getTotalTheoreticalNodes(2));
		assertEquals(15, testTree.getTotalTheoreticalNodes(3));
		assertEquals(31, testTree.getTotalTheoreticalNodes(4));
	}
	
	
	@Test
	public void getTheoreticalNodesOnLevel_0Level() {
		testTree = new BalancedBinaryTree<Integer>(5);

		assertEquals(1, testTree.getTheoreticalNodesOnLevel(0));
		assertEquals(2, testTree.getTheoreticalNodesOnLevel(1));
		assertEquals(4, testTree.getTheoreticalNodesOnLevel(2));
		assertEquals(8, testTree.getTheoreticalNodesOnLevel(3));
	}
	
	
	@Test
	public void getPath_NodeLeftMost_2Level() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		expectedPathList.add(0);
		expectedPathList.add(0);
		
		int levels = 2;
		int nodePositionOnLevel = 1;
		
		testTree = new BalancedBinaryTree<Integer>(5);
		Node<Integer> rootNode = testTree.getRootNode();
		rootNode.setChild(0, 1);
		rootNode.setChild(1,2);
		
		Node<Integer> leftChild = rootNode.getChild(0);
		Node<Integer> rightChild = rootNode.getChild(1);
		
		leftChild.setChild(0,3);
		leftChild.setChild(1, 4);
		
		rightChild.setChild(0,5);
		rightChild.setChild(1,6);
		
		assertEquals(expectedPathList,testTree.getPathToPosition(nodePositionOnLevel, levels));
	}
	
	@Test
	public void getPath_Node_NodePosition2_2Level() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		expectedPathList.add(0);
		expectedPathList.add(1);
		
		int levels = 2;
		int nodePositionOnLevel = 2;
		
		
		testTree = new BalancedBinaryTree<Integer>(5);
		Node<Integer> rootNode = testTree.getRootNode();
		rootNode.setChild(0, 1);
		rootNode.setChild(1,2);
		
		Node<Integer> leftChild = rootNode.getChild(0);
		Node<Integer> rightChild = rootNode.getChild(1);
		
		leftChild.setChild(0,3);
		leftChild.setChild(1, 4);
		
		rightChild.setChild(0,5);
		rightChild.setChild(1,6);

		assertEquals(expectedPathList,testTree.getPathToPosition(nodePositionOnLevel, levels));
	}
	
	@Test
	public void getPath_Node_NodePosition3_3Level() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		expectedPathList.add(0);
		expectedPathList.add(1);
		expectedPathList.add(0);
		
		int levels = 3;
		int nodePositionOnLevel = 3;
		
		
		testTree = new BalancedBinaryTree<Integer>(5);
		Node<Integer> rootNode = testTree.getRootNode();
		rootNode.setChild(0, 1);
		rootNode.setChild(1,2);
		
		Node<Integer> leftChild = rootNode.getChild(0);
		Node<Integer> rightChild = rootNode.getChild(1);
		
		leftChild.setChild(0,3);
		leftChild.setChild(1, 4);
		
		rightChild.setChild(0,5);
		rightChild.setChild(1,6);

		assertEquals(expectedPathList,testTree.getPathToPosition(nodePositionOnLevel, levels));
	}
	
	@Test
	public void getPath_Node_NodePosition5_3Level() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		expectedPathList.add(1);
		expectedPathList.add(0);
		expectedPathList.add(0);
		
		int levels = 3;
		int nodePositionOnLevel = 5;
		
		
		testTree = new BalancedBinaryTree<Integer>(5);
		Node<Integer> rootNode = testTree.getRootNode();
		rootNode.setChild(0, 1);
		rootNode.setChild(1,2);
		
		Node<Integer> leftChild = rootNode.getChild(0);
		Node<Integer> rightChild = rootNode.getChild(1);
		
		leftChild.setChild(0,3);
		leftChild.setChild(1, 4);
		
		rightChild.setChild(0,5);
		rightChild.setChild(1,6);

		assertEquals(expectedPathList,testTree.getPathToPosition(nodePositionOnLevel, levels));
	}
	
	@Test
	public void getPath_Node_NodePosition8_3Level() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		expectedPathList.add(1);
		expectedPathList.add(1);
		expectedPathList.add(1);
		
		int levels = 3;
		int nodePositionOnLevel = 8;
		
		
		testTree = new BalancedBinaryTree<Integer>(5);
		Node<Integer> rootNode = testTree.getRootNode();
		rootNode.setChild(0, 1);
		rootNode.setChild(1,2);
		
		Node<Integer> leftChild = rootNode.getChild(0);
		Node<Integer> rightChild = rootNode.getChild(1);
		
		leftChild.setChild(0,3);
		leftChild.setChild(1, 4);
		
		rightChild.setChild(0,5);
		rightChild.setChild(1,6);

		assertEquals(expectedPathList,testTree.getPathToPosition(nodePositionOnLevel, levels));
	}
	
	@Test
	public void insertNode_NodeOnTop() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		
		testTree = new BalancedBinaryTree<Integer>();
		testTree.insert(4);
		assertEquals(4,(int) testTree.getRootNode().getValue());
	}
	
	@Test
	public void insertNode_SecondNode() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		
		testTree = new BalancedBinaryTree<Integer>(5);
		Node<Integer> rootNode = testTree.getRootNode();
		testTree.insert(5);
		assertEquals(5,(int) testTree.getRootNode().getChild(0).getValue());
	}
	
	@Test
	public void insertNode_ThirdNode() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		
		testTree = new BalancedBinaryTree<Integer>(5);
		Node<Integer> rootNode = testTree.getRootNode();
		
		testTree.insert(5);
		testTree.insert(6);
		
		assertEquals(6,(int) rootNode.getChild(1).getValue());
	}
	
	@Test
	public void insertNode_SevenNodes() {
		ArrayList<Integer> expectedPathList = new ArrayList<Integer>();
		
		testTree = new BalancedBinaryTree<Integer>();
		
		testTree.insert(1);
		testTree.insert(2);
		testTree.insert(3);
		testTree.insert(4);
		testTree.insert(5);
		testTree.insert(6);
		testTree.insert(7);
		
		Node<Integer> rootNode = testTree.getRootNode();
		assertEquals(1,(int) rootNode.getValue());
		assertEquals(2,(int) rootNode.getChild(0).getValue());
		assertEquals(3,(int) rootNode.getChild(1).getValue());
		assertEquals(4,(int) rootNode.getChild(0).getChild(0).getValue());
		assertEquals(5,(int) rootNode.getChild(0).getChild(1).getValue());
		assertEquals(6,(int) rootNode.getChild(1).getChild(0).getValue());
		assertEquals(7,(int) rootNode.getChild(1).getChild(1).getValue());
	}
}
