package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bellman {
	
		
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int s = sc.nextInt(); // start point
		int d = sc.nextInt(); // destination
		float max[] = new float[v+1];
		float length[] = new float[v+1]; //path
		int pre[]= new int [v+1]; //predecessor
		List<Object> edgs = new ArrayList <Object>();
		
			for (int i = 0; i<e; i++){
				
				int x = sc.nextInt();
				int y = sc.nextInt();
				float tem = sc.nextFloat();
				float len = sc.nextFloat();
				edgs.add(x);
				edgs.add(y);
				edgs.add(tem);
				edgs.add(len);
			
			}
			sc.close();
		//	long start = System.currentTimeMillis();
			for(int i = 0; i<v+1; i++){
				
				max[i] = 60.0f;
				length[i] = 500000.0f;
				
			}
			max[s] = 0.0f;
			length[s] = 0.0f;
			pre[s] = s;
			
			for(int i = 1; i<=v-1; i++){
				
				for(int j = 0; j<=edgs.size()-4; j= j+4){
					
					int index1 = (int)edgs.get(j);
					int index2 = (int)edgs.get(j+1);
					if(max[index1]==60.0f&& max[index2]==60.0f){
						;
					}else if(max[index1]!=60.0f&& max[index2]==60.0f){
						if(max[index1]>(float)edgs.get(j+2)){
							max[index2] = max[index1];
						}else if(max[index1]<=(float)edgs.get(j+2)){
							max[index2] = (float)edgs.get(j+2);
						}
						
					}else if(max[index1]==60.0f&& max[index2]!=60.0f){
						if(max[index2]>(float)edgs.get(j+2)){
							max[index1] = max[index2];
						}else if(max[index2]<=(float)edgs.get(j+2)){
							max[index1] = (float)edgs.get(j+2);
						}
						
					}else if(max[index1]!=60.0f&& max[index2]!=60.0f){
						
						if(max[index1]>(float)edgs.get(j+2)){
							if(max[index2] > max[index1]){
								max[index2] = max[index1];
							}
							
						}else if(max[index1]<=(float)edgs.get(j+2)){
							if(max[index2] > (float)edgs.get(j+2)){
								max[index2] =(float)edgs.get(j+2);
							}
							
						}
						if(max[index2]>(float)edgs.get(j+2)){
							if(max[index1] > max[index2]){
								max[index1] = max[index2];
							}
							
						}else if(max[index2]<=(float)edgs.get(j+2)){
							if(max[index1] >(float)edgs.get(j+2)){
								max[index1] = (float)edgs.get(j+2);
							}
							
						}
						
					}
				
																				
				}
				
			} 
			
			for(int i = 1; i<=v-1; i++){
				
				for(int j = 0; j<=edgs.size()-4; j= j+4){
					
					int index1 = (int)edgs.get(j);
					int index2 = (int)edgs.get(j+1);
					
					if((float)edgs.get(j+2)<=max[d]){
						
						if(pre[index1]==0 && pre[index2]==0){
							
							;
						}else if(pre[index1]==0 && pre[index2]!=0){
							
							length[index1] = length[index2]+ (float)edgs.get(j+3);
							pre[index1] = index2;
							
						}else if(pre[index1]!=0 && pre[index2]==0){
							
							length[index2] = length[index1]+ (float)edgs.get(j+3);
							pre[index2] = index1;
	
							
						}else if(pre[index1]!=0 && pre[index2]!=0){
							
							if(length[index1]>length[index2]){
								
								if(length[index1]>length[index2]+(float)edgs.get(j+3)){
									length[index1]=length[index2]+(float)edgs.get(j+3);
									pre[index1] = index2;
	
								}
								if(length[index2]>length[index1]+(float)edgs.get(j+3)){
									length[index2]=length[index1]+(float)edgs.get(j+3);
									pre[index2] = index1;
	
								}
								
							}else if(length[index1]<=length[index2]){
															
								if(length[index2]>length[index1]+(float)edgs.get(j+3)){
									length[index2]=length[index1]+(float)edgs.get(j+3);
									pre[index2] = index1;
	
								}
								if(length[index1]>length[index2]+(float)edgs.get(j+3)){
									length[index1]=length[index2]+(float)edgs.get(j+3);
									pre[index1] = index2;
	
								}
								
							}
												
							
						}
						
					}
																													
				}
				
			} 

		
		int print = d;
		ArrayList <Integer> printlist = new ArrayList <Integer>();
		printlist.add(d);
	    while(print!=s){
	    	
			print = pre[print];
			printlist.add(print);
    	
	    }
		for(int i = printlist.size()-1; i>=0; i--){
			System.out.print(printlist.get(i)+" ");
		
		}  
		
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println(length[d]+" "+max[d]);
		System.out.println(end-start);
			

	}
		

}
