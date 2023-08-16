package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/2 15:24
 */
public class LeetCode1182 {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < colors.length; i++) {
            map.get(colors[i]).add(i);
        }
        for (int[] query : queries) {
            res.add(getMinDist(query[0], map.get(query[1])));
        }
        return res;
    }

    public int getMinDist(int index, List<Integer> list) {
        if (list.size() == 0) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        // 区间外
        if (index < list.get(left)) {
            return list.get(left) - index;
        }
        if (index > list.get(right)) {
            return index - list.get(right);
        }
        // 区间内
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == index) {
                return 0;
            } else if (list.get(mid) < index) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.min(Math.abs(list.get(left) - index), Math.abs(list.get(left - 1) - index));
    }
}
