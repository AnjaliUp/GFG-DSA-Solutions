//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    static int f(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        
        if (i < 0 || j < 0) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int left = f(i - 1, j, dp) % 1_000_000_007;
        int up = f(i, j - 1, dp) % 1_000_000_007;
        
        return dp[i][j] = (left + up) % 1_000_000_007;
    }
    
    public static int ways(int x, int y) {
        int[][] dp = new int[x + 1][y + 1];
        
        for (int[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        return f(x, y, dp);
    }
}





















//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends