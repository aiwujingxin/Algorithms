package leetcode.lists.hot100;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 00:10
 */
public class LeetCode394 {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        return dfs(s, 0)[0];
    }

    public String[] dfs(String s, int i) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum = sum * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else if (c == '[') {
                // 遇到[, 即可拆分成子问题， 定义好返回值，基于子问题的返回值继续求解
                String[] temp = dfs(s, i + 1);
                i = Integer.parseInt(temp[0]);
                while (sum > 0) {
                    sb.append(temp[1]);
                    sum--;
                }
            } else if (c == ']') {
                return new String[]{String.valueOf(i), sb.toString()};
            } else {
                sb.append(c);
            }
            i++;
        }
        return new String[]{sb.toString()};
    }
}
