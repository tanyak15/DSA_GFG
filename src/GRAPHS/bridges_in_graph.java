package GRAPHS;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class bridges_in_graph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);

    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean visited[], int dicovered[], int low[], int timer) {
        visited[node] = true;
        dicovered[node] = low[node] = timer++;

        for (int it : adj.get(node)) {
            if (it == parent) {
                continue;
            }
            if (visited[it] == false) {
                dfs(adj, it, node, visited, dicovered, low, timer);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] > dicovered[node]) {
                    System.out.print(it + " " + node);
                    System.out.println();
                }
            }
            else{
                low[node] = Math.min(low[node] , dicovered[it]);

            }
        }
    }

    static void bridges(ArrayList<ArrayList<Integer>> adj, int V) {

//        create three arrays
        boolean[] visited = new boolean[V];
        int[] discovered = new int[V];  //to mark this has been discovered
        int[] low = new int[V];         // to mark lowest discovered time reachable through tree

//        checking the condition whetere it is visited or not
        int timer = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
//                if not visited call dfs
                dfs(adj, i, -1, visited, discovered, low, timer);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);

        int s = 0;
        bridges(adj, V);
    }
}
