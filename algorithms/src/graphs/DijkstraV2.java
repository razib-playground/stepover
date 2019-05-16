package graphs;

/*Dijkstra using Edge, Map*/

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class DijkstraV2 {

    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/Dijkstra.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "resources/Dijkstra.out.txt")));
        Scanner scanner = new Scanner(System.in);

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
