package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-18 1:53 PM
 */
public class LeetCode334 {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;

    }
}
