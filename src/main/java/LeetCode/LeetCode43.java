package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-06-06 1:01 下午
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }

        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {

            for (int j = 0; j < num2.length(); j++) {
                int p1 = i + j;// 十位
                int p2 = i + j;// 个位
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = res[p2] + product;
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : res) {
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }

        return sb.toString();
    }

}
