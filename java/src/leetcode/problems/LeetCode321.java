package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/11/17 00:06
 * @see LeetCode402
 */
public class LeetCode321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxResult = new int[k];
        int start = Math.max(0, k - n);
        int end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] sub1 = getMaxSubsequence(nums1, i);
            int[] sub2 = getMaxSubsequence(nums2, k - i);
            int[] merged = merge(sub1, sub2);
            if (compare(merged, 0, maxResult, 0) > 0) {
                maxResult = merged;
            }
        }
        return maxResult;
    }

    // 1. 单调栈求长度为 k 的最大子序列
    private int[] getMaxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1; // 栈顶指针
        int drop = nums.length - k; // 允许丢弃的元素个数
        for (int num : nums) {
            // 当栈不空，且当前元素大于栈顶，且还有丢弃额度时，弹出栈顶
            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top < k - 1) {
                top++;
                stack[top] = num;
            } else {
                drop--; // 栈满了，当前元素只能丢弃
            }
        }
        return stack;
    }

    // 2. 合并两个子序列
    private int[] merge(int[] sub1, int[] sub2) {
        int x = sub1.length, y = sub2.length;
        if (x == 0) return sub2;
        if (y == 0) return sub1;
        int mergeLen = x + y;
        int[] merged = new int[mergeLen];
        int i = 0, j = 0;
        for (int k = 0; k < mergeLen; k++) {
            // 如果 sub1 字典序大于 sub2，选 sub1[i]，否则选 sub2[j]
            if (compare(sub1, i, sub2, j) > 0) {
                merged[k] = sub1[i++];
            } else {
                merged[k] = sub2[j++];
            }
        }
        return merged;
    }

    // 3. 比较两个数组（或其后缀）的字典序
    // 返回值 > 0 表示 nums1 > nums2
    private int compare(int[] nums1, int i, int[] nums2, int j) {
        int x = nums1.length, y = nums2.length;
        while (i < x && j < y) {
            int diff = nums1[i] - nums2[j];
            if (diff != 0) return diff;
            i++;
            j++;
        }
        // 如果前缀相同，长度长的更大（虽然在本题merge逻辑中，长度其实是剩余长度）
        // 这里的逻辑主要服务于 merge 中的贪心选择
        return (x - i) - (y - j);
    }
}
