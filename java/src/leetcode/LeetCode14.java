package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 00:12
 */
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            len = Math.min(len, str.length());
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (same(strs, i)) {
                count++;
            } else {
                break;
            }
        }
        return strs[0].substring(0, count);
    }

    private boolean same(String[] strs, int i) {
        char a = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++) {
            if (strs[j].charAt(i) != a) {
                return false;
            }
        }
        return true;
    }
}
