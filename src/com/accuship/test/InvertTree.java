package com.accuship.test;

import java.util.LinkedList;


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class InvertTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode  invert(TreeNode root) {
		if(root == null) return null;
		swap(root);
		invert(root.left);
		invert(root.right);
		return root;
		
	}
	
	public static void invert2(TreeNode root) {
		if(root == null) return;
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		l.add(root);
		while(!l.isEmpty()) {
			TreeNode node = l.remove();
			swap(node);
			if(node.left != null) l.add(node.left);
			if(node.right != null) l.add(node.right);
		}
	}
	
	public static void swap(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

}



class TreeNode {
  public int val;
  public TreeNode left, right;
  public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
  }
}
 