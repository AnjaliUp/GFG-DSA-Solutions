//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        String arr[] = sentence.split(" ");
        long ans  = -1;
        for(String str : arr){
            char c = str.charAt(0);
            if(isNum(c) && !str.contains("9")){
                long num = Long.parseLong(str);
                ans = Math.max(num,ans);
            }
            
            
        }
        return ans;
    }
    
    boolean isNum(char c){
        return c>='0' && c<='9';
    }
}