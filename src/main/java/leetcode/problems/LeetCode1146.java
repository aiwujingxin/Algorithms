package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/9 21:23
 */
public class LeetCode1146 {

    class SnapshotArray {

        int count = 0;

        List<int[]>[] list;

        public SnapshotArray(int length) {
            list = new ArrayList[length];
            for (int i = 0; i < length; i++) {
                list[i] = new ArrayList<>();
                list[i].add(new int[]{0, 0});
            }
        }

        public void set(int index, int val) {
            List<int[]> arr = list[index];
            arr.add(new int[]{count, val});
        }

        public int snap() {
            return count++;
        }

        public int get(int index, int snap_id) {
            List<int[]> arr = list[index];

            int l = 0;
            int r = arr.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (arr.get(mid)[0] <= snap_id) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return arr.get(l)[1];
        }
    }
}
