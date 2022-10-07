package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/24 20:12
 */
public class LeetCode134 {

    //study
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }

        int tank = 0;
        int storage = 0;

        int start = 0;
        for (int i = 0; i < gas.length; i++) {

            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
            storage += gas[i] - cost[i];
        }

        return storage >= 0 ? start : -1;


    }
}
