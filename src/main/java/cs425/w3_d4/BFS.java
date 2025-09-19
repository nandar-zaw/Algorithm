package cs425.w3_d4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static int findComponents(int[][] graph){
        int n = graph.length;
        int components = 0;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        //loop over all nodes
        for(int start = 0; start < n; start ++){
            // run BFS for each unvisited node
            if(visited[start] == -1){
                visited[start] = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                components++;

                //visit all nodes in a component
                while (!queue.isEmpty()){
                    int v = queue.remove();
                    for(int k = 0; k < n; k++ ){
                        int w = graph[v][k];
                        if(w == 1 && visited[k] == -1){
                            queue.add(k);
                            visited[k] = 0;
                        }
                    }

                }

            }

        }

        return components;
    }
}
