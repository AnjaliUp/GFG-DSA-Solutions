//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        
        Stack<Character> st = new Stack<>();
        String result = "";
        
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
               result +=c;
            else if(c=='(')
               st.push('(');
            else if(c==')'){
                while(st.peek()!='('){
                    result +=st.peek();
                    st.pop();
                }
                
                st.pop();
            }
            
            else{
                while(!st.empty() && prec(s.charAt(i))<= prec(st.peek())){
                    result+= st.peek();
                    st.pop();
                }
                st.push(c);
            }
        }
        
        while(!st.empty()){
            result+= st.peek();
            st.pop();
        }
        
        return result;
    }
}