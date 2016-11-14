package algorithm;
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Map; 


public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for(int i = 0; i<nums.length-1; i++){
			for(int j = i+1; j<nums.length;j++){
				if(nums[i] + nums[j] == target){
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
        
    }
	
	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int [] dices = new int[2];
		for(int i = 0; i <nums.length; i++){
			hm.put(nums[i], i);			
		}
		for(int i = 0; i <nums.length; i++){
			int remainder = target-nums[i];
			if(hm.containsKey(remainder)&& i!= hm.get(remainder)){
					dices[0] = i;
					dices[1] = hm.get(remainder);
					break;					
			}			
			
		}
		return dices;
		
	}
	public static void main(String args[]) {
		
		int[] numbers = {3,2,4};
		int t = 6;
		int [] r = new int[2];
		TwoSum sum = new TwoSum();
		r= sum.twoSum2(numbers, t);
		System.out.println(r[0]);
		System.out.println(r[1]);
		
		
		
	}

}
