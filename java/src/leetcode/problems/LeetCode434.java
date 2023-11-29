package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 17:11
 */
public class LeetCode434 {

    public int countSegments(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int cnt = 0;
        int index = 0;
        while (index < n) {
            while (index < n && s.charAt(index) == ' ') {
                index++;
            }
            if (index == n) {
                return cnt;
            }
            while (index < n && s.charAt(index) != ' ') {
                index++;
            }
            cnt++;
        }
        return cnt;
    }
}
