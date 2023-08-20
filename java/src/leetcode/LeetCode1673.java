package leetcode;

import java.util.Stack;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/21 00:10
 */
public class LeetCode1673 {

    //https://leetcode.com/problems/create-maximum-number/discuss/1611691/Java-or-easy-to-understand-or-monotonic-stack-or-3-subproblems-or-same-as-Leetcode-16737

    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[k];
        int rem = n - k;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() > nums[i] && rem > 0) {
                st.pop();
                rem--;
            }
            st.push(nums[i]);
        }
        while (rem > 0) {
            st.pop();
            rem--;
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
