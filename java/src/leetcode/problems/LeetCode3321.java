package leetcode.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 11/5/25 02:16
 */
public class LeetCode3321 {

    private Map<Integer, Integer> cnt;
    private TreeSet<int[]> L;
    private TreeSet<int[]> R;
    private long sumL;
    private int x;

    public long[] findXSum(int[] nums, int k, int x) {
        this.x = x;
        this.cnt = new HashMap<>();
        this.sumL = 0;
        Comparator<int[]> cmp = (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
            return Integer.compare(b[1], a[1]);
        };
        this.L = new TreeSet<>(cmp);
        this.R = new TreeSet<>(cmp);
        long[] ans = new long[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }
        ans[0] = getSumL();
        for (int i = k; i < nums.length; i++) {
            remove(nums[i - k]);
            add(nums[i]);
            ans[i - k + 1] = getSumL();
        }
        return ans;
    }

    private void add(int val) {
        int oldFreq = cnt.getOrDefault(val, 0);
        if (oldFreq > 0) {
            remove(new int[]{oldFreq, val});
        }
        cnt.merge(val, 1, Integer::sum);
        add(new int[]{cnt.get(val), val});
    }

    private void remove(int val) {
        int oldFreq = cnt.get(val);
        remove(new int[]{oldFreq, val});
        cnt.merge(val, -1, Integer::sum);
        if (cnt.get(val) > 0) {
            add(new int[]{cnt.get(val), val});
        }
    }

    private void add(int[] p) {
        if (L.size() < x || L.comparator().compare(p, L.last()) < 0) {
            L.add(p);
            sumL += (long) p[0] * p[1];
        } else {
            R.add(p);
        }
        balance();
    }

    private void remove(int[] p) {
        if (L.remove(p)) {
            sumL -= (long) p[0] * p[1];
        } else {
            R.remove(p);
        }
        balance();
    }

    private void balance() {
        while (L.size() > x) {
            int[] toMove = L.pollLast();
            sumL -= (long) toMove[0] * toMove[1];
            R.add(toMove);
        }
        while (L.size() < x && !R.isEmpty()) {
            int[] toMove = R.pollFirst();
            sumL += (long) toMove[0] * toMove[1];
            L.add(toMove);
        }
    }

    private long getSumL() {
        return sumL;
    }
}
