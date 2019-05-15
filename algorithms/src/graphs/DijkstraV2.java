package graphs;

/*Dijkstra using Edge, Map*/

import java.util.Objects;

public class DijkstraV2{

    public static void main(String[] args) {

    }

    private static class Edge{

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
