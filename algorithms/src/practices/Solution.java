package practices;

import java.io.*;
import java.util.*;

/**
 * Created by fakrul on 5/4/19.
 */

public class Solution {

    private static int nNodes;
    private static int nEdges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        while (tests-- > 0) {
            int nNodes = scanner.nextInt();
            int nEdges = scanner.nextInt();
            int[][] a = new int[nNodes][nNodes];
            for (int i = 0; i < nEdges; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                int r = scanner.nextInt();
                if (a[x][y] == 0 || (a[x][y] != 0 && a[x][y] > r)) a[x][y] = r;
                a[y][x] = a[x][y];
            }
            int source = scanner.nextInt() - 1;

            int[] distances = new int[nNodes];
            int[] visited = new int[nNodes];
            Arrays.fill(distances, Integer.MAX_VALUE);

            distances[source] = 0;
            for (int i = 0; i < nNodes; i++) {
                //find min distance in visited
                int index = 0;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < nNodes; j++)
                    if (visited[j] == 0 && distances[j] < min) {
                        index = j;
                        min = distances[j];
                    }

                visited[index] = 1;
                for (int j = 0; j < nNodes; j++)
                    if (visited[j] == 0 && a[index][j] != 0 &&
                            distances[index] != Integer.MAX_VALUE && distances[j] > distances[index] + a[index][j])
                        distances[j] = distances[index] + a[index][j];

            }

            for (int i = 0; i < nNodes; i++){
                if (i != source){
                    if(distances[i] == Integer.MAX_VALUE) System.out.print("-1 ");
                    else System.out.print(distances[i] + " ");
                }

            }
            System.out.println();
        }

        scanner.close();

    }

}
