//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int longestUniqueSubsttr(String S) {
        int windowStart = 0;
        int windowEnd = 0;
        int n = S.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        while (windowEnd < n) {
            char ch = S.charAt(windowEnd);
            if (map.containsKey(ch) && map.get(ch) >= windowStart) {
                windowStart = map.get(ch) + 1;
            }

            map.put(ch, windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            windowEnd++;
        }

        return maxLen;
    }
    
}