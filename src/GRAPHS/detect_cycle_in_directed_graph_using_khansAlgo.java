package GRAPHS;

import java.util.*;

public class detect_cycle_in_directed_graph_using_khansAlgo {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    static void detCycle(ArrayList<ArrayList<Integer>> adj, int v) {
//        create an array to store inDegree of elemnts
        int[] inDegree = new int[v];

//        update the value of inDegree in array by traversing the array of arraylist
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> adjList = adj.get(i);
            for (int j = 0; j < adjList.size(); j++) {
                int adjVert = adjList.get(j);
//                and update inDegree of adjVert by doing ++
                inDegree[adjVert]++;
            }
        }
//        crete a queue
        Queue<Integer> q = new LinkedList<>();

//        adding all 0 inDegree vertex in Queue
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
//        initialising count variable thht if it doesnt comes equal to v then there is a cycle present
        int count = 0;
//        if q is not empty
        while (!q.isEmpty()) {
            int curr = q.poll();
            ArrayList<Integer> adjList1 = adj.get(curr);
            for (int i=0;i<adjList1.size();i++){
                int adjVert1 = adjList1.get(i);

//          reducing the inDegree of all adjVert
                inDegree[adjVert1]--;

//         if inDegree becomes zero of any vertex add it to the queue
                if (inDegree[adjVert1] == 0){
                    q.add(adjVert1);
                }

            }
//          incrementing the count
            count++;
        }
        if (count != v) {
            System.out.println("There exists a cycle in the graph");
        }
        else{
            System.out.println("There exists no cycle in the graph");
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0, 2);
        addEdge(adj,0, 3);
        addEdge(adj,1, 3);
        addEdge(adj,1, 4);
        addEdge(adj,2, 3);

         detCycle(adj,V);

    }
}
