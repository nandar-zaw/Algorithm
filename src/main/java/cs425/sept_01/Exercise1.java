package cs425;

public class Exercise1 {
    private int is123Array(int[] arr) {
        int divisible = 0; int not_divisible = 0;
        for(int i=0; i < arr.length; i++){
            if(arr[i] % 2 == 0)
                divisible++;
            if (arr[i] % 3 == 0)
                divisible++;
            if (arr[i] % 5 == 0)
                divisible++;
            if(arr[i] % 2 != 0 && arr[i] % 3 != 0 && arr[i] % 5 != 0)
                not_divisible++;
        }
        if(divisible + not_divisible == arr.length)
            return 1;
        else
            return 0;
    }

    private int is123Array_flip(int[] arr) {
        for(int n: arr) {
//            if((n % 2 == 0 && n % 3 == 0) ||
//                    (n % 3 == 0 && n % 5 == 0) ||
//                    (n % 2 == 0 && n % 5 == 0))
            if (n % 6 == 0 || n % 15 == 0 || n % 10 == 0)
                return 0;
            else
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Exercise1 ex1 = new Exercise1();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr_01 = {81,13,7,2,4,9,8,5};
        System.out.println(ex1.is123Array(arr_01));
        System.out.println(ex1.is123Array(arr_01));
    }

}
