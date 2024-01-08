package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 16:38
 * why
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
            int n = w.length;
            presum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                presum[i] = presum[i - 1] + w[i - 1];
            }
        }

        public int pickIndex() {
            int n = presum.length;
            int t = (int) (Math.random() * presum[n - 1]) + 1;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (presum[mid] >= t) r = mid;
                else l = mid + 1;
            }
            return l - 1;
        }
    }
}
