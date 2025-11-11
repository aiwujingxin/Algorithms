package leetcode.problems;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/7 17:57
 */
public class LeetCode480 {

    int[] nums;
    TreeSet<Integer> L;  // 大顶堆（按值降序，索引降序）
    TreeSet<Integer> R;  // 小顶堆（按值升序，索引升序）

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        Comparator<Integer> cmp = (i, j) -> {
            if (nums[i] != nums[j]) {
                return Integer.compare(nums[i], nums[j]);
            }
            return Integer.compare(i, j);
        };
        R = new TreeSet<>(cmp);
        L = new TreeSet<>(cmp.reversed());
        double[] ans = new double[n - k + 1];
        for (int i = 0; i < k; i++) add(i);
        ans[0] = median();
        for (int i = k; i < n; i++) {
            remove(i - k);
            add(i);
            ans[i - k + 1] = median();
        }
        return ans;
    }

    private void add(int idx) {
        L.add(idx);
        R.add(L.pollFirst());
        balance();
    }

    private void remove(int idx) {
        if (!L.remove(idx)) R.remove(idx);
        balance();
    }

    private void balance() {
        while (L.size() < R.size()) L.add(R.pollFirst());
        while (L.size() > R.size() + 1) R.add(L.pollFirst());
    }

    private double median() {
        if (L.size() == R.size()) {
            return ((double) nums[L.first()] + nums[R.first()]) / 2.0;
        }
        return nums[L.first()];
    }
}
