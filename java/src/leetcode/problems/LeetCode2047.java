package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/25 16:54
 */
public class LeetCode2047 {

    public int countValidWords(String sentence) {
        String[] list = sentence.split(" ");
        int cnt = 0;
        for (String s : list) {
            if (check(s)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean check(String s) {
        if (s.isEmpty()) {
            return false;
        }
        boolean hasHeng = false;
        boolean hasbiao = false;
        for (int i = 0; i < s.length(); i++) {
            if (isNum(s.charAt(i))) {
                return false;
            }
            if (s.charAt(i) == '-') {
                if (hasHeng) {
                    return false;
                }
                if (i == 0 || i == s.length() - 1) {
                    return false;
                }
                if (!isAl(s.charAt(i - 1)) || !isAl(s.charAt(i + 1))) {
                    return false;
                }
                hasHeng = true;
            }
            if (isBiao(s.charAt(i))) {
                if (hasbiao) {
                    return false;

                }
                if (i != s.length() - 1) {
                    return false;
                }
                hasbiao = true;
            }
        }
        return true;
    }

    private boolean isAl(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isBiao(char c) {
        return c == '!' || c == '.' || c == ',';
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
