//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    int getSingle(int arr[]) {
        // code here
        Arrays.sort(arr);
        int el = -1;
        
        for(int i = 0; i < arr.length; i++)
        {
            int count = 1;
            el = arr[i];
            
            while(i < arr.length-1 && arr[i] == arr[i+1])
            {
                i++;
                count++;
                el = arr[i];
            }
            
            if(count % 2 != 0)
            {
                return el;
            }
        }
        
        return el;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
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
            Solution obj = new Solution();
            int res = obj.getSingle(arr);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends