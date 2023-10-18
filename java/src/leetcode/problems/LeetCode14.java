package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 15:04
 */
public class LeetCode14 {

    public static void main(String[] args) {
        System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"abc", "abd", "abs"}));
    }

    public String longestCommonPrefix(String[] strs) {

        int index = 0;
        int max = Integer.MAX_VALUE;
        for (String s : strs) {
            max = Math.min(max, s.length());
        }
        while (index < max) {
            char c = strs[0].charAt(index);
            if (!can(index, c, strs)) {
                break;
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    private boolean can(int index, char c, String[] strs) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(index) != c) {
                return false;
            }
        }
        return true;
    }
}
