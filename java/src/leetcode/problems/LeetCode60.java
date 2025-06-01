package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 18:44
 */
public class LeetCode60 {

    public String getPermutation(int n, int k) {
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++) {
            factor[i] = factor[i - 1] * i;
        }
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            //落在第几组 确定第几个数字
            sb.append(nums.remove(k / factor[i]));
            k %= factor[i];
        }
        return sb.toString();
    }
}
