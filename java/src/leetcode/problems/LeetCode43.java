package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 11:28
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int sum = arr[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10;
            }
        }
        int i = 0;
        while (i < arr.length && arr[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i < arr.length) {
            sb.append(arr[i]);
            i++;
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
