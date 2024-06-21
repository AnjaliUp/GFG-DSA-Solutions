//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        String[] strArray = str.split(", ");
        String[] first = strArray[0].split("/");
        String[] second = strArray[1].split("/");
        int firstNumerator = Integer.parseInt(first[0]);
        int firstDeno = Integer.parseInt(first[1]);
        int secondNumerator = Integer.parseInt(second[0]);
        int secondDeno = Integer.parseInt(second[1]);
        double equ1 = (double)firstNumerator/firstDeno;
        double equ2 = (double)secondNumerator/secondDeno;
        if(equ1>equ2){
            return strArray[0];
        }
        else if(equ1 < equ2){
            return strArray[1];
        }
        else{
            return "equal";
        }
        
    }
}

