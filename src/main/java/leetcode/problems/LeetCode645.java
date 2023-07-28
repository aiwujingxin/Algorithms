package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/21 00:32
 */
public class LeetCode645 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode645().findErrorNums(new int[]{1, 2, 3, 4, 5, 6, 6, 8})));
    }


    //https://leetcode.com/problems/set-mismatch/discuss/1089560/JS-Python-Java-C%2B%2B-or-(Updated)-Easy-O(1)-Space-Solution-w-Explanation
    public int[] findErrorNums(int[] nums) {
        int N = nums.length;
        int sum = N * (N + 1) / 2;
        int[] ans = new int[2];
        boolean[] seen = new boolean[N + 1];
        for (int num : nums) {
            sum -= num;
            if (seen[num]) {
                ans[0] = num;
            }
            seen[num] = true;
        }
        ans[1] = sum + ans[0];
        return ans;
    }
}
