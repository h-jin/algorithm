package algorithm;
import java.util.*;

public class SubstringConcatenation {

	 public  List<Integer> findSubstring(String s, String[] words) {
		 
		 List<Integer> indices = new ArrayList<Integer>();
		 HashMap<String, Integer> hm = new HashMap<String, Integer>();
		 HashMap<String, Integer> curhm = new HashMap<String, Integer>();
		 
		 
		 int eachLen = words[0].length();
		 int numbers = words.length;		 
		 int totalLen = eachLen*numbers;

		 if(s.length()<totalLen) return indices;
	     
		 int sumAscii = 0;
		 for(int i = 0; i<numbers; i++){
			 for(int j = 0; j<eachLen;j++){
				 
				 sumAscii += (int)words[i].charAt(j);
			
			 }			 
		 }
		 
		 
		 int tempAscii = 0;
		 List<Integer> tempStart = new ArrayList<Integer>();
		 int start = 0;
		 int end = totalLen-1;
		 for(int i = 0; i<totalLen; i++){
			 tempAscii += s.charAt(i);
		 }

		 if(tempAscii == sumAscii){tempStart.add(0);}  
		 
		 for(start = 1; start <= s.length()-totalLen;start++,end++){  //candidate start
			 tempAscii = tempAscii + (int)s.charAt(end+1)-(int)s.charAt(start-1);
			 if(tempAscii == sumAscii){tempStart.add(start); }
		 } 
		 
		 for(String word: words) {
			 hm.put(word,hm.getOrDefault(word, 0)+1);
		 }
		 String key= "";
		
		 for(int i = 0; i<tempStart.size();i++){
			 boolean indicator = false; //indicate whether all words in string are in words
			 int flag = -1;
			 curhm.clear();
			 
			 for(int j = 0; j<numbers; j++){
				 
				 start = tempStart.get(i)+j*eachLen;
				 end = start+eachLen;
				 key = s.substring(start, end);
				 
				 if(!hm.containsKey(key)) {
					 break;
				 
				 } else if(hm.containsKey(key)) {
					 curhm.put(key,curhm.getOrDefault(key, 0)+1);
					 if(curhm.get(key)<hm.get(key)){
						 flag = -1;
					 }else if(curhm.get(key)==hm.get(key)) {
						 flag = 0;
					 }else if(curhm.get(key)>hm.get(key)){
						 flag = 1;
						 break; 
					 }
				 }
			 } 
			 if(curhm.size() == hm.size()) indicator = true;
			
			if(indicator&&flag==0) {
				indices.add(tempStart.get(i)); 
				
			}
		 } 
		 
		 return indices;
	 }
		 
		 
		 
		 public static void main(String args[]) {
			 
			 SubstringConcatenation  sc = new SubstringConcatenation();
		
		//	 String s = "wordgoodgoodgoodbestword";
		//	 String[] words = {"word","good","best","good"};
		//	 String s = "barfoofoobarthefoobarman";
		//	 String[] words={"bar","foo","the"};
		//	 String s=	 "barfoothefoobarman";
		//	 String[] words=	{"foo","bar"};
			 String s = "acaccacbb";
			 String[] words = {"ac","ca","ac"};
		//	 String[] words = {"ab","ba","ab","ba"};
		//	 String s = "abaababbaba";
			 
		//	 String[] words = {"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};
		/*	 String s = "abababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababa"
			 		+ "babababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "babababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "babababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "bababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "babababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "bababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "bababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "bababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"
			 		+ "bababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"
			 		+ "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
		 */
			 int size = sc.findSubstring(s, words).size();
			 for(int i =0; i<size; i++){
				 System.out.println(sc.findSubstring(s, words).get(i)); 
			 }
		 }
}
