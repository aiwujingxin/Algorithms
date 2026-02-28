package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 11:32
 */
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        for (int len = 0; len < strs[0].length(); len++) {
            char c = strs[0].charAt(len);
            for (int j = 1; j < strs.length; j++) {
                if (len >= strs[j].length() || strs[j].charAt(len) != c) {
                    return strs[0].substring(0, len);
                }
            }
        }
        return strs[0];
    }
}
