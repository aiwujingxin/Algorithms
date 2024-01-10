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
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums1[stack.peek()] < nums1[i]) {
                int index = stack.pop();
                if (map.containsKey(nums2[index])) {
                    res[map.get(nums2[index])] = nums2[i];
                }
            }
            stack.push(i);
        }
        return res;
    }
}
