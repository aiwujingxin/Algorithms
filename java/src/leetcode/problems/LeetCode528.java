package leetcode.problems;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/5 17:42
 */
public class LeetCode528 {
    //https://www.youtube.com/watch?v=KYmlcich2_k&t=228s
    class Solution {

        int[] presum;
        int[] w;

        public Solution(int[] w) {
            this.w = w;
            presum = new int[w.length];
            presum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                presum[i] = presum[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            int rand = new Random().nextInt(presum[presum.length - 1]) + 1;
            int index = Arrays.binarySearch(presum, rand);
            if (index < 0) {
                index = -(index + 1);
            }
            return index;
        }
    }

}
