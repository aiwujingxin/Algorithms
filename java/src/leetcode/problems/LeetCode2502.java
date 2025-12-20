package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 12/3/25 15:11
 */
public class LeetCode2502 {

    class Allocator {

        List<int[]> list;
        HashMap<Integer, List<int[]>> map;
        int n;

        public Allocator(int n) {
            this.n = n;
            list = new ArrayList<>();
            list.add(new int[]{-1, -1});
            list.add(new int[]{n, n});
            map = new HashMap<>();
        }

        public int allocate(int size, int mID) {
            int index = findL(list, size);
            if (index == -1) {
                return -1;
            }
            int start = index == 0 ? 0 : list.get(index - 1)[1] + 1;
            int end = start + size - 1;
            if (end >= n) {
                return -1;
            }
            int[] b = new int[]{start, start + size - 1};
            list.add(index, b);
            map.computeIfAbsent(mID, k -> new ArrayList<>()).add(b);
            return start;
        }

        public int freeMemory(int mID) {
            List<int[]> dels = map.get(mID);
            if (dels == null) {
                return 0;
            }
            map.remove(mID);
            int size = 0;
            for (int[] b : dels) {
                list.remove(b);
                size += b[1] - b[0] + 1;
            }
            return size;
        }

        public int findL(List<int[]> arr, int target) {
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i)[0] - arr.get(i - 1)[1] - 1 >= target) {
                    return i;
                }

            }
            return -1;
        }
    }

}
