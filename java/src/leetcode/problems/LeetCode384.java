package leetcode.problems;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/7 20:59
 */
public class LeetCode384 {

    class Solution {

        int[] nums;
        int[] arr;
        Random random = new Random();

        public Solution(int[] nums) {
            this.nums = Arrays.copyOf(nums, nums.length);
            this.arr = nums;
        }

        public int[] reset() {
            return this.nums;
        }

        /**
         * i = 0  [0 n-1]   1/n
         * i = 1  [1 n-1]   (n-1)/n * (1/n-1) = 1 / n  没有被选中 * 选择该下标的概率
         * i = 2  [2 n-3]   (n-1)/n * (n-2)/(n-1) * (1/n-2) = 1 / n
         */
        public int[] shuffle() {
            for (int i = 0; i < nums.length; i++) {
                int rand = i + random.nextInt(arr.length - i);
                swap(arr, i, rand);
            }
            return arr;
        }

        private void swap(int[] arr, int i, int j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
