package cs425.sept_04;

public class LeetCode70 {
    public int climbStairs(int n) {
        if(n <= 3) return n;
        int prePre = 2;
        int pre = 3;

        for(int i = 4; i <= n; i++){
            int temp = prePre + pre;
            prePre = pre;
            pre = temp;
        }
        return pre;
    }
}
