package leetcode.problems;

import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/7 17:57
 */
public class LeetCode480 {

    TreeSet<Integer> maxSet;
    TreeSet<Integer> minSet;

    int[] nums;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        this.nums = nums;
        double[] result = new double[len - k + 1];
        if (k == 1) {
            for (int i = 0; i < len; i++) {
                result[i] = nums[i];
            }
            return result;
        }
        maxSet = new TreeSet<>((a, b) -> {
            if (nums[a] == nums[b]) {
                return Integer.compare(b, a);
            }
            return Integer.compare(nums[b], nums[a]);

        });

        minSet = new TreeSet<>((a, b) -> {
            if (nums[a] == nums[b]) {
                return Integer.compare(a, b);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        for (int i = 0; i < len; i++) {
            if (i >= k) {
                remove(i - k);
            }
            add(i);
            if (i >= k - 1) {
                result[i - (k - 1)] = getMid();
            }
        }
        return result;
    }

    private void add(int idx) {
        if (maxSet.isEmpty() || nums[maxSet.first()] >= nums[idx]) {
            maxSet.add(idx);
        } else {
            minSet.add(idx);
        }
        if (maxSet.size() > minSet.size() + 1) {
            minSet.add(maxSet.pollFirst());
        } else if (minSet.size() > maxSet.size()) {
            maxSet.add(minSet.pollFirst());
        }
    }

    private void remove(int idx) {
        if (minSet.contains(idx)) {
            minSet.remove(idx);
            if (maxSet.size() > minSet.size() + 1) {
                minSet.add(maxSet.pollFirst());
            }
        } else {
            maxSet.remove(idx);
            if (maxSet.size() < minSet.size()) {
                maxSet.add(minSet.pollFirst());
            }
        }
    }

    private double getMid() {
        if (maxSet.size() == minSet.size()) {
            return ((double) nums[maxSet.first()] + nums[minSet.first()]) / 2;
        }
        return nums[maxSet.first()];
    }
}
