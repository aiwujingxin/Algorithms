package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 22:26
 */
public class LeetCode394 {

    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    public String[] dfs(String s, int index) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String[] res = dfs(s, index + 1);
                for (int i = 0; i < num; i++) {
                    sb.append(res[0]);
                }
                index = Integer.parseInt(res[1]);
                num = 0;
            } else if (c == ']') {
                return new String[]{sb.toString(), String.valueOf(index)};
            } else {
                sb.append(c);
            }
            index++;
        }
        return new String[]{sb.toString(), String.valueOf(index)};
    }
}
