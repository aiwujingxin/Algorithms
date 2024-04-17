package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/30 10:26
 */
public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int remain = 0;
        int res = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            remain += gas[i] + cost[i];
            if (remain < 0) {
                res = i;
                remain = 0;
            }
            total += gas[i] + cost[i];
        }
        return total >= 0 ? res : -1;
    }
}
