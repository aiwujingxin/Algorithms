package leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 18:44
 */
public class LeetCode60 {

    public String getPermutation(int n, int k) {
        k--;
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++) {
            factor[i] = factor[i - 1] * i;
        }
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            //落在第几组 确定第几个数字
            sb.append(nums.remove(k / factor[i]));
            k %= factor[i];
        }
        return sb.toString();
    }
}
