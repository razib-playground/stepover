package practices;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Practices2 {


    public static void main(String[] args) throws FileNotFoundException {

        String projectDir = System.getProperty("user.home") + "/projects/stepover/algorithms";
        System.setIn(new FileInputStream(new File(projectDir + "/resources/DfsConnectedCellInAGrid.in.txt")));
        System.setOut(new PrintStream(new File(projectDir + "/resources/DfsConnectedCellInAGrid.out.txt")));
        Scanner scanner = new Scanner(System.in);

        int y = scanner.nextInt();
        int x = scanner.nextInt();
        int[][] matrix = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int biggestRegion = getBiggestRegion(matrix);
        System.out.println(biggestRegion);

        scanner.close();
        System.setIn(new FileInputStream(FileDescriptor.in));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    private static int getBiggestRegion(int[][] matrix) {
        int maxRegionSize = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {
                    int size = getRegionSize(matrix, row, column);
                    maxRegionSize = Math.max(size, maxRegionSize);
                }
            }
        }

        return maxRegionSize;
    }

    private static int getRegionSize(int[][] matrix, int row, int column) {
        if (matrix == null || row < 0 || row >= matrix.length || column < 0 || column >= matrix[row].length) return 0;
        if (matrix[row][column] == 0) return 0;

        matrix[row][column] = 0;
        int size = 1;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r != row || c != column) {
                    size += getRegionSize(matrix, r, c);
                }
            }
        }

        return size;
    }

}