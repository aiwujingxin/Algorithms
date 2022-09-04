package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-12-12 12:35 上午
 */

public class LeetCode448 {

    public static void main(String[] args) {
        System.out.println(new LeetCode448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new LeetCode448().findDisappearedNumbers(new int[]{1, 1}));
    }


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
