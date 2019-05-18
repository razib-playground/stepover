package graphs;

/*Implementation of Dijkstra shortest path algorithm using 2d matrix and array
* Complexity:
*   time:
*   space:
*
*  Tutorial Link:
* */

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class DijkstraV1 {

    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/Dijkstra.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/Dijkstra.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        while (testCase-- > 0) {
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
            int source = scanner.nextInt() - 1;

            //dijkstra start
            int[] distances = new int[nNodes];
            boolean[] visited = new boolean[nNodes];
            int[] parents = new int[nNodes];
            Arrays.fill(distances, Integer.MAX_VALUE);

            distances[source] = 0;
            parents[source] = -1;
            /*Remember: in this algorithm 'visited[source] = true' is not set at start of the algorithm
            * */
            for (int i = 0; i < nNodes - 1; i++) {

                //find the unvisited vertex with minimum distance
                int index = 0;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < nNodes; j++) {
                    if (!visited[j] && distances[j] < min) {
                        index = j;
                        min = distances[j];
                    }
                }

                //relaxation: updating the connected(reachable) unvisited node distances based on the new min distance
                visited[index] = true;
                for (int j = 0; j < nNodes; j++) {
                    if (!visited[j] && costs[index][j] != 0 && distances[index] != Integer.MAX_VALUE
                            && distances[j] > (distances[index] + costs[index][j])) {
                        distances[j] = distances[index] + costs[index][j];
                        parents[j] = index;
                    }
                }
            }
            //dijkstra end

            //printing the distances from source
            for (int i = 0; i < nNodes; i++) {
                if (i != source) {
                    if (distances[i] == Integer.MAX_VALUE) System.out.print("-1 ");
                    else System.out.print(distances[i] + " ");
                }
            }
            System.out.println();

            //printing the parent of each node
            //System.out.println(Arrays.toString(parents));
            printPath(parents, nNodes-1);
            System.out.println("\n.........x.........x.........x.........x.........x.........\n");

        }

        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        scanner.close();
    }

    private static void printPath(int[] parents, int index) {
        if (parents[index] == -1) return;
        printPath(parents, parents[index]);
        System.out.print(parents[index] + 1 +" ");
    }
}
