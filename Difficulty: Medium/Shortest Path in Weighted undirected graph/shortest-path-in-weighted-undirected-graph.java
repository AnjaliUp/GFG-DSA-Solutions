//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends

class Solution{
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        // {node : {nbr : cost}} <---- HashMap will store elements like this.
        HashMap<Integer , HashMap<Integer,Integer>> adj = new HashMap<>();
        prepareAdjacencyList (n , edges , adj);
        
        
        int parent[] = new int[n+1]; // It will store the node due to which the ith node is relaxed.
        int dist[] = new int[n+1];
        
        Arrays.fill (dist , Integer.MAX_VALUE);
        parent[1] = 1;  // Node '1' is parent of itself. As , it cannot be further relaxed.
        dist[1] = 0;
        
        // It will store the pair on the top having less distance as compare to other pairs.
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            
            @Override
            public int compare (Pair p1 , Pair p2) {
                
                return p1.dist - p2.dist;
            }
        });
        
        pq.add (new Pair (0 , 1));
        
        while (!pq.isEmpty ()) {
            
            // 1. Remove 
            Pair pr = pq.poll ();
            int uDist = pr.dist;
            int u = pr.node;
            
            // 2. Get all the neighbours of rv and check for any relaxation.
            for (int v : adj.get (u).keySet()) {
                
                int edgeCost = adj.get (u).get (v);
                
                // Relaxation step
                if (uDist + edgeCost < dist[v]) {
                    
                    dist[v] = uDist + edgeCost;
                    pq.add (new Pair (dist[v] , v));
                    
                    parent[v] = u;  // Storing the parent of 'v' due to which 'v' is relaxed.
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        // It means nth node is relaxed.
        if (dist[n] != Integer.MAX_VALUE) {
            
            ans.add (dist[n]);
        
            int node = n;
            
            // Stops when 1 != 1
            while (parent[node] != node) {
                
                ans.add (node); // Storing each node.
                node = parent[node]; // getting parent of a node.
                
            }
            
            ans.add (1);
            
        } else {
            
            ans.add (-1);
        }
        
        return ans;
    }
    
    public void prepareAdjacencyList  (int n , int edges[][] , HashMap<Integer,HashMap<Integer,Integer>> adj) {
        
        // Initializing the adj Hashmap.
        for (int i = 1 ; i <= n ; i++) {
            
            adj.put (i , new HashMap<Integer , Integer>());
        }
        
        for (int edge[] : edges) {
            
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            // Since , the graph is undirected i.e. edge from both the end will be considered.
            adj.get (u).put (v , cost);
            adj.get (v).put (u , cost);
            
        }
    }
}

class Pair {
    
    int dist;
    int node;
     
    public Pair (int dist , int node) {
        
        this.dist = dist;
        this.node = node;
    }
}