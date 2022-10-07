package leetcode.topinterview;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/24 19:07
 */
public class LeetCode128 {


    public static void main(String[] args) {
        System.out.println(new LeetCode128().longestConsecutive(new int[]{0, -1}));
    }

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int temp = 0;
                int num = nums[i];
                while (set.contains(num)) {
                    temp++;
                    num++;
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }
}
