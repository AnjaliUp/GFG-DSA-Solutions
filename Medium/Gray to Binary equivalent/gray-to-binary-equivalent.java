//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static int grayToBinary(int n) {
        /* Convert number to binary */
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        sb.append(binary.charAt(0));
        for(int i=0;i<binary.length()-1;i++)sb.append((sb.charAt(i)==binary.charAt(i+1))?'0':'1');
        /* Convert binary to number */
        return Integer.parseInt(sb.toString(),2);
    }
}





//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends