package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 01:07
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();

        dfs(list, nums, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, int[] nums, int index) {
        if (index == nums.length) {
            list.add(adList(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            dfs(list, nums, i);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    private List<Integer> adList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
