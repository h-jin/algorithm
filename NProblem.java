package algorithm;
import java.util.Scanner;


public class NProblem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int i = sc.nextInt();
		int j = sc.nextInt();
		sc.close();
		int cycle_length=cycle(i);
		int record = 0;
		for(int k=i+1;k<=j;k++){
			if(cycle_length<cycle(k)){
				cycle_length=cycle(k);
				record = k;
			}
		}
		System.out.println(cycle_length);
		System.out.println(record);
	
	
	}
	static public int cycle(int n){
		
		boolean flag = true;
		int count = 1;
	
		while(flag){			
		
			if(n==1){
				flag =false;
								
			}else if (n%2!=0){
									
					n = 3*n+1;
					count++;
				
			}else if (n%2==0){
							
					n = n/2;
					count++;
				
			}
		}
		return count;
	}
	
	static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	 //     int pivot = arr.get(arr.size()));
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	static public void quickSort(int arr[], int left, int right){
		
		int index = partition(arr, left, right);
	      if (left < index - 1){
	            quickSort(arr, left, index - 1);
	      }
	      if (index < right){
	            quickSort(arr, index, right);
	      }
	      
		
	}

}
