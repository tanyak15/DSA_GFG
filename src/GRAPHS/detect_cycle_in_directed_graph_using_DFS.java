package GRAPHS;

import java.util.ArrayList;

public class detect_cycle_in_directed_graph_using_DFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj ,int s , boolean[] isVisited , boolean[] recStack ){
        isVisited[s] =true;
        recStack[s] =true;

        ArrayList<Integer> adjList = adj.get(s);
        for (int i=0;i<adjList.size();i++){
            int adjVert = adjList.get(i);
            if (!isVisited[adjVert] && DFSRec(adj , adjVert ,isVisited , recStack)){
                return true;
            }
            else if(recStack[adjVert]){
                return true;
            }
        }
        recStack[s] =false;
        return false;
    }
    static boolean DFS(ArrayList<ArrayList<Integer>> adj ,int v ){
        boolean[] isVisited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for (int i=0;i<v;i++){
            if (!isVisited[i]){
                if (DFSRec(adj , i ,isVisited , recStack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,2,1);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,5,3);

        if(DFS(adj,V)==true)
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");
    }
}
