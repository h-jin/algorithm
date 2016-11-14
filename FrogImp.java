package algorithm;

import java.util.*;
import java.math.BigInteger;

public class FrogImp {
	
	 public int solution(int X, int Y, int D) {
	        // write your code in Java SE 8
		   int step = 0;
		   if(Y==X)  return step;
		   if(Y>X){
			   int temp = (Y-X)%D;
			   if(temp == 0) step = (Y-X)/D;
			   else if(temp!=0) step = (Y-X)/D+1;			   
		   }
		   return step;
		 
	 }
	 
	 public int solution2(int[] A) {
	        // write your code in Java SE 8
		 
		 int first = A[0];
		 int second = 0;
		 for(int i= 1; i<A.length; i++){
			 
			 second += A[i];
		 }
		 
		 int dif = Math.abs(second - first);
		 
		 for(int i=2; i<A.length; i++){
			 first += A[i-1];
			 second = second- A[i-1]; 
			 int temp = Math.abs(second - first);
			 if(temp < dif) dif = temp;
		 }
		 
		 return dif;
	 }
	 
	 public int solution3(int[] A) {
	        // write your code in Java SE 8	
		 int flag = 1;
		 int N = A.length;
		 String[] B = new String[N];
		 for(int i =0; i<N; i++){
			B[i] = "false"; 
		 }
		 for(int i  =0; i<N; i++){
			 if(A[i]<=N&&B[A[i]-1].equals("false")) B[A[i]-1] = "true";
		 }
		 for(int i =0; i<N; i++){
				if(B[i].equals("false")){ 
					flag = 0;
					break;
				}
		 }		 
		 return flag;
	}
	 
	 public int solution4(int[] A) {
	        // write your code in Java SE 8
		 
		 int N = A.length;
		 String[] B = new String[N];
		 int result = 1;
		 		 
		 for(int i =0; i<N; i++){
				B[i] = "false"; 
		 }
		 for(int i = 0; i<N; i++){
			 if(A[i]<=0)	continue;
			 if(A[i]<=N) B[A[i]-1] = "true";
			 
		 }
		 
		 for(int i =0; i<N; i++){
				if(B[i].equals("false")){
					result = i+1;
					break;
				}
				if(i == N-1) result = N+1;
		 }
		
		 return result;
		 
	 }
	 
	 public int[] solution5(int N, int[] A) {
	        // write your code in Java SE 8
		 	int [] counters = new int[N];
		 	int maxCounter = 0;
		 	int curMax = 0;
		 	int size  = A.length;
		 	for(int i=0; i<size; i++){
		 		if(A[i]<=N && A[i]>=1) {
		 			counters[A[i]-1] = Math.max(curMax, counters[A[i]-1]);
		 			counters[A[i]-1] +=1;
		 			maxCounter = Math.max(counters[A[i]-1], maxCounter);
		 		}
		 		if(A[i]==N+1){
		 			
		 			curMax = maxCounter;
		 		}
		 	}
		 	
		 	
 			for(int j =0; j<N; j++){
 				counters[j] = Math.max(curMax, counters[j]);

 			}
 			 				 	
		 	return counters;
	 }
	 
	 public int solution6(int[] A) { //passing car
	        // write your code in Java SE 8
		 
		 int countZero = 0;
		 int pair = 0;
		 int size = A.length;
		 for(int i = 0; i<size; i++){
			 if(A[i] == 0) countZero++;
			 if(A[i] == 1&&countZero == 0) continue;
			 if(A[i] == 1&&countZero!= 0) {
				 pair += countZero;		 
			 }
			 if(pair>1000000000) return -1;
		 }
		 
		// if(pair>1000000000) pair = -1;
		 return pair;
	 }
	 
	 public int solution7(int[] A) {
	        // write your code in Java SE 8
		  int size  = A.length;
		  int min = (A[0]+A[1])/2;
		  if(size==2) return min;
		  
		  int [] minSet = new int[size];
		  int [] upper = new int[size];
		  int [] down = new int[size];
		  minSet[0] = min; 
		  upper[0] = A[0]+A[1];
		  down[0] =2;
		  
		  
		  for(int i = 1; i<size-1; i++){
			  if((A[i]+A[i+1])/2<minSet[i]) minSet[i] = (A[i]+A[i+1])/2;
			  
		  }
		  
		  int [] temp1 = new int[size];
		  int [] temp2 = new int[size];
		  temp1[0] = A[0]+A[1];
		  temp2[0] = 2;
		  int tempMin1;
		  int tempMin2;
		  for(int i = 2; i<size; i++){
			  tempMin1 = (A[i]+A[i-1])/2;
			  tempMin2 = (temp1[i-2]+ A[i])/(temp2[i-1]+1);
			  if(tempMin2<min) {
				  min = tempMin2;
				  temp2[i-2] +=1;
			  }
			  if(tempMin1<min){
				  min = tempMin1;
				  temp1[i-1] = A[i]+A[i-1];
				  temp2[i-1] = 2;
			  }
			  
		  }
		  int minimal = Integer.MAX_VALUE;
		  int result = 0;
		  for(int i  = 0; i<size; i++){
			  int temp = temp1[i]/temp2[i];
			  if(temp<minimal){
				  minimal = temp;
				  result = i;
			  }
		  }
		 	
		  return result;
	    }
	 
	    public int solution8(String S) {
	        // write your code in Java SE 8
	    	Stack <Character> st = new Stack<Character>();
	    	int size = S.length();
	    	if(size == 0) return 1;
	    	if(size%2 != 0) return 0;
	    	char ch = st.push(S.charAt(0));
	    	if(ch==')') return 0;
	    	int sizeLeft = size;
	    	for(int i = 1; i<size; i++){
	    		if(S.charAt(i)==')'&&!st.empty()) {
	    			st.pop(); 
	    			sizeLeft -= 2;
	    		}
	    		else if(S.charAt(i)=='(') st.push(S.charAt(i));
	    		if(st.size()>sizeLeft/2) return 0;	    		
	    		
	    	}
	    	
	    	if(st.empty())  return  1;
	    	else return 0;
	    
		 
	    }
	    
	    
	    public int solution8(int N) {
	        // write your code in Java SE 8
	    	int result = 0;
	    	int end = N;
	    	int M;
	    	for(int i = 1; i<=end; i++ ){
	    		if(N%i==0) {
	    			M = N/i;
	    			end = M-1 ;
	    			if(M==i) result+=1;
	    			else result+=2;
	    		}
    			if(i*i>N) break;	    		
	    	}
	    	
	    	return result;
	    	
	    }
	    boolean[] peaks;	    
	    public int solution9(int[] A) {
	        // write your code in Java SE 8
	    	int size = A.length;
	    	if(size == 1) return 0;
	    	
	    	peaks = new boolean[size];
	    	
	    	for(int i = 1; i<size-1; i++){
	    		if(A[i]>A[i-1]&&A[i]>A[i+1]){
	    			peaks[i] = true;
	    		}else peaks[i] = false;
	    	}
	    	
	    	int low = 0;
	    	int high = size-1;
	    	int mid = ((high-low)+1)/2;
	    	int result = 0;
	    	while(!(mid>high||mid<low)){
	    		 if(check(mid)) {
	    			 result = mid;
	    			 low = mid+1;
	    			 mid = ((high-low)+1)/2;
	    		 }else if (!check(mid)) {
	    			 high = mid-1;
	    			 mid = ((high-low)+1)/2;
	    		 }
	    	}
	    	
	    	    	
	    	return result;
	    	
	    }
	    
	    public boolean check(int count){
	    	
	    	int pos = 0;
	    	for(int i = 0; i<peaks.length; i++){
	    		if(peaks[i]==true&&count>0){
	    			count--;
	    			pos += count;
	    		}
	    	}
	    	
	    	return count==0;
	    	
	    }
	    	    
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	    	int size = A.length;
	    	if(size==1) return Math.abs(A[0]*2);
	    	Arrays.sort(A);	    		    	 
	    	int boundary = binarySearch(0, A); 
	    	if(boundary == -1) return Math.abs(A[size-1]*2);
	    	if(boundary == 0)  return Math.abs(A[0]*2);
	    	
	    	int [] positive = new int[size-boundary];
	    	int [] negtive = new int[boundary];
	    	int [] result = new int[positive.length];
	    	for(int i = 0; i< boundary; i++){
	    		negtive[i] = A[i];
	    	}
	    	for(int i = 0; i< size-boundary; i++){
	    		positive[i] = A[i+boundary];
	    	}
	    	for(int i = 0; i<positive.length;i++){
	    		result[i] = newbinarySearch(positive[i], negtive);
	    		
	    	}
	    	
	    	int minAbs = Integer.MAX_VALUE;
	    	
	    	for(int i =0; i<result.length; i++){
	    		if(minAbs>result[i]) minAbs = result[i];
	    		
	    	}
	    	
	         return minAbs;
	    	
	    }
	    
	    public int binarySearch(int key, int[]A) {
             int low = 0;
             int high = A.length - 1;
             int indice = -1;
              
             while(high >= low) {
                 int middle = (low + high) / 2;
                 
                 if(A[middle] < key) {
                     low = middle + 1;
                 }
                 if(A[middle] >= key) {
                	 indice = middle;
                     high = middle - 1;
                 }
            }
            return indice;
	    }
	    
	    public int newbinarySearch(int pos, int[]A) {
            int low = 0;
            int high = A.length - 1;
            int result1 = 0;
            int result2 = 0;
            int indice1=-1;
            int indice2=-1;
            int indice = -1;
            int result = -1;
            while(high >= low) {
                int middle = (low + high) / 2;
                
                if((pos+A[middle]) < 0) {
                	result2 = pos+A[middle];
                	indice2 = middle;
                    low = middle + 1;
                    System.out.println(result2);
                    System.out.println(indice2);
                }
                if((pos+A[middle])  >= 0) {
               	    result1 = pos+A[middle];
                	indice1 = middle;
                    high = middle - 1;
                    System.out.println(result1);
                    System.out.println(indice1);
                }
           }
            
           if(indice1!=-1&&indice2!=-1) {
    	   if(Math.abs(result1)>Math.abs(result2))  result = result2;
    	   if(Math.abs(result1)<=Math.abs(result2)) result = result1;
        	   
           }else if(indice1!=-1&&indice2==-1) result = result1;
            else if(indice1==-1&&indice2!=-1) result = result2;
        
           return Math.abs(result);
           
          
	    }
	    
	    
	    public int solution11(int[] A) {
	        // write your code in Java SE 8
	    	int size = A.length;
	    	if(size==2) return A[0]+A[1];
	    	int [] result = new int [size];
	    	for(int i =0;i <size; i++){
	    		result[i] = Integer.MIN_VALUE;
	    	}
	    	result[0] = A[0];
	    	for(int i  = 0; i< size; i++){
	    		for(int j = 1; j<=6; j++){	    			
	    			if(i+j>size-1) break;
	    			if((result[i]+A[i+j]>result[i+j])) result[i+j] = result[i]+A[i+j];
	    		}
	    		
	    	}
	    		    	
	    	return result[size-1];
	    }
	    
	    public int[] solution12(int[] A, int[] B) {
	        // write your code in Java SE 8
	    	int L = A.length;
	    	int[] temp = new int[L+1];
	    	int[] result = new int[L];
	    	temp[L] = 1;
	    	temp[L-1] = 1;
	    	for(int i  = L-2; i>=0; i--){
	    		temp[i] = temp[i+1]+temp[i+2];	 
	    		System.out.println(temp[i]);
	    	}
	    	
	    	for(int i  = 0; i< L; i++){
	   // 		int exp = B[i];
	  //  		result[i] = temp[L-A[i]]%(int)base.pow(exp).intValue();	
	    		result[i] =temp[L-A[i]] & ((1 << B[i]) - 1); 
	    	}
	    	return result;
	    	
	    }
	    
	    public int solution(int K, int M, int[] A) {
	        // write your code in Java SE 8
	    	int size = A.length;
	    	int sum = 0;
	    	int [] indices = new int[K+1];

	    	for(int i = 0; i<size; i++){
	    		sum+= A[i];
	    	}
	    	
	    	for(int i=1; i<=K-1; i++){
	    		
	    		double search = i*sum/K;
	    		indices[i] = amendedBinarySearch(search, A);
	    		
	    	}
	    	int minMaxSum = Integer.MIN_VALUE;
	    	int temp = 0;
	    	indices[0] = -1;
	    	indices[K] = size-1;
	    	for(int j = 0; j<=K-1; j++){
	    		for(int i = indices[j]+1; i<=indices[j+1]; i++){
		    		temp+=A[i];
		    	}
	    		if(minMaxSum<temp) minMaxSum = temp;
	    		temp = 0;
	    	}
	    	
	    	
	    	return minMaxSum;
	    }
	    
	    public int amendedBinarySearch(double key, int[]A) {
            int low = 0;
            int high = A.length - 1;
            int indice = -1;
            int subSum = 0; 
            int temp = 0;
            while(high >= low) {
                int middle = (low + high) / 2;
                subSum = 0;
                for(int i  =0 ;i<=middle; i++){
                	subSum += A[i];
                }
                if(temp!=0&&Math.abs(temp-key)< Math.abs(subSum-key)) break;
                
                temp = subSum;
                if(subSum < key) {
                    indice = middle;
                    low = middle + 1;
                }
                if(subSum >= key) {
               	 	indice = middle;
                    high = middle - 1;
                }
           }
           return indice;
	    }
	    
	    public int solution(int[] A, int[] B, int[] C) {
	        // write your code in Java SE 8
	        
	    		int N = A.length;
		    	int M = C.length;
		    	int min = -1;
		    	if(N == 1){
		    		for(int i =0; i< M; i++){
			    		if(C[i]>=A[0]&&C[i]<=B[0]){		    			
			    			min = 1;
			    			break;
			    		}
			    	}
		    		return min;
		    	}
		    	
		    	int low = 1;
		    	int high = M;
		    	int middle = min;
		    	int count = 0;
		    	int start = 0;
		    	boolean flag = false;
		    	boolean find = false;
		    	while(high>=low){
			    	middle = (low+high)/2;
			    	for(int i = 0; i < M-middle; i++){
				    	start = 0;
				    	count = 0;
				    	flag = false;
				    	find = false;
			    		for(int j = i; j <= i+middle-1; j++){
				    		for(int m = start; m<N; m++){
				    			if(C[j]>=A[m]&&C[j]<=B[m]){
				    				flag = true;
				    				count++;	
				    			}else{
				    				if(flag==true) start = count;
				    				break;		    			
				    			}

				    		}
			    			
			    		}
				    	if(count==N) {
				    	    min = middle;
				    		high = middle-1;
				    		find = true;
				    		break;
				    	}
			    				    		
			    	}
			    	
			    	if(find==false) low = middle+1;		    	
		    		
		    	}
		    	
		    	min = middle;
		    	return min;		    	
		    
	    }
	    
	    
	    public int solution12(int[] A) {  //O(N**2)
	        // write your code in Java SE 8
	    	int size = A.length;
	    	double min = Integer.MAX_VALUE;
	    	int pos = -1;
	    	if(size==2) return 0;
	    	
	    	double[] minSet = new double[size];
	    	int[] preSum = new int[size];
	    	
	    	for(int i = 0; i<size-1; i++){
	    		minSet[i] = (A[i]+A[i+1])/(double)2;
	    		preSum[i] = A[i]+A[i+1];
	    	}
	    	
	    	for(int i = 0; i<size-2; i++){
	    		for(int j = i+2; j<size; j++){
	    			double temp = (preSum[i]+A[j])/(double)(j-i+1);
	    			preSum[i] = preSum[i]+A[j];
	    			if(minSet[i]>temp) minSet[i] = temp;
	    		}	    		
	    	}
	    	
	    	for(int i = 0; i<size-1; i++){
	    		if(min>minSet[i]) {
	    		    min = minSet[i];
	    		    pos = i;
	    		}
	    		    
	    	}
	    	
	    	return pos;
	    	
	    }
	
	    
	    public int solution13(int[] A) {
	        // write your code in Java SE 8
	    	int N = A.length;
	    	if(N==0) return 0;
	    	if(N==1) return 1;
	    	Arrays.sort(A);
	    	
	    	int count = 1;
	    	for(int i = 1; i<N; i++){
	    		if(A[i]!=A[i-1]) count++;
	    		
	    	}
	    	
	    	return count;
	    }
	    
	    public int solution14(int[] A) {
	        // write your code in Java SE 8
	    	int N = A.length;
	    	if(N==0) return 0;
	    	if(N==1) return 1;
	    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	
	    	for(int i = 0; i<N; i++){
	    		map.put(A[i], i);
	    	}	    	
	    	
	    	return map.size();
	    }
	    
	    public int solution15(int[] A) {
	        // write your code in Java SE 8
	    	 	int N = A.length;
		    	if(N < 3) return 0;
		    	Arrays.sort(A);
		    	
		    	int result = 0;
		    	for(int i = N-1; i>=2; i--){
		    		if(A[i]<=0) break;
		    		long sum = (long)A[i-1]+(long)A[i-2];
		    		if(A[i]< sum) {
		    			result = 1;
		    			break;
		    		}
		    		

		    	}	    	
		    	return result;
	    }
	    
	    public int solution16(int[] A) {
	        // write your code in Java SE 8
	    	int N = A.length;
	    	if(N<=1) return 0;
	    	int buy = 0;
	    	int sell = N-1;
	    	for(int i=1, j=N-2; (i<sell||j>buy)&&i<N-1&&j>0; i++,j-- ){
	    		if(A[i] < A[buy]) buy = i;
	    		if(A[j] > A[sell]) sell = j;
	    	}
	    	
	    	int profit = A[sell] -A[buy];
	    	if(profit<=0) return 0;
	    	else return profit;
	    	
	    }
	    public int solution17(int[] A)
	    {
	        int N = A.length;
	        if (N < 1) return 0;

	        int max = 0;
	        int result = 0;

	        for(int i = N-1; i >= 0; --i)
	        {
	            if(A[i] > max)
	                max = A[i];

	            int tmpResult = max - A[i];        
	            if(tmpResult > result)
	                result = tmpResult;
	        }

	        return result;
	    }
	    
	    
	    public int solution18(int[] A) {
	        // write your code in Java SE 8
	    	int N = A.length;
	    	if(N==1) return A[0];
	    	int start = -1;
	    	int max = Integer.MIN_VALUE;
	    	for(int i = 0; i < N; i++){
	    		if(A[i]>0) {
	    			start =i;
	    			break;
	    		}
	    		if(max<A[i]) max = A[i];	    		
	    	}
	    	if(start ==-1) return max;
	    	
	    	int [] result = new int[N];
	    	int sum = 0;
	    	for(int i = start; i<N; i++){
	    		if(sum+A[i]>=0) {
	    			sum +=A[i];	  
	    			result[i] = sum;
	    		}else {
	    			start = i+1;
	    			sum = 0;	    		
	    		}
	    	}
	    	
	    	max = 0;
	    	for(int i = 0; i<N; i++){
	    		if(result[i]>max) max = result[i];
	    	}
	    	
	    	return max;
	    	
	    }
	    
	    public int solution(int K, int[] A) {
	        // write your code in Java SE 8
	    	int N = A.length;
	    	
	    	int count = 0;
	    	int currt = 0;
	    	for(int i = 0; i<N; i++){
	    		if((currt+=A[i])>=K) {
	    			count++;
	    			currt = 0;
	    		}
	    		
	    	}
	    	return count;
	    	
	    }
	    
	    public int solution(int[] A, int[] B) {
	        // write your code in Java SE 8
	    	int N = A.length;
	    	int M = B.length;
	    	if(N!=M||N==0||M==0) return 0;
	    	int count = 1;
	    	int last = 0;
	    	
	    	for(int i = 1; i<N; i++){
	    		if(A[i]>B[last]) {
	    			last = i;
	    			count++;
	    		}
	    	}
	    	
	    	return count;
	    	
	    }
	    
	    public int solution21(int[] A) {
	        // write your code in Java SE 8
	    	int N = A.length;
	    	if(N==0) return 0;
	    	int[] result = new int[N];
	    	for(int i = N-1; i>0; i--){
	    		for(int j= i-1; j>=0; j--){
	    			if(A[j]>A[i]) {
	    				result[i]++;
	    			}
	    		}
	    	}
	    	
	    	int sum = 0;
	    	for(int i = 0; i<N; i++){
	    		sum+=result[i];
	    	}
	    	if(sum>=1000000000) return -1;
	    	else return sum;
	    }
	    
	    public int solution(String S) {
	        // write your code in Java SE 8
	    	int asc1 =  (int)'A';
	    	int asc2 =  (int)'Z';
	    	int asc11 = (int)'a';
	    	int asc12 = (int)'z';
	    	int asc21 = (int)'0';
	    	int asc22 = (int)'9';
	    	
	    	String [] parts = S.split(" ");
	    	int count_number = 0;
	    	int count_alph = 0;
	    	int max = -1;
	    	int len =  -1;
	    	boolean valid = true;
	    	for(int i = 0; i<parts.length; i++){
	    		valid = true;
	    		count_alph = 0;
	    		count_number = 0;
	    		for(int j =0; j<parts[i].length(); j++){
	    			char ch = parts[i].charAt(j);
	    			len = parts[i].length();
	    			if(ch>=asc1&&ch<=asc2||ch>=asc11&&ch<=asc12) count_alph++;
	    			else if(ch>=asc21&&ch<=asc22) count_number++;
	    			else {
	    				valid = false;
	    				break;	    			
	    			}
	    		}
	    		if(valid&&count_alph%2==0&&count_number%2!=0&&max<len) max = len;
	    		
	    	}
	    	 
	    	return max;	    	
	    	
	    }
	    
	    public String solution2(String S) {  //index exchange test
	        // write your code in Java SE 8
	    	  String newS = S.replaceAll("[^0-9]", "");
	    	  int N = newS.length();
	    	  if(N==2||N==3) return newS;
	    	  int number_of_insert = 0;
	    	  if(N%3==0) number_of_insert = N/3-1;
	    	  if(N%3!= 0) number_of_insert = N/3;
	    	  
	    	  int start = 0;
	    	  int last_position = 0;
	    	  List<Character> list = new ArrayList<Character>();
	    	  for(int i = 1; i<= number_of_insert; i++){
	    		 int count = 0;
	    		 for(int j = start; j<N; j++){
	    			 list.add(newS.charAt(j));
	    			 count++;
	    			 if(N%3==1&&i==number_of_insert){
	    				 if(count==2){
	    					list.add('-'); 
	    				 }
	    				 
	    			 }else{
	    				 if(count==3){
			    			 list.add('-');
			    			 start = j+1 ;
			    			 break;
	    				 }
	    			 }
	    			 last_position = j+1;
	    				     			 
	    		 }	    		 
	    	  }
	    	  
	    	  for(int i = last_position+1; i<N; i++){
	    		  list.add(newS.charAt(i));
	    	  } 
	    	  
	    	  StringBuilder builder = new StringBuilder(list.size());
	    	    for(Character ch: list)
	    	    {
	    	        builder.append(ch);
	    	    }
	    	return builder.toString();
	    	  
	    	
	    }
	    
	    public int solution3(int X, int[] A) { //frogriver
	        // write your code in Java SE 8
	        int N = A.length;
	        if(N==1&&A[0]==1) return 0;
	        if(N==1&&A[0]!=1) return -1;
	        boolean [] covered = new boolean[X+1];
	        for(int i = 1; i<=X; i++){
	            covered[i] = false;
	        }
	        
	        int count  = 0;
	        int result = -1;
	        for(int i=0; i<N; i++){
	            
	            if(covered[A[i]]==false){
	                count++;
	                covered[A[i]] = true;
	            }
	            if(count==X) {
	                result = i; 
	                break;
	            }
	        }
	        
	        return result;
	    }
	    public int solution2(int A, int B, int K) { //CountDiv
	        // write your code in Java SE 8
	        if(A>B) return 0;
	        if(A==B&&A%K==0) return 1;
	        if(A==B&&A%K!=0) return 0;
	        
	        if(A%K==0) return (B-A)/K+1;
	        if(A%K!=0) {
	            if(B>= (K-A%K)+A) return (B-(K-A%K+A))/K+1;
	            else return 0;
	        }
	        
	        return -1;
	    }
	    
	    public int solution5(int[] A) { //maxtriple
	        // write your code in Java SE 8
	        int N = A.length;
	        if(N==3) return A[0]*A[1]*A[2];
	        Arrays.sort(A);
	        if(A[0]>=0||A[N-1]<=0)  return A[N-1]*A[N-2]*A[N-3];
	        if(A[N-1]>0&&A[N-2]<=0) return A[N-1]*A[0]*A[1];
	        if(A[N-2]>0&&A[N-3]<=0) return A[N-1]*A[0]*A[1];
	        if(A[N-3]>0) return Math.max(A[N-1]*A[N-2]*A[N-3], A[N-1]*A[0]*A[1]);
	        
	        return 0;
	    }
	    
	    public int solution(int N) { //count factor
	        // write your code in Java SE 8
	        if(N==1) return 1;
	        int count  = 2; 
	        int start = 2;
	        int end = N/2;
	        for(int i =start; i<=end; i++){
	            if(N%i==0) {  
	                if(i==N/i) count+=1;
	                else count+=2;
	                start = i+1;
	                end = N/i-1;
	            }else{
	                start = i+1;
	                end = N/i-1;
	            }
	            
	        }
	        
	        return count;
	    }
	    public int solution3(String S) {
	        // write your code in Java SE 8
	        int N = S.length();
	        if(N==0) return 1;
	        if(N%2!=0) return 0;
	        if(S.charAt(0)=='}'||S.charAt(0)==']'||S.charAt(0)==')') return 0;
	           
	        Stack<Character> st = new Stack<Character>();
	        st.push(S.charAt(0));
	        for(int i =1; i<N; i++){
	            if(S.charAt(i)=='{'||S.charAt(i)=='['||S.charAt(i)=='(') st.push(S.charAt(i));
	            else if(S.charAt(i)=='}'&&!st.empty()&&st.peek()=='{') st.pop();
	            else if(S.charAt(i)==']'&&!st.empty()&&st.peek()=='[') st.pop();
	            else if(S.charAt(i)==')'&&!st.empty()&&st.peek()=='(') st.pop();
	            else return 0;
	   
	        }
	        
	        if(st.size()==0) return 1;
	        else return 0;
	    }
	    public static void main(String args[]) {
	    	FrogImp FI = new FrogImp();
	    	System.out.println(FI.solution2("1234567891"));
	    }
	    
	    
}
