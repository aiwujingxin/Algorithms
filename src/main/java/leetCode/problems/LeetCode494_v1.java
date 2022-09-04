package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-25 10:22 PM
 */
public class LeetCode494_v1 {

    public static void main(String[] args) {
        System.out.println(new LeetCode494_v1().findTargetSumWays(
                new int[]{44, 20, 38, 6, 2, 47, 18, 50, 41, 38, 32, 24, 38, 38, 30, 5, 26, 15, 37, 35}, 44));
    }

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<List<Integer>> list = new ArrayList<>();
        helpr(new int[]{-1, 1}, nums, 0, 0, list, target);

        return count;
    }

    public void helpr(int[] arr, int[] nums, int index, int sum, List<List<Integer>> list, int target) {
        if (sum == target) {
            count++;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            helpr(arr, nums, index + 1, sum + nums[i], list, target);
            helpr(arr, nums, index + 1, sum - nums[i], list, target);
        }
    }

}
