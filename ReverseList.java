package algorithm;

import algorithm.Node;

public class ReverseList {
	
	 public Node reverseList(Node head) {
		 
		 if(head == null || head.next == null) return head;
		 Node first = head;
		 Node second = first.next;
		 Node third = second.next;
		 Node temp = null;
		 first.next = null;
		 while(third!=null){
			second.next=first;
			temp = second;
			second = third;
			third = third.next;
			first = temp;
			 
		 }
		 second.next =first;
		 return second;
	        
	 }

}
