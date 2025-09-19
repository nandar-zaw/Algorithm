package cs425.w3_d4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static int findComponents(int[][] matrix) {
        int componentCount = 0;
        int n = matrix.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                visited[i] = true;
                stack.push(i);
                while (!stack.isEmpty()) {
                    int v = stack.peek();
                    boolean foundUnvisited = false;
                    for (int j = 0; j < n; j++) {
                        if (matrix[v][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            stack.push(j);
                            foundUnvisited = true;
                            break;
                        }
                    }

                    if (!foundUnvisited) {
                        stack.pop();
                    }
                }

                componentCount++;
            }
        }

        return componentCount;
    }
}
