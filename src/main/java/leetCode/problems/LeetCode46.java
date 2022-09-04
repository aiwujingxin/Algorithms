package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-21 11:42 下午
 */
public class LeetCode46 {

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        List<List<Integer>> list = leetCode46.permute(new int[]{1, 2, 3, 4, 5});

        for (List<Integer> item : list) {
            System.out.print(item);
            System.out.print("  ");
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length) {
            res.add(asList(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(res, nums, index + 1);
            swap(nums, i, index);
        }
    }

    private List<Integer> asList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
