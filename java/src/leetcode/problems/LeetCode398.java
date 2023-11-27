package leetcode.problems;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 23:34
 * @description 水塘抽样
 */
public class LeetCode398 {

    class Solution {
        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int pick(int target) {
            int ans = 0;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    cnt++;
                    if (random.nextInt(cnt) == 0) {//发生概率为 1/cnt
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }
}
