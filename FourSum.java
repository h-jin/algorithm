package algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class FourSum {
	
	 public List<List<Integer>> fourSum(int[] nums, int target) {
	        
		 List<List<Integer>> lists = new ArrayList<List<Integer>>();
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

			int key;
			Arrays.sort(nums);
			for(int i =0; i<nums.length; i++){
				hm.put(nums[i], i);
			}
				
			for(int i= 0;i<nums.length-3;i++){	
				if(i>0&&nums[i]==nums[i-1]) continue;
				for(int m=i+1; m<nums.length-2;m++){
					if(m>i+1&&nums[m]==nums[m-1]) continue;
					for(int n=m+1; n<nums.length-1;n++){
						if(n>m+1&&nums[n]==nums[n-1]) continue;
						key= target-nums[i]-nums[m]-nums[n];
						if(hm.containsKey(key)&&hm.get(key)>n) {
							
							lists.add(Arrays.asList(nums[i],nums[m],nums[n],key));
						}
					}
					
				}
				
			}
			
			return lists;
	 	 
	 }

	 public static void main(String args[]) {
		 
		 FourSum tj = new FourSum();
		 List<List<Integer>> lists = new ArrayList<List<Integer>>();
	//	 int [] nums = { -1, 0, 1, 2, -1, -4};
		 int [] nums = {0,0};
		 int target =0;
		 lists = tj.fourSum(nums, target);
		 for(int i = 0; i<lists.size(); i++){
			 for(int j=0; j<lists.get(i).size();j++){
				 System.out.print(lists.get(i).get(j) + " ");
			 }
			 System.out.print("\n");
		 } 
		 
		
	 }
}
