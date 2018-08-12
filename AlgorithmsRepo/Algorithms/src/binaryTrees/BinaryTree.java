package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {

	Node root;
	
	public void addNode(int key, String name) {

		// Create a new Node and initialize it

		Node newNode = new Node(key, name);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (key < focusNode.key) {

					// Switch focus to the left child

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.println(focusNode);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.print(focusNode);
			System.out.println("  lc : " + focusNode.leftChild + "   rc : " + focusNode.rightChild);
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);
		}

	}

	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (focusNode.key != key) {

			// If we should search to the left

			if (key < focusNode.key) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}


	@SuppressWarnings("unchecked")
	public Node breathFirstSearch(Node node) {
		
		LinkedList<Node> nodeList = new LinkedList<Node>();
		//start from root
		
		if(root != null) {
			ArrayList<String> pathList = new ArrayList<String>();
			pathList.add("top");
			root.setPathList(pathList);

			if(root.equals(node)) {
				return root;
			}
			
			
			nodeList.add(root);
			Node currentNode;
			do {
				currentNode = nodeList.remove();
				
				//check left node
				if(currentNode.leftChild != null) {
					pathList = newPathList(currentNode.getPathList(),"L");
					currentNode.leftChild.setPathList(pathList);
					if (currentNode.leftChild.equals(node)) {
						return currentNode.leftChild;
					}
					else {
						nodeList.add(currentNode.leftChild);
					}
				}

				//check right node
				if(currentNode.rightChild != null) {
					pathList = newPathList(currentNode.getPathList(),"R");
					currentNode.rightChild.setPathList(pathList);
					
					if (currentNode.rightChild.equals(node)) {
						return currentNode.rightChild;
					}
					else {
						nodeList.add(currentNode.rightChild);
					}
				}
			}
			while(!nodeList.isEmpty());
			
		}
		
		
		return null;
	}
	
	private ArrayList<String> newPathList(ArrayList<String> pathList, String direction) {
		ArrayList<String> newPathList = new ArrayList<String>();
		for(String path : pathList) {
			newPathList.add(path);
		}
		newPathList.add(direction);
		return newPathList;
	}

	public static void main(String[] args) {

		BinaryTree theTree = new BinaryTree();

		theTree.addNode(50, "a");

		theTree.addNode(51, "b");

		theTree.addNode(49, "c");
//
		theTree.addNode(53, "d");
//
		theTree.addNode(52, "e");
//
		theTree.addNode(48, "f");
		
		theTree.addNode(47, "g");

		
		
		// Different ways to traverse binary trees

		// theTree.inOrderTraverseTree(theTree.root);

//		 theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75


//		System.out.println(theTree.breathFirstSearch(new Node(1,"a")).key);
		Node foundNode = theTree.breathFirstSearch(new Node(1,"d"));
		System.out.println(foundNode.key);
		System.out.println(foundNode.getPathList().toString());

	}
}

class Node {

	int key;
	String name;
	ArrayList<String> pathList;
	
	Node leftChild;
	Node rightChild;

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	Node(int key, String name) {

		this.key = key;
		this.name = name;

	}

	
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<String> getPathList() {
		return pathList;
	}

	public void setPathList(ArrayList<String> pathList) {
		this.pathList = pathList;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public String toString() {

		return name + " has the key " + key;

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

	}
}

