package com.accuship.test;

public class NthToLast {

	public static void main(String[] args) {

	}
	
	public static ListNode nthToLast(ListNode head, int n) {
		ListNode res = head;
		for(int i=0; i<length(head)-n; i++) {
			res = res.next;
		}
		return res;
    }
	public static boolean hasNext(ListNode node) {
		return node.next != null;
	}
	
	public static int length(ListNode root) {
		if(root == null) return 0;
		int count = 1;
		ListNode pointer = root;
		while(hasNext(pointer)) {
			count++;
			pointer = pointer.next;
		}
		return count;
	}
	

}
