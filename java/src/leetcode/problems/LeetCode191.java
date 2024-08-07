package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 11:29
 */
public class LeetCode191 {

    public int hammingWeight(int i) {
        int c = 0;
        while (i > 0) {
            i -= (i & -i);
            c++;
        }
        return c;
    }
}
