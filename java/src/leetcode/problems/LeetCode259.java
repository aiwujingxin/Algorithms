package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 13:38
 */
public class LeetCode259 {

    public static void main(String[] args) {
        System.out.println(new LeetCode259().search(new int[]{-2, 0, 1, 1, 3}, 0, 4, 1));
        System.out.println(new LeetCode259().threeSumSmaller(new int[]{-2, 0, 1, 3, 1}, 2));
        System.out.println(new LeetCode259().search(new int[]{-2, 0, 1, 1, 3}, 3, 4, 3));

    }

    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int right = search(nums, j + 1, nums.length - 1, target - nums[i] - nums[j]);
                if (right != -1) {
                    res += right - j;
                }
            }
        }
        return res;
    }

    // 最后一个比target小的数
    private int search(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] < target) {
            return left;
        }
        int res = left - 1;
        if (nums[res] < target) {
            return res;
        }
        return -1;
    }
}
