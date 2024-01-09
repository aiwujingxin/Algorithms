package leetcode.problems;

import java.util.Stack;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/11/17 00:06
 * @see LeetCode402
 */
public class LeetCode321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[0];
        for (int i = 0; i <= nums1.length && i <= k; i++) {
            int j = k - i;
            if (j >= 0 && j <= nums2.length) {
                int[] ints = merge(subMaxNumber(nums1, i), subMaxNumber(nums2, j));
                if (compare(ints, 0, res, 0)) {
                    res = ints;
                }
            }
        }
        return res;
    }

    public boolean compare(int[] nums1, int index1, int[] nums2, int index2) {
        int x = nums1.length, y = nums2.length;
        while (index1 < x && index2 < y) {
            int difference = nums1[index1] - nums2[index2];
            if (difference != 0) {
                return difference > 0;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2) > 0;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int index = 0;
        int p1 = 0;
        int p2 = 0;
        while (index < nums1.length + nums2.length) {
            if (compare(nums1, p1, nums2, p2)) {
                result[index++] = nums1[p1++];
            } else {
                result[index++] = nums2[p2++];
            }
        }
        return result;
    }

    public int[] subMaxNumber(int[] nums, int len) {
        int k = nums.length - len; //转化为移除k个数字得到最大值
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        int[] result = new int[stack.size()];
        int index = 0;
        for (int num : stack) {
            result[index++] = num;
        }
        return result;
    }
}
