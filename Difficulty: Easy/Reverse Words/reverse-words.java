//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // Split the string by '.' using regex.
        String ans[] = str.split("\\.");
        int start = 0;
        int end = ans.length - 1;
        
        // Reverse the array of words.
        while (start < end) {
            // Swap the elements at start and end indices.
            String temp = ans[start];
            ans[start] = ans[end];
            ans[end] = temp;
            start++;
            end--;
        }
        
        // Join the reversed array into a string with '.' separator.
        String res = String.join(".", ans);
        return res;
    }
}
