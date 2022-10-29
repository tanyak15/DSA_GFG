package GRAPHS;

import java.util.ArrayList;
import java.util.PriorityQueue;

//class Node1{
//    int v;int weight;
//    Node1(int v , int w){
//        this.v = v;
//        this.weight = w ;
//    }
//    Node1(){    }
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
public class dijkstras {
    static void addEdge(ArrayList<ArrayList<Node>> adj, int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
    }

    static void dijkstraAlgo(int s, ArrayList<ArrayList<Node>> adj, int V) {

//      1.  create a distance array and initialize it to infinity
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

//      2.  mark dist to the source as 0
        dist[s] = 0;

//      3.  create a min priority queue
        PriorityQueue<Node> pq = new PriorityQueue<Node>(V,new Node());

//        add source and its weight in priority queue
        pq.add(new Node(s, 0));

//      4.  we traverese the priority queue till is becomes empty
        while (pq.size() > 0) {

//          remove the first element and store it in node
            Node node = pq.poll();

            for (Node it : adj.get(node.getV())) {
                if (dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Node>());
        }
        int s = 0;
        addEdge(adj, 0, 1, 5);
        addEdge(adj, 0, 2, 8);
        addEdge(adj, 1, 3, 15);
        addEdge(adj, 1, 2, 10);
        addEdge(adj, 2, 3, 20);
        dijkstraAlgo(s, adj, V);
    }
}
