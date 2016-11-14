package algorithm;
import java.util.*;

public class TopKFrequence {
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        
        Queue<int[]> pairs = new PriorityQueue<int[]>(new  Comparator<int[]>(){
      	
        	public int compare(int[]q1, int[]q2){
        		return q2[1]-q1[1];
        	}
        }
        );
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
        	hm.put(nums[i], hm.getOrDefault(nums[i], 1)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
        	pairs.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        
        for(int i =0; i<k;i++){
        	result.add(pairs.poll()[0]);
        }
        return result;
		
    }

}
