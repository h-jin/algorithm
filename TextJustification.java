package algorithm;
import java.util.*;

public class TextJustification {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		
		List<String> text = new ArrayList<String>();
		if(maxWidth==0) {
			text.add("");
			return text;
		
		}
		int count=0;
		int line_words=0;
		int pad;
		int one_word=0;
		int remainder=0;
		int result=0;
		Queue<String> queue = new LinkedList<String>();
		if(words.length==0) return text;
		for(int i = 0; i<words.length; i++){
				if(queue.size()>=1)
					one_word = words[i].length()+1;
				else one_word = words[i].length();
				line_words +=one_word;
				if(line_words<=maxWidth &&i< words.length-1){
					queue.add(words[i]);
									
				}else if(line_words<=maxWidth&&i== words.length-1){
					queue.add(words[i]);
					String str = "";
					int size = queue.size();
					for(int j = 0; j<size; j++){
						str += queue.poll();
						if(queue.size()>=1){
							str = str+" ";
						}									
					}
					pad = maxWidth-line_words;
					for(int m = 0; m<pad; m++){
						str = str+" ";
					}
					text.add(str);	
					
				}else if(line_words>maxWidth){	
					count = queue.size(); 
				
					line_words = line_words-words[i].length()-1; // delete last added word
					
					pad = maxWidth-line_words;
					if(count>1){
						result = pad/(count-1); 
						remainder = pad%(count-1);
					}
					String str = "";
					int size = queue.size();
					if(size==1){
						str = queue.poll();
						for(int m = 0; m<pad; m++){
							str = str+" ";
						}
						
					}else{
						
						for(int j = 0; j<size; j++){
							str += queue.poll();
							if(queue.size()>=1){
								str = str+" ";
								
								for(int m  = 0; m<result; m++){
									str = str +" ";
								}
							}
							
							if(remainder!=0&&j<=remainder-1) str = str+" ";
							
							
						}
						
					}
					
					if(!str.equals("")) text.add(str);						
					line_words = 0;
					queue.clear();
					if(words[i].length()==maxWidth) {
						text.add(words[i]);
					}else {
						i = i-1;
					}

				}					
			
			}
			
			
				
		return text;
        
    }
	
	 public static void main(String args[]) {
		 
		 TextJustification tj = new TextJustification();
		 
	
		 String[] words = {"This", "is", "an", "example", "of","text","justification."};
	//	 String[] words = {"a","b","c","d","e"};
				 
		 int maxWidth = 16;
		 List<String> text = new ArrayList<String>();
		 text  = tj.fullJustify(words, maxWidth);
		 for(int i = 0; i<text.size(); i++){
			 System.out.println(text.get(i));
			 System.out.println(text.get(i).length());
		 }
	 }

}
