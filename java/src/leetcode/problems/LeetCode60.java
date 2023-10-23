package leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 22:33
 */
public class LeetCode60 {

    public String getPermutation(int n, int k) {
        // 注意：相当于在 n 个数字的全排列中找到下标为 k - 1 的那个数，因此 k 先减 1
        k--;
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int[] factor = new int[n];
        factor[0] = 1;
        // 先算出所有的阶乘值
        for (int i = 1; i < n; i++) {
            factor[i] = factor[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        // i 表示剩余的数字个数，初始化为 n - 1
        for (int i = n - 1; i >= 0; i--) {
            sb.append(nums.remove(k / factor[i]));
            k = k % factor[i]; // 更新k,在子集合中 的位置。
        }
        return sb.toString();
    }
}
