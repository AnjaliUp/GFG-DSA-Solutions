//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int q = sc.nextInt();
      int ind[]=new int[q]; 
      for(int i=0;i<q;i++) ind[i]=sc.nextInt();
      Solution obj = new Solution();
      int ans[] = obj.count_NGEs(n,a,q,ind);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {

  public static int[] count_NGEs(int N, int A[], int Q, int I[]) {

      int res[] = new int[Q];

      for(int i=0;i<Q;i++)

      {

          int k=I[i],c=0;

          for(int j=k+1;j<A.length;j++)

          {

             if(A[j]>A[k])

                {  c++; }

          }

          res[i]=c;

          

      }

      

      return res;

    // code here

     

  }
  
}