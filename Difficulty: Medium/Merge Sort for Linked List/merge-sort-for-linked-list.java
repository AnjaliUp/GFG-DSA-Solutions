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


// } Driver Code Ends
/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if (head == null || head.next == null) {
        return head;
    }

    Node mid = findMiddleNode(head);
    Node leftHead = head;
    Node rightHead = mid.next;
    mid.next = null; // Disconnect the left and right halves

    leftHead = mergeSort(leftHead);
    rightHead = mergeSort(rightHead);
    return merge(leftHead, rightHead);
    }
    static Node findMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next; // head->next because we want slow to point to the
                           // first element/middle in the even length case

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge linked list function
    static Node merge(Node list1Head, Node list2Head) {
    Node dummyNode = new Node(-1); // can be any value
    Node temp = dummyNode;

    while (list1Head != null && list2Head != null) {
        if (list1Head.data <= list2Head.data) {
            temp.next = list1Head;
            temp = list1Head;
            list1Head = list1Head.next;
        }
        else
        {
            temp.next = list2Head;
             temp = list2Head;
            list2Head = list2Head.next;
        }
    }

    // if list1 still has elements left
        while (list1Head != null) {
            temp.next = list1Head;
            temp = list1Head;
            list1Head = list1Head.next;
        }

    // if list2 still has elements left
        while (list2Head != null) {
            temp.next = list2Head;
            temp = list2Head;
            list2Head = list2Head.next;
        }
    return dummyNode.next;
}
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        }
    }
}

// } Driver Code Ends