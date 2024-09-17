//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    int getMinDiff(int[] arr, int k) {
        // Number of towers
        int n = arr.length;
        
        // Sort the array to arrange towers by their height
        Arrays.sort(arr);
        
        // The initial difference between the max and min heights (before modification)
        int res = arr[n-1] - arr[0];
        
        // The smallest and largest elements after adding or subtracting k
        int smallest = arr[0] + k;
        int largest = arr[n-1] - k;
        
        // Loop through the array and find the minimum possible difference
        for (int i = 1; i < n; i++) {
            // Skip if subtracting k results in a negative height
            if (arr[i] - k < 0) {
                continue;
            }

            // Calculate the minimum and maximum heights possible
            int min = Math.min(smallest, arr[i] - k);
            int max = Math.max(largest, arr[i-1] + k);

            // Update the result with the new difference
            res = Math.min(res, max - min);
        }
        
        return res;
    }
}
