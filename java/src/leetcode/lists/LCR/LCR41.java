package leetcode.lists.LCR;

import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:15
 */
public class LCR41 {

    class MovingAverage {

        LinkedList<Integer> list;
        int sum;
        int size;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.list = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            if (list.size() == size) {
                int d = list.removeFirst();
                sum -= d;
            }
            list.add(val);
            sum += val;
            return (double) sum / list.size();
        }
    }

}
