package cs425.sept_03;

public class Exercise3 {
    public static void searchSS(int[][] M, int key) {
        int n = M.length;
        int row = 0, col = n - 1;
        while (row < n - 1 && col >= 0) {
            if (M[row][col] == key) {
                System.out.println("(" + row + "," + col + ")");
                return;
            } else if (M[row][col] > key)
                col--;
            else {
                row++;
            }
        }
        System.out.println("Not found");
    }

    public static void dacSearchSS(int[][] M, int key) {
        int n = M.length;
        int left = 0, right = n - 1;

        if (!binarySearchSS(M, left, right, left, right, key)) {
            System.out.println("Not found");
        }
        //mid == key
        //if(a[i] < key then left = mid +1
        //else right = mid - 1
        //in 2d matrix, when we find mid
        //divide into four parts
    }

    public static boolean binarySearchSS(int[][] M, int rowStart, int rowEnd, int colStart, int colEnd, int key) {
        if (rowStart > rowEnd || colStart > colEnd) {
            //base case
            return false;
        }

        int midRow = (rowStart + rowEnd) / 2;
        int midCol = (colStart + colEnd) / 2;

        if (M[midRow][midCol] == key) {
            System.out.println("(" + midRow + "," + midCol + ")");
            //another base case
            return true;
        }

        if (M[midRow][midCol] < key) { // key is bigger so discard top-left
            return binarySearchSS(M, rowStart, midRow, midCol + 1, colEnd, key) ||//top right
                    binarySearchSS(M, midRow + 1, rowEnd, colStart, midCol, key) || //bottom left
                    binarySearchSS(M, midRow + 1, rowEnd, midCol + 1, colEnd, key); //bottom right
        } else { // key is smaller so discard right-bottom
            return binarySearchSS(M, rowStart, midRow - 1, colStart, midCol - 1, key) || // top left
                    binarySearchSS(M, rowStart, midRow - 1, midCol, colEnd, key) || // top right
                    binarySearchSS(M, midRow, rowEnd, colStart, midCol - 1, key); //bottom left
        }
    }


    public static void main(String[] args) {
        int[][] M = {{5, 7, 8, 14},
                {6, 9, 13, 16},
                {10, 12, 17, 22},
                {11, 18, 21, 25}};
//        searchSS(M, 17);
        dacSearchSS(M, 26);
    }
}
