package algorithm;
import java.util.ArrayList;
import java.util.Scanner;


public class BFS {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int s = sc.nextInt(); // start point
		int d = sc.nextInt(); // destination
		float edg[][] = new float[v+1][v+1]; // length
		float temp[][] = new float[v+1][v+1]; // temperature
		float max[] = new float[v+1];
		int pre[] = new int [v+1]; //preprocessor
		
		ArrayList<Integer> queue = new ArrayList<Integer>();
		for (int i = 0; i<e; i++){
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			float tem = sc.nextFloat();
			float len = sc.nextFloat();
			edg[x][y] = len;
			temp[x][y] = tem;								
		}
		
		
		enqueue(queue,s);
		pre[s] =0;
		
		while(queue.size()!=0){
			int elem = dequeue(queue);
			for(int i = 1; i<v+1; i++){
				if(temp[elem][i]!=0&&elem!=i){
			
						if(Float.compare(max[i],0.0f)==0){
							pre[i] = elem;
					
							if(Float.compare(max[elem],temp[elem][i])>0){
								max[i] = max[elem];
							}else{
								max[i] = temp[elem][i];
							}
						
							enqueue(queue,i);
								
						}else if (Float.compare(max[i],0.0f)!=0){
						
							if(Float.compare(max[elem],temp[elem][i])>0){
								if(Float.compare(max[i],max[elem])>0){
									max[i] = max[elem];
									enqueue(queue,i);
									pre[i] = elem;
								}
							}else if (Float.compare(max[elem],temp[elem][i])<=0){
								if(Float.compare(max[i],temp[elem][i])>0){
									max[i] = temp[elem][i];
									enqueue(queue,i);
									pre[i] = elem;
								}
							}
							
						
						}
						
					
				}
			}
			for(int j = 1; j<v+1; j++){
				if(temp[j][elem]!=0&&elem!=j){
						
						if(Float.compare(max[j],0.0f)==0){
							pre[j] = elem;
							if(Float.compare(max[elem],temp[j][elem])>0){
								max[j] = max[elem];
							}else{
								max[j] = temp[j][elem];
							}
							
							enqueue(queue,j);
	
						}else if (Float.compare(max[j],0.0f)!=0){
											
							if(Float.compare(max[elem],temp[j][elem])>0){
								if(Float.compare(max[j],max[elem])>0){
									max[j] = max[elem];
									enqueue(queue,j);
									pre[j] = elem;
								}
							}else if (Float.compare(max[elem],temp[j][elem])<=0){
								if(Float.compare(max[j],temp[j][elem])>0){
									max[j] = temp[j][elem];
									enqueue(queue,j);
									pre[j] = elem;
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
			System.out.println();
			int des = d;
			int leng = 0;
			while(des!=s){
				if(edg[pre[des]][des]!=0){
					leng += edg[pre[des]][des];
				}else {
					leng += edg[des][pre[des]];
				}
				des = pre[des];
			}
			System.out.println(leng+" "+max[d]);  
			
			long end = System.currentTimeMillis();
			
			System.out.println(end-start);

							
		
	}
	public static int dequeue(ArrayList<Integer> p){
		
		int element;
		element = p.get(0);
		p.remove(0);
		return element;
	
	}
	public static ArrayList<Integer> enqueue(ArrayList<Integer> p, int e){
		
		p.add(e);
		return p;
	
	}

}
