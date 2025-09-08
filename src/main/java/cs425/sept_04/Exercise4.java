package cs425.sept_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise4 {
//    private static boolean isSubSet(int[] arr, int key) {
//        int n = arr.length + 1;
//        boolean[][] dp = new boolean[n][key + 1];
//
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = true;
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j <= key; j++) {
//                if (j - arr[i - 1] >= 0)
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//        return dp[n - 1][key];
//    }

    static boolean subsetSumExists(int[] arr, int k) {
        int n = arr.length;
        boolean[] prev = new boolean[k + 1];
        boolean[] curr = new boolean[k + 1];

        prev[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j >= arr[i - 1]) {
                    curr[j] = prev[j] || prev[j - arr[i - 1]];
                    if (curr[j] && j == k) return true;
                } else {
                    curr[j] = prev[j];
                }
            }
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[k];
    }


    private static void findOneSubsetSum(int[] arr, int key) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][key + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= key; j++) {
                if (j - arr[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        if (!dp[n][key]) {
            System.out.println("No subset found");
            return;
        }

        List<Integer> oneSubset = new ArrayList<>();

        int j = key;
        for (int i = n; i > 0 && j > 0; i--) {
            if (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]]) {
                oneSubset.add(arr[i - 1]);
                j -= arr[i - 1];
            }
        }

        System.out.println("Print One subset : " + oneSubset);
    }

    private static void findAllSubSets(int[] arr, int key) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][key + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= key; j++) {
                if (j - arr[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        if (!dp[n][key]) {
            System.out.println("No subset found");
            return;
        }

        List<Integer> allSubset = new ArrayList<>();
        backtracking(dp, arr, n, key, allSubset);
    }

    public static void backtracking(boolean[][] dp, int[] arr, int i, int j, List<Integer> subset) {
        if (j == 0) {
            System.out.println(subset);
            return;
        }

        if (i == 0) return;

        if (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]]) {
            subset.add(arr[i - 1]);
            backtracking(dp, arr, i - 1, j - arr[i - 1], subset);
            subset.removeLast();
        }

        if (dp[i - 1][j]) {
            backtracking(dp, arr, i - 1, j, subset);
        }
    }

    public static void main(String[] args) {
        System.out.println("Does One subset : " + subsetSumExists(new int[]{3, 4, 7, 8}, 15));
        findOneSubsetSum(new int[]{3, 4, 7, 8}, 15);
        System.out.println("All subsets : ");
        findAllSubSets(new int[]{3, 4, 7, 8}, 15);
    }
}
