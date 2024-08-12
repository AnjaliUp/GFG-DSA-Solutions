//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        
        int[] arr3 = new int[arr1.length+arr2.length];
        
        for(int i=0; i<arr1.length;i++){
            arr3[i] = arr1[i];
        }
        
        for(int j=0; j<arr2.length;j++){
            arr3[arr1.length + j] = arr2[j];
        }
        
        Arrays.sort(arr3);
        
        int mid1 = arr3[arr3.length/2];
        int mid2 = arr3[(arr3.length/2)-1];
        
        return mid1 + mid2;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends