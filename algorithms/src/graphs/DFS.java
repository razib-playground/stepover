package graphs;

import java.io.*;
import java.util.*;

public class DFS {

    public static void main(String[] args) throws FileNotFoundException{
        System.setIn(new FileInputStream(new File("./resources/DFS.in.txt")));
        System.setOut(new PrintStream(new File("./resources/DFS.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        while(T-- > 0) {
            int nNodes = scanner.nextInt();
            int nEdges = scanner.nextInt();

            List<Set<Integer>> adjacencyList  = new ArrayList<>();
            for(int i=0; i<nNodes; i++) adjacencyList.add(new HashSet<>());
            for(int i=0; i<nEdges; i++) {
                int u = scanner.nextInt()-1;
                int v = scanner.nextInt()-1;
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }
            printAdjacencyList(adjacencyList);
            System.out.println("DFS traversal output:");
            dfs(adjacencyList);
            System.out.println(".........x.........x.........x.........\n\n");
        }

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

    }

    private static void printAdjacencyList(List<Set<Integer>> list) {
        System.out.println("Adjacency List:");

        int nNodes = list.size();
        for(int i=0; i<nNodes; i++) {
            Set set = list.get(i);
            System.out.printf("%4d: [ ", (i+1));
            for(Object each : set) {
                Integer node = (Integer) each;
                System.out.print((node+1) +" ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    private static void dfs(List<Set<Integer>> adjacencyList) {

        int nNodes = adjacencyList.size();
        boolean[] visited = new boolean[nNodes];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited[0] = true;
        while(!stack.isEmpty()) {
            Integer u = stack.pop();
            System.out.print((u+1) + " ");
            Set<Integer> neighbors = adjacencyList.get(u);

            for(Integer v : neighbors) {
                if(!visited[v]){
                    stack.push(v);
                    visited[v] = true;
                }
            }

        }
        System.out.println();

    }

}
