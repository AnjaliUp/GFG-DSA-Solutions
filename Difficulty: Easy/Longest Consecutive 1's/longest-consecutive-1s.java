//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        
        // Convert the number to its binary representation
        String b = Integer.toBinaryString(N);
        
        int maxi = 0, count = 0;
        
        // Loop through the binary string
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) == '1'){
                count++;
                 maxi = Math.max(maxi, count);
            } else {
               
                count = 0;
            }
        }
        
        // After the loop, check if the last sequence was the longest
        // maxi = Math.max(maxi, count);
        
        return maxi;
        
    }
}



//{ Driver Code Starts.

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}



// } Driver Code Ends