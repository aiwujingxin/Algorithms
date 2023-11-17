package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023.11.17 22:29
 */
public class LeetCode346 {


    class MovingAverage {
        Queue<Integer> queue = new LinkedList<>();
        double sum = 0;

        int size = 0;

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() == size) {
                int node = queue.poll();
                sum -= node;
            }
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
    }
}
