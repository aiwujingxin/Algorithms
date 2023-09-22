package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 15:54
 */
public class LeetCode238 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new LeetCode238().productExceptSelf(new int[]{2, 3, 4, 5})));
        System.out.println(Arrays.toString(new LeetCode238().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] s = new int[nums.length];
        s[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            s[i] = s[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(s));
        int t = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            s[i] = s[i] * t;
            t = t * nums[i];
        }
        return s;
    }
}
