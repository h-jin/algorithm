package algorithm;
import java.lang.StringBuffer;

public class LongestPalindromic {
	int max=0;
	int start=0;
	int end=0;
	
	public String longestPalindrome(String s) {
		if(s==null) return null;
		int length = s.length();
		if(length<=1) return s;
		
		int middle= (length+1)/2-1;
		int left = middle;
		int right;
		if(length%2==0){
			right = middle +1;
		}else{
			right = middle;
		}
		
		for(int i=middle; i>=max/2; i--,left--,right++){
			
			maxLength(s,left,left);
			maxLength(s,left-1,left);
			maxLength(s,right,right);
			maxLength(s,right-1,right);	

		}
		return s.substring(start,end+1);
		
	}
	public void maxLength(String s, int left, int right){
		
		if(left<0||s.charAt(left)!=s.charAt(right)){
			return;
			
		}
		while(left-1>=0&&right+1<s.length()&&s.charAt(left-1)==s.charAt(right+1)){
			left--;
			right++;
			
		}
		if(right-left+1>max){
			max = right-left+1;
			start=left;
			end= right;
			
		}
		
	}
	
/*	public String longestPalindrome(String s) {
		StringBuffer sb = new StringBuffer(s);
		String reverse = sb.reverse().toString();
		return longestSubstring(s, reverse);
	}
/*	
	public String longestPalindrome(String s) {
		
		
		String[] result_single = new String[s.length()];
		String[] result_double = new String[s.length()];
		String max1 ="";
		String max2 ="";
		
		int end1 = 0;
		int end2 = 0;
		int special = -1;
			
		
		if(s.length() <= 2){
			return s;
		}else {
			
			//single center
			for(int i = 0; i<s.length();i++){
				result_single[i]=Character.toString(s.charAt(i));
			}
			
			for(int i = 1; i<s.length()-1;i++){
				
				end1 = i-1;	
				end2 = i+1;
				while(end1>=0 && end2<s.length()){
					if(s.charAt(end1)==s.charAt(end2)){
						result_single[i] = s.charAt(end1)+ result_single[i]+s.charAt(end2);	
						end1--;
						end2++;
					}else{
						break;
					}
									
				}
				
				
				if(result_single[i].length()==s.length()) {
					special = i;
					break;
				}
			}
			if(special!=-1){
				return result_single[special];
			}
			
			max1 = result_single[0];
			for(int i =1; i<result_single.length;i++){

				if(result_single[i].length()>max1.length()){
					max1 = result_single[i];
				}
			}
			
			
			//double center
			
			
			for(int i = 0; i<s.length()-1;i++){
				int j = i+1;
				if(s.charAt(i)==s.charAt(j)){
					result_double[i]=Character.toString(s.charAt(i)) + Character.toString(s.charAt(j));	
				}

			}
			
			for(int i = 1; i<s.length()-2;i++){
				end1 = i-1;	
				end2 = i+2;
				while(end1>=0 && end2<s.length()){
					if(result_double[i]!=null&&s.charAt(end1)==s.charAt(end2)){
						result_double[i] = s.charAt(end1)+ result_double[i]+s.charAt(end2);	
						end1--;
						end2++;
					}else{
						break;
					}
									
				}
				

				if(result_double[i]!=null&&result_double[i].length()==s.length()) {
					special = i;
					break;
				}
				
				
			}
			if(special!=-1){
				return result_double[special];
			}
			
			max2 = "";
			for(int i =0; i<result_double.length;i++){
				if(result_double[i]!=null&&result_double[i].length()>max2.length()){
					max2 = result_double[i];

				}
			} 
			
		}
		
		
		
		
		if(max1.length()>max2.length()){
			return max1;
		}else{
			return max2;
		}		
				
    }
	*/
	
	
	
/*	public String longestSubstring(String one, String two){
		
		String[] result = new String[one.length()];
		for(int i = 0; i<one.length();i++){
			result[i]="";
		}
		String max="";
		String temp;
		int count =0;
		int start1=0, end1=0, start2=0, end2=0;
		
		while(count<one.length()){
			temp="";
			start1= count;
			end1=count;
			start2=0;
			end2=0;
			
			
			
			while(end1<one.length()&&end2<two.length()){
				
				if(one.charAt(end1)==two.charAt(end2)){
					temp += Character.toString(one.charAt(end1));
					
					if(end1==one.length()-1||end2==two.length()-1){
					
										
						if(temp.length()>result[start1].length()){
							result[start1]=temp;	
							
						}
					}
					
					end1++;
					end2++;
									
				}else if (one.charAt(end1)!=two.charAt(end2)){
				
					if(temp.length()>result[start1].length()){
						result[start1]=temp;
						
					}
					temp="";
					start1=count;
					end1=count;
					start2++;
					end2 = start2;
				}
				
				
			}		
			count++;
			if(result[start1].length()==one.length()){
				return result[start1];
			}
		
		
		}
	
		
		max = "";
		for(int i = 0; i<result.length;i++){
			StringBuffer sb = new StringBuffer(result[i]);
			if(result[i].length()>max.length()&&result[i].equalsIgnoreCase(sb.reverse().toString())){
				max = result[i];
			}
		}
		
		return max;
	}   */
	
	
	public static void main(String args[]) {
		LongestPalindromic  lp = new LongestPalindromic();
	//	lp.longestPalindrome("aba");
		
		System.out.println(lp.longestPalindrome("esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq"));
	
	//	System.out.println(lp.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	//	System.out.println(lp.longestPalindrome("abb"));
	}
	
}
