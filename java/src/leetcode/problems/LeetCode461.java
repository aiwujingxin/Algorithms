package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 17:44
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += ((x >> i & 1) ^ (y >> i & 1));
        }
        return cnt;
    }
}
