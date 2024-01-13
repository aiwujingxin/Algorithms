package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 12:49
 */
public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= nums2[stack.peek()]) {
                stack.pop();
            }
            if (map.containsKey(nums2[i])) {
                res[map.get(nums2[i])] = stack.isEmpty() ? -1 : nums2[stack.peek()];
            }
            stack.push(i);
        }
        return res;
    }
}
