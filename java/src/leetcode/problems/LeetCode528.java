package leetcode.problems;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 16:38
 */
public class LeetCode528 {

    /*
    * nums   [1    ,2,     3,     4]
      presum [1,    3,     6,     10]
      控制   [[1], [2-3], [3-6], [7-10]]
    * random [1-10]
    * */
    class Solution {
        int[] presum;

        public Solution(int[] w) {
            presum = new int[w.length];
            presum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                presum[i] = presum[i - 1] + w[i];
            }
        }

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
