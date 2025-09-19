package cs425.w3_d4;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                // A  B  C  D  E  F  G  H  I
                {0, 1, 1, 0, 0, 1, 0, 0, 0}, // A
                {1, 0, 0, 0, 0, 1, 0, 0, 0}, // B
                {1, 0, 0, 0, 0, 1, 1, 0, 0}, // C
                {0, 0, 0, 0, 1, 0, 0, 0, 1}, // D
                {0, 0, 0, 1, 0, 0, 0, 0, 1}, // E
                {1, 1, 1, 0, 0, 0, 0, 1, 0}, // F
                {0, 0, 1, 0, 0, 0, 0, 1, 0}, // G
                {0, 0, 0, 0, 0, 1, 1, 0, 0}, // H
                {0, 0, 0, 1, 1, 0, 0, 0, 0}  // I
        };

        DFS dfs = new DFS();
        System.out.println("DFS: " + dfs.findComponents(graph));

        BFS bfs = new BFS();
        System.out.println("BFS: " + bfs.findComponents(graph));
    }
}