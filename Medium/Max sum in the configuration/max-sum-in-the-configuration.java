//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        long res = 0, totalSum = 0, maxi = 0;
        
        for(int i = 0; i < n; i++) {
            totalSum += a[i];
            res += (i * 1l * a[i]);
        }
        
        maxi = Math.max(maxi, res);
        for(int i = 0; i < n; i++) {
            res = res - (totalSum - a[i]) + (a[i] * 1l * (n - 1));
            maxi = Math.max(maxi, res);
        }
        
        return maxi;
    }
}