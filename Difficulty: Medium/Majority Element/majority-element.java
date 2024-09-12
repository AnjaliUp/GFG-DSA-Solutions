//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        int n = arr.length;
        int count = 1, element = arr[0];
        
        for(int i=1; i<n; i++){
            if(count == 0){
                element = arr[i];
                
            }if(arr[i] == element){
                count++;
            }
            
            else{
                count--;
            }
        }
        
        int cnt = 0;
        for(int i =0; i<n; i++){
            if(arr[i] == element){
                cnt++;
            }
            
        }
        
        if(cnt >n/2){
            return element;
        }else{
            return -1;
        }
    }
}