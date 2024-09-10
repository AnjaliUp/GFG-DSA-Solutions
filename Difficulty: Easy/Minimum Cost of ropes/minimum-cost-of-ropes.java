//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


class Solution {
    public long minCost(long[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long cost = 0;
        for (long ele : arr) {
            pq.add(ele);
        }

        while (pq.size() != 1) {
            long first = pq.poll();
            long second = pq.poll();
            cost += first + second;
            pq.add(second + first);
        }
        
        return cost;
    }
}