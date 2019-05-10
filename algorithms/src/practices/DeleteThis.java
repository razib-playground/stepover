package practices;

import java.io.*;
import java.util.*;

public class DeleteThis {

    public static void main(String[] args) throws  FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir+"/resources/Prims.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/Prims.out.txt")));
        Scanner scanner = new Scanner(System.in);


        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
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
        public int hashCode() {
            return String.valueOf(String.valueOf(u).hashCode() + String.valueOf(v).hashCode()
                    + String.valueOf(w).hashCode()).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Edge) {
                Edge e = (Edge) obj;
                if (this == e) return true;
                return (e.u == this.u) && (e.v == this.v) && (e.w == this.w);
            }
            return false;
        }
    }
}
