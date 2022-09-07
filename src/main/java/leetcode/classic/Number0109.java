package leetcode.classic;

/**
 * @author jingxinwu
 * @date 2021-12-05 1:45 下午
 */
public class Number0109 {

    public boolean isFlipedString(String s1, String s2) {

        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null) {
            return false;
        }

        if (s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }

}
