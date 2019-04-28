package practices;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Practices {

    private static int[] bfs(int nNodes, int nEdges, List<Set<Integer>> adjacencyList, int source) {
        int[] distances = new int[nNodes];
        Arrays.fill(distances, -1);

        Queue<Integer> queue = new LinkedList<>();
        distances[source] = 0;
        queue.offer(source);
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

    public static void main(String[] args) throws FileNotFoundException {
        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir+"/resources/practices/Practices.in.txt")));
        System.setOut(new PrintStream(new File(projectDir+"/resources/practices/Practices.out.txt")));
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
            int source = scanner.nextInt() - 1;
            int[] distances = new int[nNodes];
            distances = bfs(nNodes, nEdges, adjacencyList, source);

            for (int i = 0; i < distances.length; i++) {
                if (i != source)
                    System.out.print(distances[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

}
