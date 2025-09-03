package cs425.sept_02;

import java.util.*;

public class Exercise2 {
    private static void findMax_algo_01(int[] arr) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;

        int firstMaxIndex = -1, secondMaxIndex = -1;

        //7, 20, 18, 4, 20, 19, 20, 3.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                firstMax = arr[i];
                firstMaxIndex = i;
            }
        }
        System.out.println("First Max: " + firstMax);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > secondMax && i != firstMaxIndex) {
                secondMax = arr[i];
                secondMaxIndex = i;
            }
        }
        System.out.println("Second Max: " + secondMax);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > thirdMax && i != firstMaxIndex && i != secondMaxIndex) {
                thirdMax = arr[i];
            }
        }
        System.out.println("Third Max: " + thirdMax);
    }

    public static void findMax_algo_02(int[] arr) {
        int max = Integer.MIN_VALUE, preMax = Integer.MIN_VALUE, prePreMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                prePreMax = preMax;
                preMax = max;
                max = arr[i];
            } else if (arr[i] > preMax) {
                prePreMax = preMax;
                preMax = arr[i];
            } else if (arr[i] > prePreMax) {
                prePreMax = arr[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Pre Max: " + preMax);
        System.out.println("Pre Pre Max: " + prePreMax);
    }

    //{7, 18, 20, 20, 19, 17, 3}
    public static void findMax_algo_03(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        int target = 3;

        for (Integer key : map.descendingKeySet()) {
            int freq = map.get(key);
            target -= freq;
            if (target <= 0) {
                System.out.println("Pre Pre Max: " + key);
                break;
            }
        }
    }

    public static void main(String[] args) {
        var dummy = new int[]{7, 18, 19, 20, 17, 3};
        findMax_algo_01(dummy);
        findMax_algo_02(dummy);
        findMax_algo_03(dummy);
    }
}
