package algorithm;
import algorithm.Node;

public class RemoveElement {

	 public Node removeElements(Node head, int val) {
		 
		 Node pointer1 = head;
		 Node pointer2 = null;
		 if(head!=null) pointer2 = head.next;
			 
		 if(head!=null&&head.next==null&&head.val==val) return null;
		 
		 while(pointer2!=null){
			 
					 			 
			 if(pointer1.val==val){
				 head = head.next;
				 pointer1=head;
				 pointer2=pointer2.next; 
				 if(pointer2==null&&pointer1.val==val) return null;			
				 continue;
			 }
			 
			 if(pointer2.val==val){
				 pointer2 = pointer2.next;
				 pointer1.next= pointer2;
			 }else{
				 pointer1=pointer2;
				 pointer2=pointer2.next;
			 }
			 
		 }
		 
		 return head;
	       
	 }
}

