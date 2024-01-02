package leetcode.problems;

import basic.datastructure.string.impl.KMP;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 20:47
 */
public class LeetCode1392 {

    public String longestPrefix(String s) {
        int n = s.length();
        int[] next = new KMP().makePrefix(s);
        return s.substring(0, next[n - 1]);
    }
}
