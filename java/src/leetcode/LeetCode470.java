package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/28 00:55
 */
public class LeetCode470 {
    private static class SolBase {
        int rand7() {
            return -1;
        }
    }

    class Solution extends SolBase {
        public int rand10() {
            int v1 = rand7();
            int v2 = rand7();

            while (v1 > 5) v1 = rand7();
            while (v2 == 7) v2 = rand7();

            return v2 <= 3 ? v1 : v1 + 5;
        }
    }
}
