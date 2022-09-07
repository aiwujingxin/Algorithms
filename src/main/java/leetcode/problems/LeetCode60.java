package leetcode.problems;

import java.util.ArrayList;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/14 21:42
 */
public class LeetCode60 {

    public static void main(String[] args) {
        System.out.println(new LeetCode60().getPermutation(5, 45));
    }

    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        int[] factor = new int[n];
        factor[0] = 1;
        // 阶乘，每一组有多少个数字
        for (int i = 1; i < n; i++) {
            factor[i] = factor[i - 1] * i;
        }
        // 构造 当前位 可用的 list
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--; //
        StringBuilder sb = new StringBuilder();// 第几个变成 Index 的表示
        for (int i = n - 1; i >= 0; i--) {
            sb.append(nums.remove(k / factor[i]));
            k = k % factor[i]; // 更新k,在子集合中 的位置。
        }
        return sb.toString();
    }
}
