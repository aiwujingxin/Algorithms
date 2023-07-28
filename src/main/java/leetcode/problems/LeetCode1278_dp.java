package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/28 23:40
 */
public class LeetCode1278_dp {

    public int palindromePartition(String s, int k) {
        int length = s.length();
        //dp[i][j]表示s的前i个字符分割成k个子串所修改的最少字符数。
        int[][] dp = new int[length + 1][k + 1];
        //因为这题要求的是所需要修改的最少字符数，初始值我们赋值尽可能大
        for (int[] ints : dp) {
            Arrays.fill(ints, length);
        }
        //前i个字符，分割成j个回文子串
        for (int i = 1; i <= length; i++) {
            //前i个字符最大只能分割成i个子串，所以不能超过i，
            //我们取i和k的最小值
            int len = Math.min(i, k);
            for (int j = 1; j <= len; j++) {
                if (j == 1) {
                    //如果j等于1，则表示没有分割，我们直接计算
                    dp[i][j] = change(s, j - 1, i - 1);
                } else {
                    //如果j不等于1，我们计算分割所需要修改的最小字符数，因为m的值要
                    //大于等于j-1，我们就从最小的开始枚举
                    for (int m = j - 1; m < i; m++) {
                        //递推公式
                        dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + change(s, m, i - 1));
                    }
                }
            }
        }
        //返回前length个字符分割成k个子串所需要修改的最少字符数
        return dp[length][k];
    }

    //字符串的子串[left,right]变成回文串所需要修改的字符数
    private int change(String s, int left, int right) {
        int count = 0;
        while (left < right) {
            //如果两个指针指向的字符相同，我们不需要修改。
            //如果不相同，只需要修改其中的一个即可，所以
            // 修改数要加1
            if (s.charAt(left++) != s.charAt(right--))
                count++;
        }
        return count;
    }
}
