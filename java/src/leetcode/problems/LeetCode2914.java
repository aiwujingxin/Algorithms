package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 19:46
 */
public class LeetCode2914 {

    public int minChanges(String s) {
        int changes = 0;
        int length = s.length();
        for (int i = 0; i < length; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }
        return changes;
    }
}

