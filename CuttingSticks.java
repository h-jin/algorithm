package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CuttingSticks {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int posi_number = sc.nextInt();
		List<Integer> position = new ArrayList<Integer>();
		position.add(0);
		
		int point;
		for(int i =0;i<posi_number;i++){
			
			point = sc.nextInt();
			position.add(point);
			
		}
		sc.close();
		position.add(l);
		int[][] cost = new int[position.size()][position.size()];

		for(int i =0;i<position.size()-1;i++){
			cost[i][i+1]= 0;
		}
		for(int i =0;i<position.size();i++){
			cost[i][i]= 0;
		}
		int min = -1;
		for(int i = 2;i<=position.size()-1;i++){
			
			for(int j = 0;j<position.size()-i;j++){
				boolean lower = true;	
				int part = position.get(i+j)-position.get(j);
				for(int k = j+1; k<i+j;k++){
					
				//	cost[i][j] = cost[k-j][j] + cost[i-k][j] + position.get(i+j)-position.get(j);	
				//	cost[j][i+j] = cost[j][k] + cost[k][i+j] + position.get(i+j)-position.get(j);					
					int opt = cost[j][k] + cost[k][i+j] /*+ position.get(i+j)-position.get(j) */;
					if(lower){
						min = opt;
						lower = false;
					}else{
						if(opt<min){
						min = opt;
						}
					}
				}
				cost[j][i+j] = min + part;
			}

		}
		
	/*	for(int i =0;i<position.size();i++){
			for(int j =0;j<position.size();j++){
				System.out.println(cost[i][j]);
			}
		} */
		
		System.out.println(cost[0][position.size()-1]);
	    
				
	}	

	static public int cut_cost(int lenth, List<Integer> p){
		int cost=0;
		int part=0;
		int temp =0;
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();

		p1 = p;
		p2 = p;
		if(p.size()==1){
			cost = lenth;
		}else if (p.size()==2){
			
			cost = lenth + Math.min((lenth-p.get(0)),p.get(1));
		}else{
			 int l = lenth;
			 int part_l=p.get(0);
			 temp = lenth + cut_cost((l-part_l),p2.subList(1, p2.size()));
			 
 			 for(int i =1; i<p.size();i++){
 				 
				part = p.get(i);				
			    cost= lenth + cut_cost(part,p1.subList(1, i))+ cut_cost((lenth-part),p1.subList(i+1, p1.size()));
			    if(temp < cost){
			    	cost = temp;
			    }
			    p1=p;
			  //  p2=p;
											
			}
		}
		
		return cost;
	}
}
