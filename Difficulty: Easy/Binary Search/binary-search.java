//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            Solution ob = new Solution();
            int res = ob.binarysearch(arr, k);
            System.out.println(res);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Wrapper function to initiate the recursive binary search
    public int binarysearch(int[] arr, int k) {
        // Start the search with the full range of the array
        return binarySearch(arr, k, 0, arr.length - 1);
    }

    // Recursive binary search function
    public int binarySearch(int[] arr, int k, int low, int high) {
        // Base case: if the search range is invalid, return -1
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2; // Calculate the mid index to prevent overflow

        // Check if the middle element is the target
        if (arr[mid] == k) {
            return mid;
        }

        // If the target is smaller than the middle element, search the left half
        if (arr[mid] > k) {
            return binarySearch(arr, k, low, mid - 1);
        }

        // If the target is greater, search the right half
        return binarySearch(arr, k, mid + 1, high);
    }
}