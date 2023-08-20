package leetcode;

/**
 * @author jingxinwu
 * @date 2021-06-21 11:30 下午
 */
public class LeetCode43 {

    public static void main(String[] args) {
        LeetCode43 leetCode43 = new LeetCode43();
        System.out.println(leetCode43.multiply("5", "9"));
    }

    public String multiply(String num1, String num2) {

        if (num1 == null || num1.length() == 0) {
            return num2;
        }

        if (num2 == null || num2.length() == 0) {
            return num1;
        }

        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                int p1 = i + j; // 十位
                int p2 = i + j + 1;// 个位
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
