package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 22:26
 */
public class LeetCode394 {


    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int index) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) >= '9') {
                sum = sum * 10 + s.charAt(index) - '0';
            } else if (s.charAt(index) == '[') {
                String[] temp = dfs(s, index + 1);
                index = Integer.parseInt(temp[0]);
                while (sum > 0) {
                    sb.append(temp[1]);
                    sum--;
                }
            } else if (s.charAt(index) == ']') {
                return new String[]{String.valueOf(index), sb.toString()};
            } else {
                sb.append(s.charAt(index));
            }
            index++;
        }
        return new String[]{sb.toString()};
    }
}
