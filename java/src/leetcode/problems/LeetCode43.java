package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 11:28
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];
        // 计算 : 蓄水
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        // 进位传导
        for (int k = m + n - 1; k > 0; k--) {
            arr[k - 1] += arr[k] / 10;
            arr[k] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            if (sb.isEmpty() && x == 0) continue;
            sb.append(x);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
