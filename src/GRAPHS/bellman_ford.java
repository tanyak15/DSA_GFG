package GRAPHS;

import java.util.*;

//class Node1{
//    int u;
//    int v;
//    int weight;
//    Node1(int u ,int v , int w){
//        this.u = u;
//        this.v = v;
//        this.weight = w ;
//    }
//    Node1(){    }
//
//    public int getU() {
//        return u;
//    }
//
//    public int getV() {
//        return v;
//    }
//    public int getWeight(){
//        return weight;
//    }
//
//
//    public int compare(Node1 n1  , Node1 n2){
//        if(n1.weight > n2.weight){
//            return 1;
//        }
//        else if (n1.weight < n2.weight){
//            return -1;
//        }
//        return 0;
//    }
//}
public class bellman_ford {

    static void addEdge(ArrayList<ArrayList<Node>> adj, int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
    }

    static void bellmanFord(ArrayList<ArrayList<Node>> adj, int V, int s) {

//        create a dist array
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

//        relaxing the n-1 edges
        for (int i = 0; i < V -1; i++) {
            for (Node node : adj.get(i)) {
                dist[node.getV()] = Math.min(dist[node.getV()], dist[i] + node.getWeight());
//               if( dist[i] + node.getWeight() < dist[node.getV()]){
//                   dist[node.getV()] =dist[i] + node.getWeight();
//
//               }
            }
        }

//       relaxing one last time so see whetehr it contains a negative cycle
        int res = 0;
        for (Node node : adj.get(V-1)) {
            if (dist[V-1] + node.getWeight() < dist[node.getV()]) {
                res = 1;
                System.out.println("negative cycle");
                break;
            }
        }

        if(res == 0){
            for (int i = 0; i < V; i++) {
                System.out.println(i+" - "+dist[i]);
            }
        }


    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Node>());
        }

        addEdge(adj, 0, 1, 1);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, -3);
        addEdge(adj, 1, 3, 2);
        addEdge(adj, 2, 3, 3);


//        addEdge(adj, 0, 1, 5);
//        addEdge(adj, 1, 2, -2);
//        addEdge(adj, 1, 5, -3);
//        addEdge(adj, 5, 3, 1);
//        addEdge(adj, 3, 2, 6);
//        addEdge(adj, 3, 4, -2);
//        addEdge(adj, 2, 4, 3);

        int s = 0;
        bellmanFord(adj, V, s);
    }
}
