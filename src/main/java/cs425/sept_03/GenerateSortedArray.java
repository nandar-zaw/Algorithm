package cs425.sept_03;

import java.util.Arrays;

public class GenerateSortedArray {
    static int[][] generateSortedArrayM1() {
        var result1 = new int[5][5];
        int count = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result1[i][j] = count++;
            }
        }
        return result1;
    }

    public static int[][] generateM2(int n) {
        int[][] matrix = new int[n][n];
        int value = n;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                matrix[i][j] = value++;
            }
        }

        return matrix;
    }


    static int[][] generateSortedArrayM3(int rows) {
        int[][] result3 = new int[rows][rows];
        int count = rows;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < rows; i++) {
                result3[i][j] = count++;
            }
        }
        return result3;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateSortedArrayM1()));
        System.out.println(Arrays.deepToString(generateM2(5)));
        System.out.println(Arrays.deepToString(generateSortedArrayM3(5)));
    }
}
