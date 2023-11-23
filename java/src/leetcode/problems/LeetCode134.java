package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/23 17:33
 */

public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int remain = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            remain += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (remain < 0) {
                start = i + 1;
                remain = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
