//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int x=0, y=0;
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        char dir = 'e';
        helper(matrix, 0, 0, dir);
        return new int[]{x,y};
    }
    
    private void helper(int[][] mat, int r, int c, char dir){
        if(r>=mat.length || r<0 || c<0 || c>=mat[0].length){
            return;
        }
        x=r; y=c;
        if(mat[r][c] == 0){
            if(dir == 'n') helper(mat, r-1, c, dir);
            else if(dir == 's') helper(mat, r+1, c, dir);
            else if(dir == 'w') helper(mat, r, c-1, dir);
            else if(dir == 'e') helper(mat, r, c+1, dir);
        }
        else{
            mat[r][c] = 0;
            if(dir == 'n') helper(mat, r, c+1, 'e');
            else if(dir == 's') helper(mat, r, c-1, 'w');
            else if(dir == 'w') helper(mat, r-1, c, 'n');
            else if(dir == 'e') helper(mat, r+1, c, 's');
        }
        
    }
}