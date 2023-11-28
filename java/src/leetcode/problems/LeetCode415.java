package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 18:50
 */
public class LeetCode415 {

    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int flag = 0;
        StringBuilder res = new StringBuilder();
        while (m >= 0 || n >= 0) {
            int a = m >= 0 ? (num1.charAt(m) - '0') : 0;
            int b = n >= 0 ? (num2.charAt(n) - '0') : 0;
            int sum = a + b + flag;
            res.insert(0, (sum % 10));
            flag = sum / 10;
            m--;
            n--;
        }
        if (flag == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }
}
