package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 23:57
 */
public class LeetCode295_bs {

    //https://leetcode.com/problems/find-median-from-data-stream/discuss/1331261/Java-BinarySearch-solution

    class MedianFinder {
        List<Integer> arr;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            arr = new ArrayList<>();
        }

        public void addNum(int num) {
            int idx = binarySearch(num);
            arr.add(idx, num);
        }

        private int binarySearch(int k) {
            int l = 0;
            int r = arr.size() - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr.get(mid) == k) {
                    return mid;
                } else if (arr.get(mid) < k) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }

        public double findMedian() {
            if (arr.size() % 2 != 0) {
                return arr.get(arr.size() / 2);
            } else {
                int l = arr.get(arr.size() / 2 - 1);
                int r = arr.get(arr.size() / 2);
                return (l + r) / 2.0;
            }
        }
    }
}
