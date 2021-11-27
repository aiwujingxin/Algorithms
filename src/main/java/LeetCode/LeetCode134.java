package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-07-10 6:56 下午
 */
public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int tank = 0;                    //fuel in tank
        int shortage = 0;            //fuel shortage
        int start = 0;                   //starting point

        for (int i = 0; i < gas.length; i++) {

            tank += gas[i] - cost[i];          //calculate the balance at everypoint

            //update fuel shortage and starting point, when it becomes less than 0
            if (tank < 0) {
                shortage += tank;
                tank = 0;
                start = i + 1;
            }
        }

        // if the sum of both >= 0 then we have found the solution
        return shortage + tank >= 0 ? start : -1;
    }

}
