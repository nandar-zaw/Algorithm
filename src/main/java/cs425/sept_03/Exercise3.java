package cs425.sept_03;

public class Exercise3 {
    public static void searchSS(int[][] M,int key){
        int n = M.length;
        int row = 0, col = n -1;
        while(row < n-1 && col >= 0){
            if(M[row][col] == key){
                System.out.println("(" + row + "," + col +")");
                return;
            }else if(M[row][col] > key)
                col--;
            else{
                row++;
            }
        }
        System.out.println("Not found");
    }


    public static void main(String[] args) {
        int[][] M = {{5,7,8,14,15},
                {6,9,13,16,23},
                {10,12,17,22,24},
                {11,18,21,25,28},
                {19,20,26,27,29}};
        searchSS(M, 34);

    }
}
