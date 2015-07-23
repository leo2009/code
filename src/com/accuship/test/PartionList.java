package com.accuship.test;

public class PartionList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
//		printList(head);
//		ListNode res = partition(head, 3);
//		printList(res);
		System.out.println("title..........." + test(head, 3));
		printList(head);
	}
	
	public static ListNode test(ListNode head, int x) {
		int size = size(head);
		ListNode p;
		int count = 0;
		for(int i=0; i<size; i++) {
			p = head;
			while(hasNext(p)) {
				if(p.val >= x && p.next.val < x) swap(p);
				p = p.next;
			}
		}
		return head;
	}
	
	public static void swap(ListNode node) {
		int temp = node.val;
		node.val = node.next.val;
		node.next.val = temp;
	}
	
    public static ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null) return head;
        ListNode res = new ListNode(0);
        ListNode pHead = head;
        ListNode pRes = res;
        while(pHead != null) {
            if(pHead.val < x) {
                pRes.val = pHead.val;
                pRes.next = new ListNode(0);
                pRes = pRes.next;
            }
            pHead = pHead.next;
        }
        pHead = head;
        while(pHead != null) {
            if(pHead.val >= x) {
                pRes.val = pHead.val;
                pRes.next = (pHead.next == null ? null : new ListNode(0));
                pRes = pRes.next;
            }
            pHead = pHead.next;
        }
        return res;
    }
    
    public static int size(ListNode head) {
    	
        int count = head == null ? 0 : 1;
        ListNode p = head;
        while(hasNext(p)) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    public static boolean hasNext(ListNode node) {
        if(node == null) return false;
        return node.next != null;
    }
    
    public static void printList(ListNode head) {
    	ListNode p = head;
    	int count = 0;
    	while(p !=null) {
    		count++;
    		System.out.print(p.val + " ");
    		if(count > 10) {
    			System.out.println("title..........." + "too much");
    			return;
    		}
    		p = p.next;
    	}
    	System.out.println();
    	
    }

}
