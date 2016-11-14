package algorithm;
import java.util.*;

public class Wiggle {
	
	 public int wiggleMaxLength(int[] nums) {
	        int[] result = new int[nums.length];
	      
	        ArrayList<ArrayList<Integer>> lists = new  ArrayList<ArrayList<Integer>>();
	        
	        
	        for(int i = 0; i< nums.length; i++){
	            if(i== 0){
	                result[i] = 1;
	                ArrayList<Integer> list = new ArrayList<Integer>(); 
	                list.add(result[i]);
	                list.add(nums[i]);
	                lists.add(list);	
	               
	            }else if(i== 1){
	            	if(nums[1]!=nums[0]){
	            		 result[i] = 2;
		            	 ArrayList<Integer> list = new ArrayList<Integer>(); 
		            	 list.add(result[i]);
		            	 list.add(nums[i]);
		            	 list.add(nums[i-1]);
		            	 lists.add(list);
	            		
	            	}else if(nums[1]==nums[0]){
	            		
	            		 result[i] = 1;
		            	 ArrayList<Integer> list = new ArrayList<Integer>(); 
		            	 list.add(result[i]);
		            	 list.add(nums[i]);
		            	 lists.add(list);
	            		
	            	}
	            	
	            }else if (i>=2){
	            	int temp_length=0;
	            	int length=0;
	            	Queue<Integer> q =new LinkedList<Integer>();
	            	ArrayList<Integer> list = new ArrayList<Integer>(); 
	            	for(int j = 0; j<lists.size(); j++){
	            		if(lists.get(j).get(0)==1){
	            			if(lists.get(j).get(1)!=nums[i]){
		            			temp_length = 2;
		            			if(temp_length>length){
		            				length = temp_length;
		            				if(!q.isEmpty()) q.removeAll(q);  
		            				q.add(lists.get(j).get(1)); //preccessor
		            					            				
		            			}else if (temp_length==length){
		            				q.add(lists.get(j).get(1));	            				
		            			}		            			
	            			}else{
		            			temp_length = 1;
		            			if(temp_length>length) {
		            				length = temp_length;
		            			}
		            			
	            			}
	            			
	            		}else if (lists.get(j).get(0)>1){
	            			for(int m = 2; m<lists.get(j).size();m++){
	            				if(nums[i]>lists.get(j).get(1)&& lists.get(j).get(1)<lists.get(j).get(m)
	            				 ||nums[i]<lists.get(j).get(1)&& lists.get(j).get(1)>lists.get(j).get(m)){
	            					temp_length = lists.get(j).get(0)+1;
	            					if(temp_length>length){
	            						length = temp_length;
	    	            				if(!q.isEmpty()) q.removeAll(q);  
	    	            				q.add(lists.get(j).get(1)); //preccessor
	    	            				
	            					}else if (temp_length==length){
	    	            				q.add(lists.get(j).get(1));	            				
	    	            			}
	            					break;
	            					
	            				}
	            				
	            			}
	            			
	            		}
	            			            		
	            	}	            	
	            	result[i] = length;
	            	list.add(result[i]);
	            	list.add(nums[i]);
	            	list.addAll(q);
	            	lists.add(list);
	            		            	
	            }
	            
	        }
	        
	        int max=0;
	        for(int i = 0; i<result.length;i++){
	        	if(result[i]>max){
	        		max = result[i];
	        	}
	        }
	        
	        return  max;
	        
	        
	    }
	 
	 public static void main(String[] args) {
		 int[] nums = {1,17,5,10,13,15,10,5,16,8};
		 Wiggle w = new Wiggle();
		 System.out.println(w.wiggleMaxLength(nums));
	 }

}
