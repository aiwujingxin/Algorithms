package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 16:50
 */
public class LeetCode244 {

    public int[] search(int[] b, int target) {
        int l = 0;
        int r = b.length - 1;

        while (l <= r) {
            int mid = l + r >> 1;
            if (b[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r == -1) {
            return new int[]{Integer.MAX_VALUE, b[l]};
        }
        if (l == b.length) {
            return new int[]{Integer.MAX_VALUE, b[r]};
        }
        return new int[]{b[l], b[r]};
    }

    class WordDistance {
        HashMap<String, List<Integer>> map;

        public WordDistance(String[] wordsDict) {
            map = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                List<Integer> list = map.getOrDefault(wordsDict[i], new ArrayList<>());
                list.add(i);
                map.put(wordsDict[i], list);
            }
        }

        public int shortest(String word1, String word2) {
            if (!map.containsKey(word1) || !map.containsKey(word2)) {
                return -1;
            }
            List<Integer> al = map.get(word1);
            List<Integer> bl = map.get(word2);
            int[] a = new int[al.size()];
            for (int i = 0; i < al.size(); i++) {
                a[i] = al.get(i);
            }
            int[] b = new int[bl.size()];
            for (int i = 0; i < bl.size(); i++) {
                b[i] = bl.get(i);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                int[] res = search(b, a[i]);
                min = Math.min(Math.min(Math.abs(a[i] - res[0]), Math.abs(a[i] - res[1])), min);
            }
            return min;
        }
    }
}
