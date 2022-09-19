package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 14:09
 */
public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        for (int n : nums) {
            if (nums[Math.abs(n) - 1] > 0) {
                nums[Math.abs(n) - 1] = -1 * nums[Math.abs(n) - 1];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
