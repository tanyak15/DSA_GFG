package GRAPHS;


import java.util.*;

class Node implements Comparator<Node> {
    int v;
    int weight;

    Node(){

    }
    Node(int v, int w) {
        this.v = v;
        this.weight = w;
    }

    int getV() {
        return this.v;
    }

    int getWeight() {
        return this.weight;
    }
    @Override
    public int compare(Node n1 , Node n2){
        if (n1.weight < n2.weight){
            return -1;
        }
        if (n1.weight > n2.weight){
            return 1;
        }
        return 0;
    }
}

public class prims_algorithm_efficient {
    static void addEdge(ArrayList<ArrayList<Node>> adj, int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
    }

    static void primsAlgo_eff(ArrayList<ArrayList<Node>> adj, int V) {
//        creating 3 arrays
        int key[] = new int[V];
        int parent[] = new int[V];
        boolean mstSet[] = new boolean[V];

//        updating the initial values in the array
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mstSet[i] = false;
        }
//       creating a min priority queue
        PriorityQueue<Node> pq = new PriorityQueue<Node>(V , new Node());

        key[0] = 0;
        pq.add(new Node(0, key[0] ));

        for (int i=0;i<V-1;i++){
            int u = pq.poll().getV();
            mstSet[u] = true ;

            for (Node it : adj.get(u)){
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]){
                    parent[it.getV()] = u ;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV() , key[it.getV()]));
                }
            }
        }
        for (int i=1;i<V;i++){
            System.out.println(parent[i] +"-" + i);
        }
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Node>());
        }

        addEdge(adj, 0, 1, 5);
        addEdge(adj, 0, 2, 8);
        addEdge(adj, 1, 3, 15);
        addEdge(adj, 1, 2, 10);
        addEdge(adj, 2, 3, 20);

        primsAlgo_eff(adj, V);
    }
}
