package graphs.codeforces;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class C_DijkstraV2 {

    public static int[] parents;

    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/C_Dijkstra.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/C_Dijkstra.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int nNodes = scanner.nextInt();
        int nEdges = scanner.nextInt();
        parents = new int[nNodes];

        List<HashSet<Node>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < nNodes; i++) adjacencyList.add(new HashSet<>());

        for (int i = 0; i < nEdges; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt();

            adjacencyList.get(u).add(new Node(v, w));
            adjacencyList.get(v).add(new Node(u, w));
        }

        //dijkstra start
        long[] distances = new long[nNodes];
        boolean[] visited = new boolean[nNodes];

        Arrays.fill(distances, Long.MAX_VALUE);
        Arrays.fill(parents, -1);
        parents[0] = -1;
        distances[0] = -1;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {

            Node u = queue.poll();
            if (!visited[u.value]) {
                Set<Node> neighbours = adjacencyList.get(u.value);
                for (Node v : neighbours) {
                    long relaxedDistance = distances[u.value] + v.cost;
                    if (distances[v.value] > relaxedDistance) {
                        distances[v.value] = relaxedDistance;
                        parents[v.value] = u.value;
                        queue.add(new Node(v.value, relaxedDistance));
                    }
                }
                visited[u.value] = true;
            }
        }
        //dijkstra end

        if (parents[nNodes-1] == -1) System.out.println("-1 ");
        else {
            System.out.print("1 ");
            printPath(nNodes-1);
        }
        System.out.println();

        System.setIn(new FileInputStream(FileDescriptor.out));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        scanner.close();

    }

    private static void printPath(int index) {
        if (parents[index]!=-1) {
            printPath(parents[index]);
            System.out.print((index+1) +" ");
        }
    }

    private static class Node implements Comparable<Node> {
        int value;
        long cost;

        public Node(int value, long cost) {
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
        public int compareTo(Node n) {
            return Long.compare(this.cost, n.cost);
        }
    }
}
