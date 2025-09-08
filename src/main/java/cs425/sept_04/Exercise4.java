package cs425.sept_04;

import java.util.ArrayList;
import java.util.List;

public class Exercise4 {
    private static boolean isSubSet(int[] arr, int key){
        int n = arr.length + 1;
        boolean[][] dp = new boolean[n][key+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= key; j++){
                if(j - arr[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i-1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n-1][key];
    }

    private static void findSubSet(int[] arr, int key){
        int n = arr.length + 1;
        boolean[][] dp = new boolean[n][key+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= key; j++){
                if(j - arr[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i-1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        int j = key;
        for(int i = n-1; i > 0 && j > 0; i--){
           if(dp[i][j] && !dp[i - 1][j]){
               System.out.println("Included: " + arr[i-1]);
               j -= arr[i-1];
           }
        }

    }
    private static void findAllSubSets(int[] arr, int key){
    }


    public static void main(String[] args) {
        System.out.println(isSubSet(new int[]{3,4,7,8}, 15));
        findSubSet(new int[]{3,4,7,8}, 15);
    }
}
