package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/14 21:55
 */
public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int res = 0;
        int available = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (available < 0) {
                available = 0;
                res = i;
            }
            available += gas[i] - cost[i];
            total += gas[i] - cost[i];
        }
        return total < 0 ? -1 : res;
    }
}
