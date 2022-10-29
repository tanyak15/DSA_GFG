package GRAPHS;

import java.util.ArrayList;
import java.util.Stack;

public class topological_sorting_DFS_based {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

//    static void DFS(ArrayList<ArrayList<Integer>> adj, int u, Stack<Integer> st, boolean[] isVisited) {
//
//        isVisited[u] = true;
//
//        ArrayList<Integer> adjList = adj.get(u);
//        for (int i = 0; i < adjList.size(); i++) {
//            int adjVert = adjList.get(i);
//            if (!isVisited[adjVert]) {
//                DFS(adj, adjVert, st, isVisited);
//            }
//        }
//        st.push(u);
//
//    }
//    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v) {
//        Stack<Integer> st = new Stack<>();
//        boolean[] isVisited = new boolean[v];
//
//        for (int i = 0; i < v; i++) {
//            if (!isVisited[i]) {
//                DFS(adj, i, st, isVisited);
//            }
//        }
//        while (!st.isEmpty()) {
//            System.out.print(st.pop() + " ");
//        }
//    }

// prac-1

    static void DFS(ArrayList<ArrayList<Integer>> adj ,int u , boolean[] isVisited , Stack<Integer> st){
        isVisited[u] = true;

        for (int r : adj.get(u)){
            if (!isVisited[r]){
                DFS(adj , r ,isVisited ,st);
            }
        }
        st.push(u);
    }

    static void topologicalSort(ArrayList<ArrayList<Integer>> adj ,int v){
        Stack<Integer> st =new Stack<>();
        boolean[] isVisited = new boolean[v];
        for (int i=0;i<v;i++){
            if (!isVisited[i]){
                DFS(adj ,i , isVisited ,st);
            }
        }
        while (!st.isEmpty()) {

            System.out.print(st.pop() +" ");
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 4);

        System.out.println("Following is a Topological Sort of");
        topologicalSort(adj, V);
    }
}
