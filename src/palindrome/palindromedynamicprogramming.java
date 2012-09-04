package palindrome;
import java.util.Scanner;
public class palindromedynamicprogramming {

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        // TODO code application logic here
	        System.out.println("Input: ");
	        Scanner scanner = new Scanner(System.in);
	        String string = scanner.nextLine();
	        System.out.println("Length: " + string.length());
	        
	        System.out.println(palindrome2(string));
	    }
	/**
	 * Using recurive method to solve the problem
	 * Normally the string length < 30
	 * @deprecated 
	 * @param s
	 * @return 
	 */
	    public static String palindrome(String s) {

	        if (s.length() <= 1) {
	            return s;//phan neo
	        } else {
	            if (s.charAt(0) == s.charAt(s.length() - 1)) {//start equal last
	                return s.charAt(0) + palindrome(s.substring(1, s.length() - 1)) + s.charAt(0);//phan neo
	            } else {
	                String s1 = s.substring(1);//get sub string from second char to end
	             
	                String s2 = s.substring(0, s.length() - 2);//get substring from begin to char before end
	 
	                if (palindrome(s1).length() > palindrome(s2).length()) {//get palindrome of longer chars
	                    return palindrome(s1);
	                } else {
	                    return palindrome(s2);
	                }
	            }
	        }
	    }
	/**
	 * Using dynamic programming to solve the problem
	 * @param s input string
	 * @return the longest palindrome subsequence
	 */
	    
	    public static String palindrome2(String s) {
	    	
	        String[][] res = new String[s.length()][s.length()];
	        int j;
	        for (int i = 0; i < s.length(); i++) {
	            res[i][i] = s.charAt(i) + "";
		  
	        }
	        

	        for (int offset = 1; offset < s.length(); offset++) {
	            for (int i = 0; i < s.length() - offset; i++) {
	                j = i + offset;
	                
	                if (s.charAt(i) == s.charAt(j)) {
	                    res[i][j] = s.charAt(i) + res[i + 1][j - 1] + s.charAt(j);
	                } else {
	                    if (res[i][j - 1].length() > res[i + 1][j].length()) {
	                        res[i][j] = res[i][j - 1];
	                    } else {
	                        res[i][j] = res[i + 1][j];
	                    }
	                }
	            }
//	            System.out.println("\nNEW:");
//	            for (int ii = 0; ii < s.length(); ii++) {
//	                for (int jj = 0; jj < s.length(); jj++) {
//	                    System.out.print(res[ii][jj]+"\t"); // elem = array[j];
//	                }
//	                System.out.println();
//	            }
	        }
	        return res[0][s.length() - 1];
	    }
	}
