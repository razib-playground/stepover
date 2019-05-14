package graphs.hackerrank;

import java.io.*;
import java.util.*;

/*Solution with prims*/

import java.io.FileInputStream;

@SuppressWarnings("Duplicates")
public class KruskalMSTReallySpecialSubtreeV1 {

    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms/";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/KruskalMSTReallySpecialSubtreeV1.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/KruskalMSTReallySpecialSubtreeV1.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int nNode = scanner.nextInt();
        int nEdges = scanner.nextInt();
        int source = 1;
        Map<Integer, Set<Edge>> graph = new HashMap<>();

        for (int i = 0; i < nEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            source = Math.min(u, Math.min(v, source));

            if(!graph.containsKey(u)) graph.put(u, new HashSet<>());
            if(!graph.containsKey(v)) graph.put(v, new HashSet<>());

            graph.get(u).add(new Edge(u, v, w));
            graph.get(v).add(new Edge(v, u, w));
        }

        //Prim's Start
        int mstCost = 0;
        boolean[] visited = new boolean[nNode + 1];
        List<Edge> mst = new ArrayList<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.w - e2.w;
            }
        });

        queue.addAll(graph.get(source));
        visited[source]= true;
        while (!queue.isEmpty()) {
            Edge minEdge = queue.poll();

            if(visited[minEdge.u] && visited[minEdge.v]) continue;
            visited[minEdge.u] = true;
            for(Edge otherEdge : graph.get(minEdge.v)){
                if(!visited[otherEdge.v]) queue.add(otherEdge);
            }
            visited[minEdge.v] = true;
            mstCost += minEdge.w;
            mst.add(minEdge);
        }
        //Prims Done

        System.out.println(mstCost);

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
