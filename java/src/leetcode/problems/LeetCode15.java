package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 15:13
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int t = nums[i] + nums[left] + nums[right];
                if (t == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    res.add(l);
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                } else if (t < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
