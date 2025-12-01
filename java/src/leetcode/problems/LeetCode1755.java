package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1755 {

    public int minAbsDifference(int[] nums, int goal) {
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            left.add((long) nums[i]);
        }
        for (int i = n / 2; i < n; i++) {
            right.add((long) nums[i]);
        }

        List<Long> leftSum = getSum(left);
        List<Long> rightSum = getSum(right);
        long res = Integer.MAX_VALUE;
        for (long a : leftSum) {
            long target = goal - a;
            int b1 = findL(rightSum, target);
            int b2 = findR(rightSum, target);
            res = Math.min(Math.abs(a + rightSum.get(b1) - goal), res);
            if (b1 - 1 != -1) {
                res = Math.min(Math.abs(a + rightSum.get(b1 - 1) - goal), res);
            }
            res = Math.min(Math.abs(a + rightSum.get(b2) - goal), res);
            if (b2 + 1 != rightSum.size()) {
                res = Math.min(Math.abs(a + rightSum.get(b2 + 1) - goal), res);
            }
        }
        return (int) Math.min(res, Math.abs(goal));
    }

    private int findL(List<Long> nums, long x) {
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums.get(mid) < x) l = mid + 1;
            else r = mid;
        }

        return l;
    }

    private int findR(List<Long> nums, long x) {
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums.get(mid) > x) r = mid - 1;
            else l = mid;
        }
        if (nums.get(l) < x) {
            return l + 1;
        }
        return l;
    }


    private List<Long> getSum(List<Long> nums) {
        if (nums.isEmpty()) {
            return new ArrayList<>();
        }
        List<Long> sum = new ArrayList<>();
        sum.add(0L);
        sum.add(nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            long num = nums.get(i);
            List<Long> curS = new ArrayList<>();
            curS.add(num);
            for (long s : sum) {
                curS.add(num + s);
            }
            sum.addAll(curS);
        }
        Collections.sort(sum);
        return sum;
    }
}
