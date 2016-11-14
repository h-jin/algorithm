package algorithm;
import java.io.*;
import java.util.*;

import javax.swing.*;


public class DFS_J{
	
	public static ArrayList<ArrayList<Integer>> matrix;
	public static int source;
    public ArrayList<String> path_info = new ArrayList<String>();


	public static ArrayList<ArrayList<Integer>> read_matrix(String filename){
		  
		BufferedReader br = null;
	    matrix = new ArrayList<ArrayList<Integer>>();

		try {
 
				String sCurrentLine;
					 
				br = new BufferedReader(new FileReader(filename));
	 
				while ((sCurrentLine = br.readLine()) != null) {
					
					String[] str = sCurrentLine.split(" ");
					ArrayList<Integer> edge = new ArrayList<Integer>();;
					for(int i = 0; i < str.length; i++){
						
						edge.add(Integer.parseInt(str[i]));
					}
					matrix.add(edge);

				}
				
				br.close();
 
		} catch (IOException e) {
			
				e.printStackTrace();
		} 
		return matrix;
		
	}
	
	public static int read_source(String filename){
		  
		BufferedReader br = null;
		try {
 
				String sCurrentLine;
				String[] str = {};
				int count = -1; 
				br = new BufferedReader(new FileReader(filename));
	 
				while ((sCurrentLine = br.readLine()) != null) {
					count++;
					if(count == 1){
						
						str = sCurrentLine.split(" ");

					}
				

				}
				source = Integer.parseInt(str[0]);
				
				br.close();
 
		} catch (IOException e) {
			
				e.printStackTrace();
		} 
		
		return source;
	}
	
	public static String get_path(int requested_line_number, String filename){
		  
		BufferedReader br = null;
		String find="";
		String[] str;
		try {
 
				String sCurrentLine;
				int count = -1; 
				br = new BufferedReader(new FileReader(filename));
	 
				while ((sCurrentLine = br.readLine()) != null) {
					count++;
					if(count == requested_line_number){
						
						find = sCurrentLine;
						str = find.split(" ");
						find = "(City: " + str[1] + ", Pop: " + str[2] + ", Elevation: " + str[3] + ")";
						System.out.println(find);

					}
				
				}
				
				br.close();
 
		} catch (IOException e) {
			
				e.printStackTrace();
		} 
		
		return find;
	}
	
	public ArrayList<String>  DFS(String adjacent, String source_node, String nodes_info){
		
		read_matrix(adjacent);
		read_source(source_node);
		
		Stack<Integer> nodes = new Stack();
		Queue<Integer> path = new LinkedList<Integer>();
		
		int start = source;
		nodes.push(start);
		int size =matrix.size();
		int[] flag = new int[size];
		int number;
		
		for(int i =0; i<size; i++){
			
			flag[i] = 0;
		}
		
		while(!nodes.isEmpty()){
			
			number = nodes.pop()-1;
			if(flag[number]==0){
				flag[number] = 1;
				path.offer(number+1);
				for(int i = 0; i< matrix.size(); i++){
					
					if(matrix.get(number).get(i)==1){
						
						nodes.push(i+1);
					}
				}
				
			}
			
			
		}
	

		while(!path.isEmpty()){
	
			path_info.add(get_path(path.poll(), nodes_info));

			
		}		
		
		return path_info;
		
		
	}
	
	public static void main(String[] args) {
		DFS_J bfs = new DFS_J();

	//	System.out.println(bfs.DFS("AdjacencyMatrix_of_Graph_G.txt","SourceNode_StoppingCondition.txt","Node_Information_of_Graph_G.txt").size());
				
	}

}
