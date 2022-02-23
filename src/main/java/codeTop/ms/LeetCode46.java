package codeTop.ms;


import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-16 2:51 PM
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        helper(list, nums, 0);
        return list;
    }

    private void helper(List<List<Integer>> list, int[] nums, int index) {

        if (index == nums.length) {
            list.add(asList(nums));
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(list, nums, index + 1);
            swap(nums, i, index);
        }
    }


    //fix 用交换的方法
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private List<Integer> asList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
