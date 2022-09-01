package GRAPHS;

import java.util.ArrayList;

public class detect_cycle_in_an_undirected_graph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj ,int u ,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj , int s , boolean[] isVisited , int parent){
        isVisited[s] =true;

        ArrayList<Integer> adjList = adj.get(s);
        for(int i=0;i<adjList.size();i++){
            int adjVert = adjList.get(i);
            if (!isVisited[adjVert]){
                if (DFSRec(adj , adjVert , isVisited , s)){
                    return true;
                }
            }
            else if(adjVert != parent){
                return true;
            }
        }
        return false;
    }


    static boolean DFS(ArrayList<ArrayList<Integer>> adj , int v){
        boolean[] isVisited = new boolean[v];
        for (int i=0;i<v;i++){
            if (!isVisited[i]){
                if (DFSRec(adj,i,isVisited ,-1)){
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
        addEdge(adj,1,2);
        addEdge(adj,2,4);
        addEdge(adj,4,5);
        addEdge(adj,1,3);
        addEdge(adj,2,3);

        if(DFS(adj,V)==true)
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");
    }
}
