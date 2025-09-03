package cs425;

import com.sun.source.tree.Tree;

import java.util.*;

public class Exercise2 {
    private static void findMax_algo_01(int[] arr) {
        int firstMax = arr[0], secondMax = firstMax, thirdMax = firstMax;
        int firstMaxIndex = 0, secondMaxIndex = 0;
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
        int max = arr[0], preMax = arr[0], prePreMax = arr[0];
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
      for(int i = 0; i < arr.length; i++){
          int maxIndex = i; //0
          for(int j = i+1; j < arr.length; j++){ // 1 to 6
              if(arr[j] > arr[maxIndex])
                  maxIndex = j; //6
          }
          int temp = arr[i]; // temp = 7
          arr[i] = arr[maxIndex]; // arr[0] = 20
          arr[maxIndex] = temp;

      }

        System.out.println("Max: " + arr[0]);
        System.out.println("Pre Max: " + arr[1]);
        System.out.println("Pre Pre Max: " + arr[2]);
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int j : arr) {
//            map.put(j, 1);
//            map.put(j, map.getOrDefault(j, 0) + 1);
//        }
//        for (Integer key : map.descendingKeySet()) {
//            System.out.println(key + " : " + map.get(key));
//            if(map.get(key))
//        }

//        System.out.println("Max: " + max);
    }

    public static void main(String[] args) {
        var dummy = new int[]{7, 18, 20, 20, 19, 17, 3};
//        findMax_algo_01(dummy);
//        findMax_algo_02(dummy);
        findMax_algo_03(dummy);
    }
}
