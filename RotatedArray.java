package algorithm;

public class RotatedArray {
	
	public int search(int[] nums, int target) {
		int indice = -1;
		int len = nums.length;
		int middle = (len+1)/2-1;
		int mid = nums[middle];
		if(mid == target){
			return middle;
		}else{
			if(mid<nums[middle-1]&&mid<nums[middle+1]){
				if(mid<target){
					if(nums[len-1]<target){
						return binarySearch(nums, 0, middle, target);
					}else{
						return binarySearch(nums, middle, len-1, target);
					}
										
				}else if(mid > target){
					return indice;
				}
			}else if (mid>nums[middle-1]&&mid>nums[middle+1]){
				
				if(mid<target){
					return indice;
										
				}else if(mid > target){
					if(nums[len-1]<target){
						return binarySearch(nums, middle, len-1, target);
					}else{
						return binarySearch(nums, 0, middle, target);
					}
				}
				
			}else{
			}
		}
		
		
		return indice;
			
	}
	
	private int binarySearch(int[] nums, int left, int right, int target){
		int len = right-left;
		int middle = len/2;
		if(nums[middle] == target) return middle;
		else if(nums[middle]>target){
			return binarySearch(nums, 0, middle, target);
		}else if(nums[middle]<target){
			return binarySearch(nums, middle, right, target);
		}
		
		return 0;
	}
	
/*	public int search(int[] nums, int target) {
		int indice = -1;
		
		for(int i = 0; i< nums.length; i++){
			if(nums[i]== target) indice = i;
		}
		
        return indice;
    } */
	public static void main(String args[]) {
		RotatedArray ra = new RotatedArray();
		
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int target = 12;
		System.out.println(ra.search(nums, target));
		
	}
}
