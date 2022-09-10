package GRAPHS;

import java.util.*;
import java.util.LinkedList;

public class shortest_path_in_unweighted_graph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void shortestPath(ArrayList<ArrayList<Integer>> adj, int v, int s, int[] dist) {
//creating isVisited array and a queue
        boolean[] isVisited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
//        add the source vertex in queue and mark it true
        q.add(s);
        isVisited[s] = true;

//        now if queue is not empty
        while (!q.isEmpty()) {
//            pop out the first element
            int curr = q.poll();
//            traversing the array of array list
            ArrayList<Integer> adjList = adj.get(curr);
            for (int i = 0; i < adjList.size(); i++) {
                int adjVert = adjList.get(i);

//                if adjVert is not visited
                if (!isVisited[adjVert]) {
//                    update the dist of adjVert by adding 1 to curr dist
                    dist[adjVert] = dist[curr] + 1;
//                    mark it as true and add it to the queue
                    isVisited[adjVert] = true;
                    q.add(adjVert);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        shortestPath(adj, V, 0, dist);

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        shortestPath(adj, V, 0, dist);
    }
}
