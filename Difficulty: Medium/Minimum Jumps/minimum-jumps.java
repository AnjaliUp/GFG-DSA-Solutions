//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int jumps=0, max=0, stop_jump=0, n=arr.length;
        for(int i=0;i<n;i++){
            stop_jump = Math.max(stop_jump, i+arr[i]);
            
            if(max==i){
                //this is the last idx no need to jump further
                if(i==n-1)  break;
                jumps++;
                max = stop_jump;
            }
            //we can't reach this idx
            else if(max<i){
                return -1;
            }
        }
        return jumps;
    }
}