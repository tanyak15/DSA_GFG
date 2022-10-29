package GRAPHS;

import java.lang.reflect.Array;
import java.util.*;

public class kosaraju_algo {
    static void addEdge(ArrayList<ArrayList<Integer>> adj , int v , int u){
        adj.get(u).add(v);

    }
//    to add acc to the decreasing order of thier finish time
    static void dfs(int i , Stack<Integer> st , ArrayList<ArrayList<Integer>> adj , boolean visited[]){
        visited[i] = true;
        for (Integer it : adj.get(i)){
            if(visited[it] == false){
                dfs(it , st ,adj ,visited);
            }
        }
        st.push(i);
    }

    static void reverseDfs(int i , ArrayList<ArrayList<Integer>> reverse , boolean visited[]){
        visited[i] = true;
        System.out.print(i + " ");
        for (Integer it : reverse.get(i)){
            if (visited[it] == false){
                reverseDfs(it , reverse , visited);
            }
        }

    }
    static void kosaraju(ArrayList<ArrayList<Integer>>adj , int V){
        Stack<Integer> st =  new Stack<>();
        boolean[] visited = new boolean[V];

//        calling dfs to add elements into the stack
        for (int i=0;i<V;i++){
            if (visited[i] == false){
                dfs(i,st,adj,visited);
            }
        }
//        2. to reverse all the edges of the graph
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<ArrayList<Integer>>();

        for (int i=0;i<V;i++){

            reverse.add(new ArrayList<Integer>());
        }
        for (int i=0;i<V;i++){
            visited[i] = false;
            for (Integer it : adj.get(i)){
                reverse.get(it).add(i);
            }
        }
        while(st.size()>0){
            int node = st.pop();
           if (visited[node] == false){
               System.out.print("--> ");
               reverseDfs(node , reverse , visited);
               System.out.println();
           }
        }

    }
    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1 );
        addEdge(adj, 1, 2 );
        addEdge(adj, 2, 0 );
        addEdge(adj, 1, 3 );
        addEdge(adj, 3, 4);

//        addEdge(adj, 1, 3 );
//        addEdge(adj, 2, 1 );
//        addEdge(adj, 3, 2 );
//        addEdge(adj, 3, 5 );
//        addEdge(adj, 4, 6);
//        addEdge(adj, 5, 4);
//        addEdge(adj, 6, 5);
        int s = 0;
        kosaraju(adj, V);
    }
}
