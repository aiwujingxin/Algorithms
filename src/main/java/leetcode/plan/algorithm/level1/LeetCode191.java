package leetcode.plan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/17 23:44
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;

    }
}
