package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 12:24
 */
public class LeetCode1902 {

    public int maxDepthBST(int[] order) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 0);
        treeMap.put(Integer.MAX_VALUE, 0);
        int res = 0;
        for (int i : order) {
            Map.Entry<Integer, Integer> lower = treeMap.lowerEntry(i);
            Map.Entry<Integer, Integer> higher = treeMap.higherEntry(i);
            int depth = Math.max(lower.getValue(), higher.getValue()) + 1;
            treeMap.put(i, depth);
            res = Math.max(res, depth);
        }
        return res;
    }
}
