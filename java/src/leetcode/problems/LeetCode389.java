package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023/11/21 23:09
 */
public class LeetCode389 {

    public char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
