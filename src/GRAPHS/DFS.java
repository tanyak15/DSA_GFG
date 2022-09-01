package GRAPHS;
import java.util.*;
public class DFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj ,int u , int v){
        adj.get(u).add(v);
        adj.get(v).add(u);

    }
    static void DFS(ArrayList<ArrayList<Integer>> adj ,int s ,boolean[] isVisited) {
        isVisited[s] = true;
        System.out.print(s+" ");

        ArrayList<Integer> adjList = adj.get(s);
        for(int i=0;i<adjList.size();i++){
            int adjVert = adjList.get(i);
            if(!isVisited[adjVert]){
                DFS(adj ,adjVert,isVisited);
            }
        }
    }

    static void DFSRec(ArrayList<ArrayList<Integer>> adj ,int v){
        boolean[] isVisited = new boolean[v];

        for(int i=0;i<v;i++){
            if (!isVisited[i] ) {
                DFS(adj ,i,isVisited );
            }
        }
        //

    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        addEdge(adj,4,5);

        DFSRec(adj ,V);
    }
}
