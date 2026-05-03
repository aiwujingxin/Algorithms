package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 4/23/26 23:24
 */
public class LeetCode3776 {

    public long minMoves(int[] balance) {
        int n = balance.length;
        int negIndex = -1;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += balance[i];
            if (balance[i] < 0) {
                negIndex = i;
            }
        }
        if (totalSum < 0) return -1;
        if (negIndex == -1) return 0;
        int target = balance[negIndex];
        long moves = 0, dist = 1;
        int left = (negIndex - 1 + n) % n;
        int right = (negIndex + 1) % n;
        while (target < 0) {
            if (balance[left] > 0) {
                int take = Math.min(balance[left], -target);
                target += take;
                moves += take * dist;
            }
            if (target > 0 && left != right && balance[right] > 0) {
                int take = Math.min(balance[right], -target);
                target += take;
                moves += take * dist;
            }
            left = (left - 1 + n) % n;
            right = (right + 1) % n;
            dist++;
        }
        return moves;
    }
}
