package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 15:10
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            if (sum < target) {
                int val = numbers[l];
                while (l < r && numbers[l] == val) l++;
            } else {
                int val = numbers[r];
                while (l < r && numbers[r] == val) r--;
            }
        }
        return new int[]{};
    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                }
                if (sum < target) {
                    // 需要增大左值，在 [left + 1, right] 中找第一个 >= target - numbers[right] 的位置
                    int need = target - numbers[right];
                    left = findL(numbers, left + 1, right, need);
                } else {
                    // 需要减小右值，在 [left, right - 1] 中找最后一个 <= target - numbers[left] 的位置
                    int need = target - numbers[left];
                    right = findR(numbers, left, right - 1, need);
                }
            }

            return new int[0];
        }

        // 在闭区间 [left, right] 中找第一个 >= target 的位置
        private int findL(int[] nums, int left, int right, int target) {
            while (left < right) {
                int mid = (left + right) >> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        // 在闭区间 [left, right] 中找最后一个 <= target 的位置
        private int findR(int[] nums, int left, int right, int target) {
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        }
    }
}
