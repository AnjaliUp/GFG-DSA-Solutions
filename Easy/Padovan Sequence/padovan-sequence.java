//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int padovanSequence(int n)
    {
        // Initialize the first three Padovan numbers
        int pPrevPrev = 1; // P(0)
        int pPrev = 1;     // P(1)
        int pCurr = 1;     // P(2)
        
        // Compute the next Padovan numbers
        for (int i = 3; i <= n; i++)
        {
            int pNext = (pPrevPrev + pPrev) % 1000000007; // Compute modulo 10^9+7
            pPrevPrev = pPrev;
            pPrev = pCurr;
            pCurr = pNext;
        }
        
        return pCurr;
    }
}