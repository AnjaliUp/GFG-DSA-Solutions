//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        if (arr.length == 0) {
            return new int[] { -1, -1 }; // Handle empty array case
        }

        // Sort the array to use binary search effectively
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1; 
        int ceil = -1;  // Initialize ceil to -1 (not found)
        int floor = -1; // Initialize floor to -1 (not found)

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ceil = arr[mid]; // Update ceil
                high = mid - 1;  // Move left
            } else if (arr[mid] < x) {
                floor = arr[mid]; // Update floor
                low = mid + 1;    // Move right
            } else {
                // Element found, both floor and ceil are the same
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }

        return new int[] { floor, ceil }; // Return the results
    }
}
