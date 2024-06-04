//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        int n = s.length(), zero = 0;
        StringBuilder str = new StringBuilder(s);
        
        for(int i = n - 1; i >= 0; i--) {
            if(str.charAt(i) == '0') {
                str.setCharAt(i, '1');
                zero = 1;
                break;
            } else
                str.setCharAt(i, '0');
        }
        
        if(zero == 0)
            str.insert(0, '1');
            
        int i = 0;
        while(i < str.length() && str.charAt(i) == '0')
            i++;
        
        return str.substring(i).toString();
    }
}