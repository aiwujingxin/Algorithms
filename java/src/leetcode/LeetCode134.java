package leetcode;

/**
 * @author jingxinwu
 * @date 2021-07-10 6:56 下午
 */
public class LeetCode134 {

    //https://www.youtube.com/watch?v=bkXokc5hh14

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int shortage = 0;            //fuel shortage
        int tank = 0;                    //fuel in tank
        int start = 0;                   //starting point

        for (int i = 0; i < gas.length; i++) {

            tank += gas[i] - cost[i];          //calculate the balance at everypoint

            //update fuel shortage and starting point, when it becomes less than 0
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
            shortage += gas[i] - cost[i];
        }

        // if the sum of both >= 0 then we have found the solution
        return shortage >= 0 ? start : -1;
    }

}
