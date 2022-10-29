package GRAPHS;

import java.lang.reflect.Array;
import java.util.*;
class adjListNode{
    int v;
    int weight;
    adjListNode(int v , int w){
        this.v = v;
        this.weight = w;
    }
    int getV(){
        return v;
    }
    int getWeight(){
        return weight;
    }
}
public class shortest_path_in_DAG {

     static void addEdge( LinkedList<adjListNode> adj[] ,int u , int v , int weight){
        adjListNode node = new adjListNode(v , weight);
            adj[u].add(node);

    }
    static void DFS(LinkedList<adjListNode> adj[] ,int u , boolean[] isVisited , Stack<Integer> st){
        isVisited[u] = true;

//        get the adjacent element from linked list
        LinkedList<adjListNode> adjList = adj[u];
        for(adjListNode node : adjList){
            int vertex = node.getV();
            if (!isVisited[vertex]){
                DFS(adj , vertex , isVisited ,st);
            }
        }
        st.push(u);
    }

    static ArrayList<Integer> topologicalSort(LinkedList<adjListNode> adj[] , int v){
        Stack<Integer> st = new Stack<>();
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0;i<v;i++){
            if (!isVisited[i]){
                DFS(adj ,i ,isVisited ,st);
            }
        }
        while (!st.isEmpty()){
            int curr = st.pop();
            arr.add(curr);
        }
        return arr;
    }
    static void shortestPath(LinkedList<adjListNode> adj[],int V, int s){
        ArrayList<Integer> tpSort = topologicalSort(adj , V);
        int[] dist = new int[V];
        for (int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

        for (int i=0;i<tpSort.size() ;i++) {
            int u = tpSort.get(i) ;
            for(adjListNode node  : adj[u]) {
                int vert = node.getV();
                int wht = node.getWeight();
                dist[vert] = Math.min(dist[vert] , dist[u] + wht);

            }
        }
        for (int i=0;i< dist.length;i++){
            System.out.print(dist[i]+" ");
        }

    }

//  ********************************************************************************************************

    public static void main(String[] args) {
        int V = 6;
        int s =0;
//        ArrayList<LinkedList<adjListNode>> adj = new ArrayList<LinkedList<adjListNode>>(V);
        LinkedList<adjListNode> adj[] = new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i] = new LinkedList<adjListNode>();
        }

        addEdge(adj ,0, 1 ,2);
        addEdge(adj ,0, 4 ,1);
        addEdge(adj ,2, 3 ,6);
        addEdge(adj ,1, 2 ,3);
        addEdge(adj ,4, 5 ,4);
        addEdge(adj ,5, 3 ,1);
        addEdge(adj ,4, 2 ,2);

shortestPath(adj , V , s);


    }
}
