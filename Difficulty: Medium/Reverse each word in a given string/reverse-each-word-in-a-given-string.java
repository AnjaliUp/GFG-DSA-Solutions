//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseWords(String S)
    {
        Stack<Character>st= new Stack<>();
        
        for(int i=0; i<S.length(); i++)
        {
            st.push(S.charAt(i));
        }
        
        String ans = "";
        String temp="";
        while(!st.isEmpty())
        {
            if(st.peek()!='.')
            {
                temp+=st.peek();
            }
            else
            {
                ans="."+temp+ans;
                temp="";
            }
            st.pop();
        }
        ans= temp+ans;
        return ans;
    }
}