//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// import java.util.*;

class Solution {
    static List<Integer> nextPermutation(int N, int arr[]) {
        // Step 1: Convert the array to a List
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(arr[i]);
        }

        // Step 2: Find the first index 'ind' where arr[ind] < arr[ind+1]
        int ind = -1;
        for (int i = N - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                ind = i;
                break;
            }
        }

        // Step 3: If no such index is found, reverse the entire array
        if (ind == -1) {
            Collections.reverse(list);
            return list;
        }

        // Step 4: Find the next greater element after index 'ind'
        for (int i = N - 1; i > ind; i--) {
            if (list.get(i) > list.get(ind)) {
                // Swap arr[ind] and arr[i]
                int temp = list.get(i);
                list.set(i, list.get(ind));
                list.set(ind, temp);
                break;
            }
        }

        // Step 5: Reverse the sublist after 'ind'
        List<Integer> sublist = list.subList(ind + 1, N);
        Collections.reverse(sublist);

        return list;
    }
}
