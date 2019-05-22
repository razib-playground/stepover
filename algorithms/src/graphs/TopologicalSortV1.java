package graphs;

import java.io.*;
import java.util.*;

public class TopologicalSortV1 {

    public static void main(String[] args) throws FileNotFoundException {
        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/TopologicalSortV1.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/TopologicalSortV1.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        while (testCase-- > 0) {
            int nNodes = scanner.nextInt();
            int nEdges = scanner.nextInt();
            Map<String, Set<Node>> graph = new HashMap<>();

            for (int i = 0; i < nEdges; i++) {
                String u = scanner.next().toLowerCase();
                String v = scanner.next().toLowerCase();

                if(!graph.containsKey(u)) graph.put(u, new HashSet<>());
                if(!graph.containsKey(v)) graph.put(v, new HashSet<>());

                graph.get(u).add(new Node(v, Integer.MAX_VALUE,0 ));
            }

            //fixing indegree
            for (Set<Node> set : graph.values()) {
                for (Node node : set) {
                    node.inDegree++;
                }
            }
            System.out.print(graph.toString());
        }

        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        scanner.close();
    }

    private static class Node implements Comparable<Node> {
        String name;
        int order;
        int inDegree;

        public Node(String name, int order, int inDegree) {
            this.name = name;
            this.order = order;
            this.inDegree = inDegree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.inDegree, n.inDegree);
        }
    }
}
