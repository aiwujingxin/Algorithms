package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-12-12 3:41 PM
 */
public class LeetCode496 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new LeetCode496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));

        System.out.println(
                Arrays.toString(
                        new LeetCode496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{2, 5, 3, 6, 8, 4, 7, 1})));
    }

    //单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
