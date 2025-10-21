package leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 00:53
 */
public class LeetCode1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int b : barcodes) {
            map.merge(b, 1, Integer::sum);
        }
        TreeSet<int[]> pq = new TreeSet<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }
        int idx = 0;
        int[] ans = new int[n];
        while (idx < n) {
            int[] f = pq.pollFirst();
            ans[idx++] = f[0];
            if (pq.isEmpty()) return ans;
            int[] s = pq.pollFirst();
            ans[idx++] = s[0];
            f[1]--;
            s[1]--;
            if (f[1] != 0) pq.add(f);
            if (s[1] != 0) pq.add(s);
        }
        return ans;
    }
}
