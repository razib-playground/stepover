package graphs;

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by fakrul on 4/21/19.
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

}

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) throws FileNotFoundException{

        System.setIn(new FileInputStream(new File("./resources/BinaryTreeLevelOrderTraversal.in.txt")));
        System.setOut(new PrintStream(new File("./resources/BinaryTreeLevelOrderTraversal.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().value);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
