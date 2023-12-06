package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 13:43
 * <a href="https://www.youtube.com/watch?v=ASNiOCRwTik"></a>
 */
public class LeetCode497 {

    class Solution {

        List<Integer> arr;
        int[][] rects;
        Random rand;

        public Solution(int[][] rects) {
            rand = new Random();
            arr = new ArrayList<>();
            arr.add(0);
            this.rects = rects;
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            int k = rand.nextInt(arr.get(arr.size() - 1));
            int rectIndex = binarySearch(arr, k + 1) - 1;
            k -= arr.get(rectIndex);
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[]{a + da, b + db};
        }

        private int binarySearch(List<Integer> arr, int target) {
            int left = 0, right = arr.size() - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                int num = arr.get(mid);
                if (num == target) {
                    return mid;
                }
                if (num > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
