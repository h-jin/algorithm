package algorithm;

public class KthElement {
	
	 public int findKthLargest(int[] nums, int k) {
		 
		 int [] firstPart;
		 int [] secondPart;
		 int pivot = nums[nums.length-1];
		 int position = 0;
		 int insert = -1;
		 int temp;
	/*	 for(int i = 1; i<nums.length; i++){
			if(nums[i]>pivot){ 
				temp = nums[i];
				nums[i] = nums[insert];
				nums[insert] = temp;
				position = i;
				insert++;
			}
		 } */
		 
		 for(int j = 0; j<nums.length-1; j++){
			 
			 if(nums[j]>pivot){
				 insert = insert +1;
				 temp = nums[insert];
				 nums[insert] = nums[j];
				 nums[j] = temp;
				 
			 }
		 }
		 temp= nums[insert+1];
		 nums[insert+1] = pivot;
		 nums[nums.length-1] = temp;
		 position = insert+1;
		 
		 
		 firstPart = new int[position];
		 secondPart = new int[nums.length-(position+1)];
		 
		
		 System.arraycopy(nums, 0, firstPart, 0, position);
		 
		 System.arraycopy(nums, position+1, secondPart, 0, nums.length-(position+1));
		 
		 
		 
		 if(k==position+1){
			 return nums[position];
			 
		 }else if(k<position+1){
			 return findKthLargest(firstPart,k);
		 }else if (k>position+1){
			 return findKthLargest(secondPart,k-(position+1));
		 }   
		 
		 return 0;
	        
	 }
	 
	 public static void main(String args[]) {
		 int[] nums = {5,2,4,1,3,6,0} ;
		 int [] arr = {};
		 int p;
		 KthElement test = new KthElement();
	//	 arr = test.findKthLargest(nums, 3);
	/*	 for(int i= 0; i<arr.length; i++){
			 System.out.println(arr[i]);
		 } */
		 
	     System.out.print(test.findKthLargest(nums, 4));

	 }

}
