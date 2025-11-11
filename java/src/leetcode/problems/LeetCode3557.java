package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/7/25 17:00
 */
public class LeetCode3557 {

    public int maxSubstrings(String word) {
        List<int[]> list = findSubstrings(word);
        return maxNonOverlapping(list);
    }

    public int maxNonOverlapping(List<int[]> list) {
        if (list == null || list.isEmpty())
            return 0;
        list.sort(Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : list) {
            if (interval[0] > end) {
                count++;
                end = interval[1];
            }
        }
        return count;
    }

    public static List<int[]> findSubstrings(String s) {
        int n = s.length();
        List<int[]> res = new ArrayList<>();

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        System.out.println(map);
        // 对每个字符做一次查找
        for (int i = 0; i < n - 3; i++) { // 至少长度4
            char c = s.charAt(i);
            List<Integer> list = map.get(c);
            int r = findL(list, i + 3);
            if (r == -1) {
                continue;
            }
            if (list.get(r) - i >= 3) res.add(new int[]{i, list.get(r)});
        }
        return res;
    }

    private static int findL(List<Integer> list, int x) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (list.get(m) < x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
