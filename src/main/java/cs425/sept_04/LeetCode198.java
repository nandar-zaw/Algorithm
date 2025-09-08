package cs425.sept_04;

public class LeetCode198 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int prePre = nums[0];
        int pre = Math.max(prePre, nums[1]);
        int total = 0;

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(prePre + nums[i], pre);
            prePre = pre;
            pre = temp;
        }

        return pre;
    }
}
