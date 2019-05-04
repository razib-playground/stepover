package graphs.hackerrank;

import java.io.*;
import java.util.*;

/**
 * Created by fakrul on 5/4/19.
 */

public class DijkstraShortestReach2 {

    private static int nNodes;
    private static int nEdges;

    public static void main(String[] args) throws FileNotFoundException {
        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms/";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/DijkstraShortestReach2.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/DijkstraShortestReach2.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        while (tests-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                int r = scanner.nextInt();
                if (a[x][y] == 0 || (a[x][y] != 0 && a[x][y] > r))
                    a[x][y] = r;
                a[y][x] = a[x][y];
            }
            int s = scanner.nextInt() - 1;

            int[] d = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++)
                d[i] = Integer.MAX_VALUE;

            d[s] = 0;
            for (int i = 0; i < n; i++) {
                //find min distance in visited
                int index = 0;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++)
                    if (v[j] == 0 && d[j] <= min) {
                        index = j;
                        min = d[j];
                    }

                v[index] = 1;
                for (int j = 0; j < n; j++)
                    if (v[j] == 0 && a[index][j] != 0 &&
                            d[index] != Integer.MAX_VALUE && d[j] > d[index] + a[index][j])
                        d[j] = d[index] + a[index][j];

            }

            for (int i = 0; i < n; i++)
                if (d[i] == Integer.MAX_VALUE)
                    d[i] = -1;

            for (int i = 0; i < n; i++)
                if (i != s)
                    System.out.print(d[i] + " ");
            System.out.println();
        }

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

}
