//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            int ans = obj.verticalWidth(root);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {
        // code here.
        if (root == null) return 0;

        Set<Integer> set = new HashSet<>();
        Queue<Node> nodes = new LinkedList<>();
        Queue<Integer> distances = new LinkedList<>();

        nodes.add(root);
        distances.add(0);

        while (!nodes.isEmpty()) {
            Node current = nodes.poll();
            int hd = distances.poll();

            set.add(hd);

            if (current.left != null) {
                nodes.add(current.left);
                distances.add(hd - 1);
            }
            if (current.right != null) {
                nodes.add(current.right);
                distances.add(hd + 1);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        root1.right.left.right = new Node(8);
        root1.right.right.right = new Node(9);
        System.out.println(solution.verticalWidth(root1));

      
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        System.out.println(solution.verticalWidth(root2)); 
    }
}