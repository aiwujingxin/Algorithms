package leetcode.problems;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/15 13:20
 * @see LeetCode528
 */
public class LeetCode497 {

    //https://www.youtube.com/watch?v=ASNiOCRwTik

    class Solution {
        TreeMap<Integer, Integer> treeMap;
        int[][] rects;
        int sum;
        Random rand;

        public Solution(int[][] rects) {
            this.rects = rects;
            this.rand = new Random();
            treeMap = new TreeMap<>();
            sum = 0;
            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                // how many points
                // 映射
                sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                treeMap.put(sum, i);
            }
        }

        public int[] pick() {
            //上界 第一个比他大的数
            int c = treeMap.ceilingKey(rand.nextInt(sum) + 1);
            return pickInRect(rects[treeMap.get(c)]);
        }

        private int[] pickInRect(int[] rect) {
            int left = rect[0];
            int right = rect[2];
            int bottom = rect[1];
            int top = rect[3];
            return new int[]{left + rand.nextInt(right - left + 1), bottom + rand.nextInt(top - bottom + 1)};
        }
    }
}
