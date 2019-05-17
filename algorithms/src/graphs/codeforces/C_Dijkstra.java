package graphs.codeforces;

import java.io.*;
import java.util.*;

/**
 * Created by fakrul on 5/5/19.
 * Link: http://codeforces.com/contest/20/problem/C
 * Memory limit exceed error
 */

@SuppressWarnings("Duplicates")
public class C_Dijkstra {

    public static void main(String[] args) throws FileNotFoundException {
        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/C_Dijkstra.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/C_Dijkstra.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int nNodes = scanner.nextInt();
        int nEdges = scanner.nextInt();
        int[][] costs = new int[nNodes][nNodes];

        for (int i = 0; i < nEdges; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt();

            if (costs[u][v] == 0 || (costs[u][v] != 0 && costs[u][v] > w)) costs[u][v] = w;
            costs[v][u] = costs[u][v];
        }

        //dijkstra algorithm
        int[] distances = new int[nNodes];
        int[] parents = new int[nNodes];
        boolean[] visited = new boolean[nNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        distances[0] = 0;
        for (int i = 0; i < nNodes - 1; i++) {

            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < nNodes; j++) {
                if (!visited[j] && distances[j] < min) {
                    min = distances[j];
                    index = j;
                }
            }

            visited[index] = true;
            for (int j = 0; j < nNodes; j++) {
                if (costs[index][j] != 0 && !visited[j] && distances[index] != Integer.MAX_VALUE
                        && distances[j] > (distances[index] + costs[index][j])) {
                    distances[j] = distances[index] + costs[index][j];
                    parents[j] = index;
                }
            }
        }
        //System.out.println(Arrays.toString(parents));
        if(parents[nNodes-1]==-1) System.out.println("-1 ");
        else {
            System.out.print("1 ");
            printPath(parents, nNodes-1);
        }

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    public static void printPath(int parent[], int j) {
        if (parent[j] == -1) {
            return;
        }
        printPath(parent, parent[j]);
        System.out.printf("%d ", j+1);
    }
}
