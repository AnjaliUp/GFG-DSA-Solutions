//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution
{
    // The helper method recursively traverses to the end of the linked list, adds 1 to the least significant digit,
    //and manages any carry-over as it backtracks through the list. If an overflow 
    // occurs (e.g., 9 + 1 becomes 10), it sets the current digit to 0 and passes a carry of 1 to the previous node.
    public static int helper(Node head){
        if(head==null){
            return 1;
        }
        
        int carry = helper(head.next);
        head.data = head.data + carry;
        if(head.data<10){
            return 0;
        }
        head.data = 0;
        return 1;
    }
    
    
    public static Node addOne(Node head)
    { 
        int carry = helper(head);
        if(carry==1){
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
            return newNode;
        }
        return head;
    }
}