package graphs.hackerrank;

import java.io.*;
import java.util.*;

/**
 * Created by fakrul on 5/4/19.
 * Dijkstra with array/adjacency matrix
 * This approch got time limit exception.
 *
 * Link:https://www.hackerrank.com/challenges/dijkstrashortreach/problem?h_r=profile
 */

@SuppressWarnings("Duplicates")
public class DijkstraShortestReach2 {

    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/DijkstraShortestReach2.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/DijkstraShortestReach2.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int nNodes = scanner.nextInt();
            int nEdges = scanner.nextInt();
            int[][] costs = new int[nNodes][nNodes];

            for (int i = 0; i < nEdges; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                int weight = scanner.nextInt();

                if (costs[u][v] == 0 || (costs[u][v] != 0 && costs[u][v] > weight)) costs[u][v] = weight;
                costs[v][u] = costs[u][v];
            }
            int source = scanner.nextInt() - 1;

            //dijkstra algorithm
            boolean visited[] = new boolean[nNodes];
            int[] distances = new int[nNodes];
            Arrays.fill(distances, Integer.MAX_VALUE);

            distances[source] = 0;
            for (int i = 0; i < nNodes - 1; i++) {

                //finding the vertex of minimum distances of current node
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
                            && distances[j] > distances[index] + costs[index][j]) {
                        distances[j] = distances[index] + costs[index][j];
                    }
                }
            }

            //Printing minimum distances
            for (int i = 0; i < nNodes; i++) {
                if (i != source) {
                    if (distances[i] == Integer.MAX_VALUE) System.out.print("-1 ");
                    else System.out.print(distances[i] + " ");
                }
            }
            System.out.println();
        }

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

}
