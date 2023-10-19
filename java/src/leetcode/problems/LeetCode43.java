package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 15:51
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty()) {
            return num2;
        }
        if (num2 == null || num2.isEmpty()) {
            return num1;
        }
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[n + m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int t = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + arr[i + j + 1];
                arr[i + j] += t / 10;
                arr[i + j + 1] = t % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        for (int i = index; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        if (sb.isEmpty()) {
            return "0";
        }
        return sb.toString();
    }
}
