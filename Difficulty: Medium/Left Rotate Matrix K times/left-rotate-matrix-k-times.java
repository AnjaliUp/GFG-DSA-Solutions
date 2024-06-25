//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        int m = k%mat[0].length;
        for(int i =0; i<mat.length; i++)
        {
            find(mat[i] , m);
        }
        return mat;
    }
    public void find(int a[] , int m)
    {
         reverse(a , 0  , m-1);
         reverse(a , m , a.length-1);
         reverse(a , 0 , a.length-1);
    }
    public void reverse(int a[] , int start , int end)
    {
         while(start <= end)
         {
             int t = a[start];
             a[start] = a[end];
             a[end] = t;
             start ++;
             end--;
         }
    }
}