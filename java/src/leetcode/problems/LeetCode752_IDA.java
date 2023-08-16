package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/3 02:01
 */
public class LeetCode752_IDA {

    String s, t;
    String cur;
    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();

    public int openLock(String[] ds, String _t) {
        s = "0000";
        t = _t;
        if (s.equals(t)) {
            return 0;
        }
        Collections.addAll(set, ds);
        if (set.contains(s)) {

            return -1;
        }

        int depth = 0, max = getMax();
        cur = s;
        map.put(cur, 0);
        while (depth <= max && !dfs(0, depth)) {
            map.clear();
            cur = s;
            map.put(cur, 0);
            depth++;
        }
        return depth > max ? -1 : depth;
    }

    int getMax() {
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int origin = s.charAt(i) - '0', next = t.charAt(i) - '0';
            int a = Math.min(origin, next), b = Math.max(origin, next);
            int max = Math.max(b - a, a + 10 - b);
            ans += max;
        }
        return ans;
    }

    int f() {
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int origin = cur.charAt(i) - '0', next = t.charAt(i) - '0';
            int a = Math.min(origin, next), b = Math.max(origin, next);
            int min = Math.min(b - a, a + 10 - b);
            ans += min;
        }
        return ans;
    }

    boolean dfs(int u, int max) {
        if (u + f() > max) {

            return false;
        }
        if (f() == 0) {
            return true;
        }

        String backup = cur;
        char[] cs = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            for (int j = -1; j <= 1; j++) {
                if (j == 0) {
                    continue;
                }

                int origin = cs[i] - '0';
                int next = (origin + j) % 10;
                if (next == -1) next = 9;
                char[] clone = cs.clone();
                clone[i] = (char) (next + '0');
                String str = String.valueOf(clone);
                if (set.contains(str)) {
                    continue;
                }

                if (!map.containsKey(str) || map.get(str) > u + 1) {
                    cur = str;
                    map.put(str, u + 1);
                    if (dfs(u + 1, max)) {

                        return true;
                    }
                    cur = backup;
                }
            }
        }
        return false;
    }
}
