package leetcode.problems;

import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/27 13:51
 */
public class LeetCode295_treeset {

    //https://leetcode.com/problems/find-median-from-data-stream/solutions/74040/java-10line-one-treeset-ac/
    class MedianFinder {
        private final TreeSet<Double> tset = new TreeSet<>();
        private int n = 0;
        private double mid = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
        }

        public void addNum(int num) {
            double base = 0.00001;
            double newNum = (double) num + base * n;
            tset.add(newNum);
            if (n == 0) {
                mid = newNum;
            } else if (n % 2 == 1) {
                if (newNum < mid) {
                    mid = tset.lower(mid);
                }
            } else if (newNum > mid) {
                mid = tset.higher(mid);
            }
            n++;
        }

        public double findMedian() {
            return (n % 2 == 1) ? (double) (Math.round(mid)) : (double) (Math.round(tset.higher(mid) + mid)) / 2.0;
        }
    }
}
