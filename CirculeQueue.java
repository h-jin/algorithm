package algorithm;

public class CirculeQueue {
	
	int defaultSize=100;
	int front;
	int rear;
	int flag;
	int maxSize;
	Object[] q;
	CirculeQueue(){
		init(defaultSize);
		
	}
	
	CirculeQueue(int size){
		
		init(size);
	}
	private void init(int size){
		maxSize = size;
		front = rear = 0;
		flag = 0;
		q = new Object[size];
	}
	public void add(Object o){
		if(front == rear && flag == 1){
			
			System.out.println("Full Queue");
			
		}
		q[rear] = o;
		rear = (rear +1)%maxSize;
		flag = 1;
		
	}
	public Object remove(){
		if(front == rear && flag ==0){
			System.out.println("Empty Queue");
			
		}
		Object o = q[front];
		front = (front+1)%maxSize;
		flag = 0;
		return o;
		
	}
	

}
