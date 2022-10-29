package GRAPHS;

import java.util.ArrayList;

public class articulation_point {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj , int node , int parent ,
    boolean[] visited , int[] discovered ,  int[] low , int timer , boolean[] articulation){
        visited[node] = true;
        discovered[node] = low[node] = timer++;

        int child =0;
        for (Integer it : adj.get(node)){
            if (it == parent){
                continue;
            }
            if (visited[it] == false) {
                dfs(adj, it, node, visited, discovered, low, timer, articulation);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] > discovered[node] && parent != -1) {
                    articulation[node] = true;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node], discovered[it]);
            }
        }
        if(child > 1 && parent == -1){
            articulation[node] = true;
        }

    }
    static void articulation(ArrayList<ArrayList<Integer>> adj , int V){
        boolean[] visited = new boolean[V];
        int[] discovered = new int[V];
        int[] low = new int[V];

        boolean[] articulation = new boolean[V];
        int timer = 0;
        for (int i=0;i<V;i++){
            if (visited[i] == false){
                dfs(adj , i ,-1 ,visited ,discovered ,low ,timer ,articulation);
            }
        }
        for(int i = 0;i<V;i++) {
            if(articulation[i] == true)
                System.out.println(i);
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
        articulation(adj, V);
    }
}
