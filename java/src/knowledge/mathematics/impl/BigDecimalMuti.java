package knowledge.mathematics.impl;

import leetcode.problems.LeetCode43;

/**
 * @author wujingxinit@outlook.com
 * @date 11/11/25 22:12
 * @see LeetCode43 乘
 */
public class BigDecimalMuti {

    // 整数
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] c = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int sum = c[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                c[i + j + 1] = sum % 10;
                c[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < c.length && c[i] == 0) i++;
        while (i < c.length) sb.append(c[i++]);
        return sb.isEmpty() ? "0" : sb.toString();
    }

    // 小数
    public String multiplyDecimal(String num1, String num2) {
        // 1. 处理符号
        boolean isNegative = false;
        if (num1.startsWith("-")) {
            isNegative = true;
            num1 = num1.substring(1);
        }
        if (num2.startsWith("-")) {
            isNegative = !isNegative;
            num2 = num2.substring(1);
        }
        // 2. 统计总小数位数
        int decPlaces1 = num1.contains(".") ? num1.length() - num1.indexOf('.') - 1 : 0;
        int decPlaces2 = num2.contains(".") ? num2.length() - num2.indexOf('.') - 1 : 0;
        int totalDecimalPlaces = decPlaces1 + decPlaces2;
        // 3. 移除小数点，转为整数
        String intStr1 = num1.replace(".", "");
        String intStr2 = num2.replace(".", "");
        // 4. 调用整数乘法
        String productStr = multiply(intStr1, intStr2);
        // 如果乘积为 "0", 直接返回 "0"
        if ("0".equals(productStr)) {
            return "0";
        }
        // 5. 放回小数点
        StringBuilder result;
        if (productStr.length() <= totalDecimalPlaces) {
            // 结果小于1，前面需要补0
            int zerosToPad = totalDecimalPlaces - productStr.length();
            result = new StringBuilder("0.");
            result.append("0".repeat(zerosToPad));
            result.append(productStr);
        } else {
            // 结果大于等于1
            int dotPos = productStr.length() - totalDecimalPlaces;
            result = new StringBuilder(productStr);
            result.insert(dotPos, '.');
        }
        // 6. 格式化：去掉末尾多余的0
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0' && result.charAt(result.length() - 2) != '.') {
            result.deleteCharAt(result.length() - 1);
        }
        // 添加符号
        if (isNegative) {
            result.insert(0, '-');
        }
        return result.toString();
    }
}
