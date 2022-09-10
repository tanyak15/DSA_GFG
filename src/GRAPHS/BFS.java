package GRAPHS;
import java.util.*;
public class BFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj ,int u , int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void BFS(ArrayList<ArrayList<Integer>> adj , int v , int s ){
        boolean[] isVisited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        isVisited[s] =true;

        while(!q.isEmpty())
        {
            int curr = q.poll();
            System.out.print(curr +" ");
            ArrayList<Integer> adjList = adj.get(curr);
            for (int i=0;i<adjList.size() ;i++ ){
                int adjVert = adjList.get(i);
                if (!isVisited[adjVert]) {
                    q.add(adjVert);
                    isVisited[adjVert] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,3,4);

        BFS(adj, V ,0);


    }
}
