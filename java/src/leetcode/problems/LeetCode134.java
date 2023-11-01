package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 22:00
 */
public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int start = 0;
        for (int i = 0; i < cost.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
            total += gas[i] - cost[i];
        }
        return total >= 0 ? start : -1;
    }
}
