//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        long[] ans = new long[n];
        
        if (n == 2) {
            ans[0] = nums[1];
            ans[1] = nums[0];
            return ans;
        }
        
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        
        if (zeroCount > 1) {
            for (int i = 0; i < n; i++) {
                ans[i] = 0;
            }
        } else if (zeroCount == 1) {
            int zeroIndex = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    zeroIndex = i;
                    break;
                }
            }
            
            long prod = 1;
            for (int i = 0; i < n; i++) {
                if (i != zeroIndex) {
                    prod *= nums[i];
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (i == zeroIndex) {
                    ans[i] = prod;
                } else {
                    ans[i] = 0;
                }
            }
        } else {
            long prod = 1;
            for (int i = 0; i < n; i++) {
                prod *= nums[i];
            }
            
            for (int i = 0; i < n; i++) {
                ans[i] = prod / nums[i];
            }
        }
        
        return ans;
    }
}

