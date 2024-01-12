package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/12 16:32
 */
public class LeetCode1003 {

    public boolean isValid(String s) {
        if (s.length() <= 2) {
            return false;
        }
        while (s.contains("abc")) {
            s = s.replace("abc", "");
        }
        return s.isEmpty();
    }
}
