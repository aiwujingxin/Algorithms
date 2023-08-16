package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-26 9:16 PM
 */
public class LeetCode389 {


    //位运算
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
