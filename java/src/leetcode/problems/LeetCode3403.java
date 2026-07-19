package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/12/26 20:51
 */
public class LeetCode3403 {


    public String answerString(String word, int numFriends) {
        if (word.length() == 1 || numFriends == 1) return word;
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String s = word.substring(i, Math.min(n, n - (numFriends - i) + 1));
            if (compare(s, res) > 0) {
                res = s;
            }
        }
        return res;
    }


    public static int compare(String num1, String num2) {
        int index = Math.min(num1.length(), num2.length());
        // 长度相等，从高位逐位比较
        for (int i = 0; i < index; i++) {
            if (num1.charAt(i) > num2.charAt(i)) return 1;
            if (num1.charAt(i) < num2.charAt(i)) return -1;
        }
        if (num1.length() == num2.length()) return 0;
        return num1.length() < index ? -1 : 1;
    }
}
