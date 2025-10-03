package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 8/21/25 16:20
 */
public class LeetCode853 {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double t = (double) (target - cars[i][0]) / cars[i][1];
            while (!stack.isEmpty() && stack.peek() <= t) {
                stack.pop();
            }
            stack.push(t);
        }
        return stack.size();
    }
}
