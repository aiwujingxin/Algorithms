package codeTop.ms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-16 8:07 PM
 */
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();

        helper(list, 0, nums);
        return list;
    }

    private void helper(List<List<Integer>> list, int index, int[] nums) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            list.add(new ArrayList<>(temp));
            return;
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);

            swap(nums, i, index);
            helper(list, index + 1, nums);
            swap(nums, i, index);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
