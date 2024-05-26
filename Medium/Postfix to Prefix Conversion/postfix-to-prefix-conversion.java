//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post) {
        Stack<String> s = new Stack<>();
        for(int i =0; i<post.length();i++){
            char c = post.charAt(i);
            
            if(Character.isLetter(c))s.push(String.valueOf(c));
            else{
                String a = s.pop();
                String b = s.pop();
                s.push(c+b+a);
            }
        }
        
        return s.pop();
    }
}
