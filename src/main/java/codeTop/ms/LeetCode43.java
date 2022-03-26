package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-23 6:57 PM
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int len = num1.length() + num2.length();
        int[] arr = new int[len];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int p1 = i + j; //十位
                int p2 = i + j + 1; //个位
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + arr[p2];
                arr[p2] = sum % 10; //个位
                arr[p1] += sum / 10; //十位
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            if (sb.length() == 0 && j == 0) {
                continue;
            }
            sb.append(j);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
