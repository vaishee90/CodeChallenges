package Trees;

import java.util.Stack;

public class Traversal {
	TreeNode createTree() {

		/*
		 * 							 	0 
		 * 							/ 		\ 
		 * 						   1 		 2 
		 * 						/ 	  \ 	  /     \ 
		 * 					   3 	   4 5 		 6 
		 * 						\ 				/ 
		 * 						 7 			   8 
		 * 										\ 
		 * 										 9
		 */
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);

		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t2.right = t6;
		t3.right = t7;
		t6.left = t8;
		t8.right = t9;

		return root;
	}

	public static void main(String[] args) {
		Traversal t = new Traversal();
		TreeNode root = t.createTree();

		System.out.println("PreOrderTraversalIter: ");
		printPreOrderTraversalIter(root);
		System.out.println("\nInOrderTraversalIter: ");
		printInOrderTraversalIter(root);
		System.out.println("\nPostOrderTraversalIter: ");
		printPostOrderTraversalIter(root, 2);

		System.out.println("\nPreOrderTraversalRecur: ");
		printPreOrderTraversalRecur(root);
		System.out.println("\nInOrderTraversalRecur: ");
		printInOrderTraversalRecur(root);
		System.out.println("\nPostOrderTraversalRecur: ");
		printPostOrderTraversalRecur(root);
	}

	
	private static void printPostOrderTraversalIter(TreeNode root, int noOfStacks) {
        Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;
		s.push(curr);
		
		// using one stack - geeksforgeeks
		if(noOfStacks == 1) {
			TreeNode prev = null;
	        while(!s.isEmpty()){
	        	
	        		curr = s.peek();
	        		//traversing down the tree
	        		if(prev == null || prev.left == curr || prev.right == curr) {
	        			if(curr.left != null)
	        				s.push(curr.left);
	        			else if(curr.right != null)
	        				s.push(curr.right);
	        			else 
	        				System.out.print(s.pop().val + " ");
	        		}
	        		//check for right subtree since left has been processed
	        		else if(curr.left == prev) {
	        			if(curr.right != null)
	        				s.push(curr.right);
	        			else
	        				System.out.print(s.pop().val + " ");
	        		}
	        		//return the root after processing left and right
	        		else if(curr.right == prev){
	        			System.out.print(s.pop().val + " ");
	        		}
	        		
	        		prev = curr; 
	        }
		}
		// using two stacks - geeksforgeeks
		else {
			Stack<TreeNode> s2 = new Stack<>();
			while(!s.isEmpty()) {
				curr = s.pop();
				s2.push(curr);
				
				if(curr.left != null)
					s.push(curr.left);
				if(curr.right != null)
					s.push(curr.right);
			}
			
			while(!s2.isEmpty())
				System.out.print(s2.pop().val + " ");
		}
    }

	private static void printInOrderTraversalIter(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();

		TreeNode curr = root;

		if (root != null) {

			while (curr != null || !s.isEmpty()) {

				while (curr != null) {
					s.push(curr);
					curr = curr.left;
				}

				curr = s.pop();
				System.out.print(curr.val + " ");

				curr = curr.right;
			}
		}
	}

	private static void printPreOrderTraversalIter(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		if (root != null) {
			s.push(root);

			while (!s.isEmpty()) {
				TreeNode curr = s.pop();
				System.out.print(curr.val + " ");

				if (curr.right != null)
					s.push(curr.right);

				if (curr.left != null)
					s.push(curr.left);
			}
		}
	}

	private static void printPostOrderTraversalRecur(TreeNode root) {
		if (root != null) {
			printPostOrderTraversalRecur(root.left);
			printPostOrderTraversalRecur(root.right);
			System.out.print(root.val + " ");
		}

	}

	private static void printInOrderTraversalRecur(TreeNode root) {
		if (root != null) {
			printInOrderTraversalRecur(root.left);
			System.out.print(root.val + " ");
			printInOrderTraversalRecur(root.right);
		}

	}

	private static void printPreOrderTraversalRecur(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			printPreOrderTraversalRecur(root.left);
			printPreOrderTraversalRecur(root.right);
		}

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}
}
