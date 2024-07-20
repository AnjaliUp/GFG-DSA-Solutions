//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
   public static int maxMeetings(int start[], int end[], int n) {
        // Create a 2D array to store start and end times
        int[][] nums = new int[n][2];
        
        // Fill the 2D array with start and end times
        for (int i = 0; i < n; i++) {
            nums[i][0] = start[i];
            nums[i][1] = end[i];
        }
        
        // Sort the array based on end times
        Arrays.sort(nums, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Initialize the count of meetings
        int count = 1;
        int ansEnd = nums[0][1];
        
        // Iterate through the sorted meetings
        for (int i = 1; i < nums.length; i++) {
            // If the start time of the current meeting is greater than the end time of the last meeting
            if (nums[i][0] > ansEnd) {
                count++;
                ansEnd = nums[i][1];
            }
        }
        
        return count;
    }

}
