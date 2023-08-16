package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-11-16 9:12 下午
 */
public class LeetCode38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String s = "1";
        for (int i = 1; i < n; i++) {
            int j = 0;
            char target = s.charAt(j);
            int count = 0;
            StringBuilder sb = new StringBuilder();
            while (j < s.length()) {
                while (j < s.length() && s.charAt(j) == target) {
                    count++;
                    j++;
                }
                sb.append(count).append(s.charAt(j - 1));
                if (j < s.length()) {
                    target = s.charAt(j);
                    count = 0;
                } else {
                    break;
                }
            }
            s = sb.toString();
        }
        return s;
    }

}
