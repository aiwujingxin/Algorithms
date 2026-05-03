package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 11:32
 */
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        for (int j = 0; j < strs[0].length(); j++) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }
}
