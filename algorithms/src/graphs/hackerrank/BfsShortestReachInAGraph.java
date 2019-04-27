package graphs.hackerrank;

import java.io.*;
import java.util.*;

/*
Link: https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
Hints: BFS ensure that any node of next level will be reach only after you process all nodes of it's earlier level.
 */
public class BfsShortestReachInAGraph {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/BfsShortestReachInAGraph.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/BfsShortestReachInAGraph.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        while (q-- > 0) {
            int nNodes = scanner.nextInt();
            int nEdges = scanner.nextInt();

            List<Set<Integer>> adjacencyList = new ArrayList<>();
            for (int i = 0; i < nNodes; i++) adjacencyList.add(new HashSet<>());
            for (int i = 0; i < nEdges; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }

            int source = scanner.nextInt()-1;
            //int[] distances = new int[nNodes];
            int[] distances = bfs(adjacencyList, source);

            for(int i=0; i<distances.length; i++) {
                if(i==source) continue;
                else System.out.print(distances[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

    }

    @SuppressWarnings("Duplicates")
    private static int[] bfs(List<Set<Integer>> adjacencyList, int source) {
        int nNodes = adjacencyList.size();
        int[] distances = new int[nNodes];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        distances[source] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            Set<Integer> neighbours = adjacencyList.get(u);

            for (Integer v : neighbours) {
                if (distances[v] == -1) {
                    queue.offer(v);
                    distances[v] = distances[u] + 6;
                }
            }
        }

        return distances;
    }
}
