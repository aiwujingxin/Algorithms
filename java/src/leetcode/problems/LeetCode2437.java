package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/12 17:34
 */
public class LeetCode2437 {

    public int countTime(String time) {
        if (!time.contains("?")) {
            return 1;
        }
        String[] times = time.split(":");
        if (time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
            return 1440;
        }
        int n = getCnt(times[0], 0, 23, 24);
        int m = getCnt(times[1], 0, 59, 60);
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        return m * n;
    }

    public int getCnt(String s, int min, int max, int t) {
        if (!s.contains("?")) {
            return 0;
        }
        if (s.charAt(0) == '?' && s.charAt(1) == '?') {
            return t;
        }
        int cnt = 0;
        if (s.charAt(0) == '?') {
            for (int i = 0; i <= 9; i++) {
                int num = i * 10 + s.charAt(1) - '0';
                if (num >= min && num <= max) {
                    cnt++;
                }
            }

            return cnt;
        }
        if (s.charAt(1) == '?') {
            for (int i = 0; i <= 9; i++) {
                int num = (s.charAt(0) - '0') * 10 + i;
                if (num >= min && num <= max) {
                    cnt++;
                }
            }
            return cnt;
        }
        return 0;
    }
}
