//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        int ans=0,result=-1,count=0;
       for(int[] a:arr){
           int index=firstOccurence(a,a.length-1);
           if(index!=Integer.MAX_VALUE){
               if(a.length-index>ans){
                   ans=a.length-index;
                   result=count;
               }
           }
          count++;
       }
       return result;
    }
    private int firstOccurence(int[] arr,int n){
        int low=0,high=n;
        int index=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==1){
                index=Math.min(index,mid);
                if(mid-1>=0 && arr[mid-1]==1) high=mid-1;
                else return index;
            }else{
                low=mid+1;
            }
        }
        
        return index;
    }
}