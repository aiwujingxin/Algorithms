package leetCode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/18 22:48
 */
public class LeetCode327_SegmentTree {


    public int countRangeSum(int[] nums, int lower, int upper) {

        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Long> valSet = new HashSet<>();
        long sum = 0;
        for (int num : nums) {
            sum += num;
            valSet.add(sum);
        }

        Long[] valArr = valSet.toArray(new Long[0]);

        Arrays.sort(valArr);
        SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length - 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            updateSegmentTree(root, sum);
            sum -= nums[i];
            ans += getCount(root, (long) lower + sum, (long) upper + sum);
        }
        return ans;
    }

    static class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;

        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if (low > high) {
            return null;
        }
        SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
        if (low == high) {
            return stn;
        }
        int mid = (low + high) / 2;
        stn.left = buildSegmentTree(valArr, low, mid);
        stn.right = buildSegmentTree(valArr, mid + 1, high);
        return stn;
    }

    private void updateSegmentTree(SegmentTreeNode stn, Long val) {
        if (stn == null) {
            return;
        }

        if (val >= stn.min && val <= stn.max) {
            stn.count++;
            updateSegmentTree(stn.left, val);
            updateSegmentTree(stn.right, val);
        }
    }

    private int getCount(SegmentTreeNode stn, long min, long max) {
        if (stn == null) {
            return 0;
        }

        if (min > stn.max || max < stn.min) {
            return 0;
        }

        if (min <= stn.min && max >= stn.max) {
            return stn.count;
        }

        return getCount(stn.left, min, max) + getCount(stn.right, min, max);
    }
}
