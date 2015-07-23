package com.accuship.test;

public class DeleteNode {

	public static void main(String[] args) {

	}
	
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
    
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int val) {
      this.val = val;
      this.next = null;
  }
}

