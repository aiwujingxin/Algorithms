package leetcode.problems;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/5 17:42
 */
public class LeetCode528 {
    class Solution {
        int[] presum;

        public Solution(int[] w) {
            presum = new int[w.length];
            presum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                presum[i] = presum[i - 1] + w[i];
            }
        }

        //拉平去看
        //第一个大于等于
        public int pickIndex() {
            int rand = new Random().nextInt(presum[presum.length - 1]) + 1;
            int left = 0;
            int right = presum.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (presum[mid] < rand) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
