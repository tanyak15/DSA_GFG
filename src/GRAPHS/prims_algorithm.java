package GRAPHS;

import java.util.ArrayList;

//class adjListNode{
//    int v ;
//    int weight;
//
//    adjListNode(int v ,int w){
//        this.v = v;
//        this.weight = w;
//    }
//
//    int getV(){
//        return this.v;
//    }
//    int getWeight(){
//        return this.weight;
//    }
//}
public class prims_algorithm {

    static void addEdge(ArrayList<ArrayList<adjListNode>> adj ,int u ,int v, int w){
        adj.get(u).add(new adjListNode(v , w));
    }

    static void primsAlgo(ArrayList<ArrayList<adjListNode>> adj ,int V){
//        creating 3 arrays
        int key[] = new int[V];
        int parent[] = new int[V];
        boolean mstSet[] = new boolean[V];

//        updating the initial values in the array
        for (int i=0;i<V;i++){
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mstSet[i] = false;
        }

//        making key of zero is equal to 0
        key[0] = 0;

//        we are going to run the loop till V-1 as in spanning tree edge is one less than the vertex
        for (int i=0;i<V-1;i++){
            int mini = Integer.MAX_VALUE;
            int currNode = 0;
//            minimum relaxed value se vertex find krre h
            for (int v =0;v<V;v++){
                if (mstSet[v] == false && key[v] < mini){
                    mini = key[v];
                    currNode = v;
                }
            }
            mstSet[currNode] = true;

//            now we iterate it for its adjacent node and update the key index if the weight was lesser
            for (adjListNode it : adj.get(currNode)){
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]){
//                    update the parent
                    parent[it.getV()] = currNode;
//                    update the key
                    key[it.getV()] = it.getWeight();
                }
            }
        }
        for (int i=1;i<V;i++){
            System.out.println(parent[i] + "-" + i);
        }
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<adjListNode>> adj = new ArrayList<ArrayList<adjListNode>>();

        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(adj , 0 ,1 ,5);
        addEdge(adj , 0 ,2 ,8);
        addEdge(adj , 1 ,3 ,15);
        addEdge(adj , 1 ,2 ,10);
        addEdge(adj , 2 ,3 ,20);

        primsAlgo(adj , V);
    }
}
