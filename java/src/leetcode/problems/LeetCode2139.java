package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/8 16:04
 */
public class LeetCode2139 {

    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (target > 1) {
            if (maxDoubles == 0) {
                return ans + target - 1;
            }
            if (target % 2 != 0) {
                target = target - 1;
                ans++;
            }
            maxDoubles--;
            target = target / 2;
            ans++;
        }
        return ans;
    }
}
