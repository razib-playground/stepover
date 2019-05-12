package practices;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class DeleteThis {

    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/Prims.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/Prims.out.txt")));
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

                if (graph.get(u).add(new Edge(u, v, w))) ;
                if (graph.get(v).add(new Edge(v, u, w))) ;
            }
            int source = scanner.nextInt();

            //Prim's Algorithm Start
            boolean[] visited = new boolean[nNodes + 1];
            int mstCost = 0;
            List<Edge> mst = new ArrayList<>();
            PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge e1, Edge e2) {
                    return e1.w - e2.w;
                }
            });

            queue.addAll(graph.get(source));
            visited[source] = true;
            while (!queue.isEmpty()) {
                Edge minEdge = queue.poll();

                if(visited[minEdge.u] && visited[minEdge.v]) continue;
                visited[minEdge.u] = true;
                for (Edge otherEdge : graph.get(minEdge.v)) {
                    if (!visited[otherEdge.v]) {
                        queue.add(otherEdge);
                    }
                }
                visited[minEdge.v] = true;
                mstCost += minEdge.w;
                mst.add(minEdge);
            }
            //Prim's done

            System.out.println(mstCost);
            for (Edge e : mst) {
                System.out.println(e.u + "-" + e.v + ":" + e.w);
            }
            System.out.println(".........x.........x.........x.........x.........x.........\n");

        }

        System.setIn(new FileInputStream(FileDescriptor.in));
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
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            if (this == obj) return true;

            Edge that = (Edge) obj;
            return (this.u == that.u) && (this.v == that.v) && (this.w == that.w);
        }

        @Override
        public int hashCode() {
            return String.valueOf(String.valueOf(u).hashCode() + String.valueOf(v).hashCode() + String.valueOf(w))
                    .hashCode();
        }
    }
}
