//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        StringBuilder ans = new StringBuilder();
        while(d>0){
            if(s==1){
                if(d>1){
                    ans.append(0);
                }
                else {
                    ans.append(s);
                    s = 0;
                }
            }
            else if(s>9){
                if(d>1){
                    ans.append(9);
                    s = s - 9;
                }
                else {
                    return "-1";
                }
            }
            else if(s<=9){
                if(d>1){
                    ans.append((s-1));
                    s = 1;
                }
                else {
                    ans.append(s);
                    s = 0;
                }
            }
            d--;
        }
        return ans.reverse().toString();
    }
}
