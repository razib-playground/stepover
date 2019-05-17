package graphs;

/*Dijkstra using Edge, Map*/

import java.io.*;
import java.util.*;

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

            Map<Integer, Set<Edge>> graph = new HashMap<>();
            for (int i = 0; i < nEdges; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();

                if (!graph.containsKey(u)) graph.put(u, new HashSet<>());
                if (!graph.containsKey(v)) graph.put(v, new HashSet<>());

                graph.get(u).add(new Edge(u, v, w));
                graph.get(v).add(new Edge(v, u, w));

            }
            int source = scanner.nextInt();

            PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge e1, Edge e2) {
                    return (e1.w - e2.w);
                }
            });
            boolean[] visited = new boolean[nNodes + 1];
            int[] distances = new int[nNodes + 1];
            Arrays.fill(distances, Integer.MAX_VALUE);
            queue.addAll(graph.get(source));
            visited[source] = true;
            while (!queue.isEmpty()) {
                Edge minEdge = queue.poll();

                for (Edge otherEdge : graph.get(minEdge.v)) {
                    if(!visited[otherEdge.u]) {
                        queue.add(otherEdge);
                    }
                }
                visited[minEdge.v] = true;

            }

        }

        System.setIn(new FileInputStream(FileDescriptor.out));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        scanner.close();

    }


    private static class Edge {

        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return u == edge.u &&
                    v == edge.v &&
                    w == edge.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v, w);
        }
    }
}
