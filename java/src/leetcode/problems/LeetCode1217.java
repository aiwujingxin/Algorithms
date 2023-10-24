package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 23:31
 */
public class LeetCode1217 {

    public int minCostToMoveChips(int[] position) {
        if (position == null || position.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int pos : position) {
            sum += pos;
        }
        int p = sum / position.length;
        int res1 = 0;
        int res2 = 0;
        for (int pos : position) {
            res1 += Math.abs(pos - p) % 2;
        }
        int p1 = sum / position.length + 1;
        for (int pos : position) {
            res2 += Math.abs(pos - p1) % 2;
        }
        return Math.min(res1, res2);
    }

    public int minCostToMoveChips_opt(int[] position) {
        int even = 0, odd = 0;
        for (int pos : position) {
            if ((pos & 1) != 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }
}
