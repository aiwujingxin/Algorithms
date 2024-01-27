package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 11:46
 */
public class LeetCode2380 {

    public int secondsToRemoveOccurrences(String s) {
        int cnt = 0;
        while (s.contains("01")) {
            s = s.replace("01","10");
            cnt++;
        }
        return cnt;
    }
}
