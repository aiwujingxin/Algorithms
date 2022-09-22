package leetcode.topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 00:17
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //fix
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);

                    while (left < nums.length - 1 && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                    while (right > 0 && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}
