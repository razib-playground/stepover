package graphs;

import java.io.*;
import java.util.*;

public class DfsBfs {

    private static void dfs(List<Set<Integer>> adjacencyList) {

        int nNodes = adjacencyList.size();
        boolean[] visited = new boolean[nNodes];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            Integer u = stack.pop();
            System.out.print((u + 1) + " ");
            Set<Integer> neighbors = adjacencyList.get(u);

            for (Integer v : neighbors) {
                if (!visited[v]) {
                    stack.push(v);
                    visited[v] = true;
                }
            }

        }
        System.out.println();

    }

    private static void bfs(List<Set<Integer>> adjacencyList) {
        int nNodes = adjacencyList.size();
        boolean[] visited = new boolean[nNodes];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {

            int u = queue.poll();
            System.out.print((u + 1) + " ");

            Set<Integer> neighbours = adjacencyList.get(u);
            for (Integer v : neighbours) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
        System.out.println();
    }

    private static void printAdjacencyList(List<Set<Integer>> adjacencyList) {

        int nNodes = adjacencyList.size();

        System.out.println("Adjacency List:");
        for (int i = 0; i < nNodes; i++) {
            Set<Integer> neighbours = adjacencyList.get(i);
            int nNeighbours = neighbours.size();
            int count = 0;
            System.out.printf("%3d : [", (i + 1));
            for (Integer v : neighbours) {
                if (count++ < nNeighbours - 1) System.out.print((v + 1) + " ");
                else System.out.print((v + 1));
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(new File("./resources/DFS-BFS.in.txt")));
        System.setOut(new PrintStream(new File("./resources/DFS-BFS.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        while (T-- > 0) {
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
            printAdjacencyList(adjacencyList);
            System.out.println("DFS traversal output:");
            dfs(adjacencyList);
            System.out.println("BFS traversal output:");
            bfs(adjacencyList);
            System.out.println(".........x.........x.........x.........x.........x.........x.........x.........\n\n");
        }

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

    }
}
