package GRAPHS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topological_sorting {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

        adj.get(u).add(v);

    }

    static void topSort(ArrayList<ArrayList<Integer>> adj, int v) {
//        array to store in degree
        int[] inDegree = new int[v];

//        updating the value of in degree in array by traversing the array of arrayList
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> adjList1 = adj.get(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjVert1 = adjList1.get(j);
                inDegree[adjVert1]++;
            }
        }
//        creating a queue
        Queue<Integer> q = new LinkedList<>();

//        adding all the 0 in degree vertex in q
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
//        checking the cond. if q is not empty
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            ArrayList<Integer> adjList = adj.get(curr);
            for (int i = 0; i < adjList.size(); i++) {
                int adjVert = adjList.get(i);
//
//         reducing the inDegree of all adjVert
                inDegree[adjVert]--;
//          if inDegree becomes zero of any vertex add it to the queue
                if (inDegree[adjVert] == 0) {
                    q.add(adjVert);
                }
            }
        }


    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);

        System.out.println("Following is a Topological Sort of");
        topSort(adj, V);
    }
}
