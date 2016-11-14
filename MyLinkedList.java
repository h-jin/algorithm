package algorithm;
class ListNode{
	int val;
//	int index;
    ListNode pre;
	ListNode suc;
	ListNode(int val){
		this.val = val;
		pre =null;
		suc = null;
		
	}
		
}

public class MyLinkedList {
	int size;
	ListNode head;
	MyLinkedList(){
		size = 0;
		head = new ListNode(0);
	}
	boolean add(int value){
		ListNode element = new ListNode(value);
		
		if(size==0){
			head.suc= element;
			element.pre=element;
			element.suc = element;
			size++;
			
		}else{
			
			ListNode current = head;
			while(current.suc!=current){
				current = current.suc;				
			}
			element.pre = current;
			element.suc = head.suc;
			head.suc.suc = element;
			size++;
		}
		
		return true;
		
	}
	

}
