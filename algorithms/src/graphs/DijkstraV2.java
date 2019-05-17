package graphs;

/*Dijkstra using adjacency list of Node and Priority queue
* Complexity:
*   Time:
*   Space:
* */

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class DijkstraV2 {

    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/Dijkstra.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/Dijkstra.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        while (testCase-- > 0) {

            int nNodes = scanner.nextInt();
            int nEdges = scanner.nextInt();

            List<Set<Node>> adjacencyList = new ArrayList<>();
            for (int i = 0; i < nNodes; i++) adjacencyList.add(new HashSet<>());

            for (int i = 0; i < nEdges; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt();

                adjacencyList.get(u).add(new Node(v, w));
                adjacencyList.get(v).add(new Node(u, w));
            }
            int source = scanner.nextInt() - 1;

            //dijkstra start
            int[] distances = new int[nNodes];
            boolean[] visited = new boolean[nNodes];
            int[] parents = new int[nNodes];
            parents[source] = -1;
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[source] = 0;
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

            priorityQueue.add(new Node(source, 0));
            while (!priorityQueue.isEmpty()) {
                Node u = priorityQueue.poll();

                if (!visited[u.value]) {
                    visited[u.value] = true;

                    Set<Node> neighbours = adjacencyList.get(u.value);
                    for (Node v : neighbours) {
                        int relaxedDistance = distances[u.value] + v.cost;
                        if (distances[v.value] > relaxedDistance) {
                            distances[v.value]  = relaxedDistance;
                            priorityQueue.add(new Node(v.value, relaxedDistance));
                            parents[v.value] = u.value;
                        }
                    }
                }

            }
            //dijkstra end

            for (int i = 0; i < nNodes; i++) {
                if (i != source) {
                    System.out.print(( (distances[i]==Integer.MAX_VALUE)? -1 : distances[i]) +" ");
                }
            }
            System.out.println();

            printPath(parents, nNodes-1);
            System.out.println("\n.........x.........x.........x.........x.........x.........\n");
        }

        System.setIn(new FileInputStream(FileDescriptor.out));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        scanner.close();

    }

    private static void printPath(int[] parents, int index) {
        if (parents[index] == -1) return;
        printPath(parents, parents[index]);
        System.out.print(parents[index] + 1 +" ");
    }

    private static class Node implements Comparable<Node> {

        int value;
        int cost;

        Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value &&
                    cost == node.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, cost);
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }
}
