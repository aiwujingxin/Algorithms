package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/16 18:25
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
