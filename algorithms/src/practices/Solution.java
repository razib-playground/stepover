package practices;

import java.io.*;
import java.util.*;

/**
 * Created by fakrul on 5/4/19.
 */

@SuppressWarnings("Duplicates")
public class Solution {

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

            int[] distances = new int[nNodes];
            boolean[] visited = new boolean[nNodes];

            distances[source] = 0;
            for (int i = 0; i < nNodes - 1; i++) {

                //finding the vertex of minimum distances from current node
                int index = 0;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < nNodes; j++) {
                    if (!visited[j] && distances[j] < min) {
                        index = j;
                        min = distances[j];
                    }
                }

                visited[index] = true;
                for (int j = 0; j < nNodes; j++) {
                    if (costs[index][j] != 0 && !visited[j] && distances[index] != Integer.MAX_VALUE
                            && distances[j] >(distances[index] + costs[index][j])) {
                        distances[j] = distances[index] + costs[index][j];
                    }
                }

            }

            //printing distances according to nodes order
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
