package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 3/10/26 00:00
 */
public class LeetCode939 {

    public int minAreaRect(int[][] points) {
        List<Integer> xs = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        HashMap<Integer, List<Integer>> xMap = new HashMap<>();
        for (int[] p : points) {
            xMap.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
            if (vis.contains(p[0])) continue;
            vis.add(p[0]);
            xs.add(p[0]);

        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < xs.size(); i++) {
            if (xMap.get(xs.get(i)).size() < 2) continue;
            for (int j = i + 1; j < xs.size(); j++) {
                if (xs.get(j) <= xs.get(i)) continue;
                if (xMap.get(xs.get(j)).size() < 2) continue;
                int w = cal(xMap.get(xs.get(i)), xMap.get(xs.get(j)));
                if (w == -1 || w ==  Integer.MAX_VALUE) continue;
                res = Math.min(res, (xs.get(j) - xs.get(i)) * w);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int cal(List<Integer> s, List<Integer> t) {
        if (s.size() < 2 || t.size() < 2) return -1;
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int pre = -1;
        while (i < s.size() && j < t.size()) {
            if (s.get(i).equals(t.get(j))) {
                if (pre != -1) {
                    res = Math.min(res, s.get(i) - pre);
                }
                pre = s.get(i);
                i++;
                j++;
            } else if (s.get(i) < t.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
