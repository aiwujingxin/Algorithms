package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/17 20:25
 */
public class LeetCode1701 {

    public double averageWaitingTime(int[][] customers) {
        if (customers == null || customers.length == 0) {
            return 0;
        }
        double time = customers[0][1];
        int finishTime = customers[0][0] + customers[0][1];
        for (int i = 1; i < customers.length; i++) {
            if (customers[i][0] < finishTime) {
                time += finishTime + customers[i][1] - customers[i][0];
                finishTime += customers[i][1];
            } else {
                time += customers[i][1];
                finishTime = customers[i][0] + customers[i][1];
            }
        }
        return time / customers.length;
    }
}
