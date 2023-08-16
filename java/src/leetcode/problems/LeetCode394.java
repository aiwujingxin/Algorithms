package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-19 7:08 PM
 */
public class LeetCode394 {

    public static void main(String[] args) {
        System.out.println(new LeetCode394().decodeString("3[a2[c]]"));
    }

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
