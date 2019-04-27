package practices;

import java.io.*;
import java.util.*;

public class Practices2 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws FileNotFoundException {
        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/practices/Practices2.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/practices/Practices2.out.txt")));
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

            System.out.println("Adjacency list: ");
            printAdjacencyList(adjacencyList);
            System.out.println("DFS traversal output: ");
            dfs(adjacencyList);
            System.out.println("BFS traversal output: ");
            bfs(adjacencyList);
            System.out.println(".................x.................x.................x.................\n");

        }

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    private static void printAdjacencyList(List<Set<Integer>> adjacencyList) {

        int nNodes = adjacencyList.size();
        for (int i = 0; i < nNodes; i++) {

            System.out.printf("%3d : [", (i + 1));
            Set<Integer> neighbours = adjacencyList.get(i);

            int size = neighbours.size();
            int count = 0;
            for (Integer v : neighbours) {
                count++;
                System.out.print((v + 1));
                if (count < (size)) System.out.print(" ");
            }
            System.out.println("]");
        }
    }

    private static void bfs(List<Set<Integer>> adjacencyList) {

        int nNodes = adjacencyList.size();
        boolean[] visited = new boolean[nNodes];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print((u + 1) + "");
            Set<Integer> neighbours = adjacencyList.get(u);

            for (Integer v : neighbours) {
                if (!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
        System.out.println();

    }

    private static void dfs(List<Set<Integer>> adjacencyList) {

        int nNodes = adjacencyList.size();
        boolean[] visited = new boolean[nNodes];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print((u + 1) + " ");
            Set<Integer> neighbours = adjacencyList.get(u);

            for (Integer v : neighbours) {
                if (!visited[v]) {
                    stack.push(v);
                    visited[v] = true;
                }
            }
        }
        System.out.println();

    }
}