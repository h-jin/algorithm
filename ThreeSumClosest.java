package algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class ThreeSumClosest {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		int key;
		Arrays.sort(nums);
		for(int i =0; i<nums.length; i++){
			hm.put(nums[i], i);
		}
		
		for(int m=0; m<nums.length-2;m++){
			if(m>0&&nums[m]==nums[m-1]) continue;
			for(int n=m+1; n<nums.length-1;n++){
				if(n>m+1&&nums[n]==nums[n-1]) continue;
				key= 0-nums[m]-nums[n];
				if(hm.containsKey(key)&&hm.get(key)>n) {
					
					lists.add(Arrays.asList(nums[m],nums[n],key));
				}
			}
			
		}
		return lists;
        
    } 
	
	

}
