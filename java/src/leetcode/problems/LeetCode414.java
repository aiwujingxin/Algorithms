package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 17:44
 */
public class LeetCode414 {

    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        nums = new int[set.size()];
        int index = 0;
        for (int n : set) {
            nums[index] = n;
            index++;
        }
        int res = findKthLargest(nums, 3);
        if (nums.length < 3) {
            return nums[0];
        }
        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        return topK(nums, 0, nums.length - 1, k);
    }

    private int topK(int[] nums, int i, int j, int k) {
        if (i > j) {
            return -1;
        }
        int index = partition(nums, i, j);
        if (index + 1 == k) {
            return nums[index];
        }
        if (index + 1 < k) {
            return topK(nums, index + 1, j, k);
        }
        return topK(nums, i, index - 1, k);
    }


    private int partition(int[] nums, int i, int j) {
        int pi = nums[i];
        while (i < j) {
            while (i < j && nums[j] <= pi) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] >= pi) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }
}
