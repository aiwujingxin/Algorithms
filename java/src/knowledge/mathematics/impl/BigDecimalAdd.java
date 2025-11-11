package knowledge.mathematics.impl;

import leetcode.problems.LeetCode415;

/**
 * @author wujingxinit@outlook.com
 * @date 11/11/25 22:12
 * @see LeetCode415 加
 */
public class BigDecimalAdd {

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? (num1.charAt(i) - '0') : 0;
            int n2 = j >= 0 ? (num2.charAt(j) - '0') : 0;
            int num = n1 + n2 + carry;
            carry = num / 10;
            sb.append(num % 10);
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static String addDecimalStrings(String num1, String num2) {
        // 1. 分割整数和小数部分
        String intPart1 = num1, decPart1 = "0";
        if (num1.contains(".")) {
            String[] parts = num1.split("\\.");
            intPart1 = parts[0];
            decPart1 = parts[1];
        }
        String intPart2 = num2, decPart2 = "0";
        if (num2.contains(".")) {
            String[] parts = num2.split("\\.");
            intPart2 = parts[0];
            decPart2 = parts[1];
        }
        // 2. 对齐小数部分 (末尾补0)
        int maxDecLen = Math.max(decPart1.length(), decPart2.length());
        while (decPart1.length() < maxDecLen) decPart1 += "0";
        while (decPart2.length() < maxDecLen) decPart2 += "0";
        // 3. 计算小数部分之和
        String decSum = addStrings(decPart1, decPart2);
        // 4. 处理小数部分的进位
        String carry = "0";
        String finalDecPart;
        if (decSum.length() > maxDecLen) {
            carry = decSum.substring(0, decSum.length() - maxDecLen);
            finalDecPart = decSum.substring(decSum.length() - maxDecLen);
        } else {
            finalDecPart = decSum;
            // 如果小数和结果位数不够，前面补0
            while (finalDecPart.length() < maxDecLen) finalDecPart = "0" + finalDecPart;
        }
        // 5. 计算整数部分之和 (整数部分 + 进位)
        String intSum = addStrings(intPart1, intPart2);
        String finalIntPart = addStrings(intSum, carry);
        // 6. 组合结果
        // 如果小数部分是"0"或者为空，则不显示小数部分
        if (finalDecPart.matches("0+")) {
            return finalIntPart;
        }
        return finalIntPart + "." + finalDecPart;
    }
}
