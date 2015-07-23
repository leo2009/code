package com.accuship.test;

public class SortLinked {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(2);
		insertionSortList(head);
		
	}
    public static ListNode insertionSortList(ListNode head) {
        // write your code here
        int len = size(head);
        ListNode p;
        System.out.println("len..........." + len);
        for(int i=0; i<len-1; i++) {
        	p = head;
            for(int j=i; j<len-1; j++) {
            	System.out.println("i..........." + i);
            	System.out.println("j..........." + j);
                if(p.val > p.next.val) {
                    swapValue(p);
                }
                p = p.next;
            }
        }
        return head;
        
    }
    
    public static void swapValue(ListNode node) {
        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;
    }
    
    public static int size(ListNode head) {
        if(head == null) return 0;
        ListNode p = head;
        int count = 1;
        while(p.next != null) {
            count++;
            p = p.next;
        }
        return count;
    }

}
