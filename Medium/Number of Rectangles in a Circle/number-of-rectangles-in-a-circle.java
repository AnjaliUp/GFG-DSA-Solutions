//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
  int rectanglesInCircle(int r) {
    int count = 0;
    int n = 2 * r;
    for (int i = 1; i <= n; i++) {
      int t1 = i * i;
      for (int j = 1; j <= n; j++) {
        int t2 = j * j;
        int r1 = 4 * r * r;
        if ((t1 + t2) <= r1) {
          count++;
        }
      }
    }
    return count;
  }
}
