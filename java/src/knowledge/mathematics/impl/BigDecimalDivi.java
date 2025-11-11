package knowledge.mathematics.impl;

import leetcode.problems.LeetCode29;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 11/11/25 22:12
 * @see LeetCode29 除
 */
public class BigDecimalDivi {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideInteger("17", "7")));
        System.out.println(divideDecimal("17", "7", 3));
    }

    public String divide(String dividend, int divisor) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < dividend.length(); i++) {
            int t = dividend.charAt(i) - '0' + carry * 10;
            int currentResult = t / divisor;
            carry = t % divisor;
            sb.append(currentResult);
        }
        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.isEmpty()) {
            return "0";
        }
        return sb.toString();
    }

    /**
     * 高精度整数除法 (纯数字字符串)
     *
     * @return String[] {商, 余数}
     */
    private static String[] divideInteger(String dividend, String divisor) {
        if ("0".equals(divisor)) throw new ArithmeticException("Division by zero");
        if (compare(dividend, divisor) < 0) return new String[]{"0", dividend};
        StringBuilder quotient = new StringBuilder();
        String remainder = "";
        int dividendIndex = 0;
        while (dividendIndex < dividend.length()) {
            remainder += dividend.charAt(dividendIndex++);
            while (remainder.startsWith("0") && remainder.length() > 1) {
                remainder = remainder.substring(1);
            }
            if (compare(remainder, divisor) < 0) {
                if (!quotient.isEmpty()) quotient.append('0');
                continue;
            }
            int currentQuotientDigit = 0;
            String tempRemainder = remainder;
            for (int i = 9; i >= 1; i--) {
                String product = "0";
                // 模拟 i * divisor
                for (int k = 0; k < i; k++) {
                    product = BigDecimalAdd.addStrings(product, divisor);
                }
                if (compare(tempRemainder, product) >= 0) {
                    currentQuotientDigit = i;
                    remainder = BigDecimalSub.subtract(tempRemainder, product);
                    break;
                }
            }
            quotient.append(currentQuotientDigit);
        }
        if (quotient.isEmpty()) quotient.append('0');
        if (remainder.isEmpty()) remainder = "0";
        return new String[]{quotient.toString(), remainder};
    }

    /**
     * 比较两个纯数字字符串的大小 (不处理符号)
     */
    private static int compare(String num1, String num2) {
        if (num1.length() > num2.length()) return 1;
        if (num1.length() < num2.length()) return -1;
        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) > num2.charAt(i)) return 1;
            if (num1.charAt(i) < num2.charAt(i)) return -1;
        }
        return 0;
    }

    // ========================================================================
    // 2. 新的整数除法，只返回商 (private static)
    // ========================================================================

    private static String divideAndGetQuotient(String dividend, String divisor) {
        if ("0".equals(divisor)) throw new ArithmeticException("Division by zero");
        if (compare(dividend, divisor) < 0) return "0";
        StringBuilder quotient = new StringBuilder();
        String remainder = "";
        int dividendIndex = 0;
        while (dividendIndex < dividend.length()) {
            remainder += dividend.charAt(dividendIndex++);
            while (remainder.startsWith("0") && remainder.length() > 1) {
                remainder = remainder.substring(1);
            }
            if (compare(remainder, divisor) < 0) {
                // 【修正 2】: 使用 length()
                if (!quotient.isEmpty()) quotient.append('0');
                continue;
            }
            int currentQuotientDigit = 0;
            for (int i = 9; i >= 1; i--) {
                String product = BigDecimalMuti.multiply(divisor, String.valueOf(i));
                if (compare(remainder, product) >= 0) {
                    currentQuotientDigit = i;
                    // 【修正 3】: 调用本类的辅助函数
                    remainder = BigDecimalSub.subtract(remainder, product);
                    break;
                }
            }
            quotient.append(currentQuotientDigit);
        }
        if (quotient.isEmpty()) return "0";
        return quotient.toString();
    }

    // ========================================================================
    // 3. 最终的小数除法 (已修正)
    // ========================================================================
    public static String divideDecimal(String num1, String num2, int precision) {
        if ("0".equals(num2)) throw new ArithmeticException("Division by zero");
        if ("0".equals(num1)) return "0";
        // 【修正 1 的说明】: 你的符号处理逻辑是正确的，无需修改
        boolean isNegative = false;
        if (num1.startsWith("-")) {
            isNegative = true;
            num1 = num1.substring(1);
        }
        if (num2.startsWith("-")) {
            isNegative = !isNegative;
            num2 = num2.substring(1);
        }
        int decPlaces1 = num1.contains(".") ? num1.length() - num1.indexOf('.') - 1 : 0;
        int decPlaces2 = num2.contains(".") ? num2.length() - num2.indexOf('.') - 1 : 0;
        String intStr1 = num1.replace(".", "");
        String intStr2 = num2.replace(".", "");
        int zerosToPad = precision + decPlaces2 - decPlaces1;
        if (zerosToPad > 0) {
            intStr1 += "0".repeat(zerosToPad);
        } else if (zerosToPad < 0) {
            intStr1 = intStr1.substring(0, intStr1.length() + zerosToPad);
        }
        String quotientStr = divideAndGetQuotient(intStr1, intStr2);
        StringBuilder result;
        if (quotientStr.length() <= precision) {
            int zerosToPrepend = precision - quotientStr.length();
            result = new StringBuilder("0.");
            result.append("0".repeat(zerosToPrepend));
            result.append(quotientStr);
        } else {
            int dotPos = quotientStr.length() - precision;
            result = new StringBuilder(quotientStr);
            result.insert(dotPos, '.');
        }
        // 【修正 4】: 改进格式化逻辑
        // 1. 去掉末尾多余的0 (仅当有小数点时)
        if (result.toString().contains(".")) {
            while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
                result.deleteCharAt(result.length() - 1);
            }
        }
        // 2. 如果最后一位是小数点, 也去掉
        if (!result.isEmpty() && result.charAt(result.length() - 1) == '.') {
            result.deleteCharAt(result.length() - 1);
        }
        // 如果结果是空或0，确保返回"0"
        if (result.isEmpty() || "0".contentEquals(result)) {
            return "0";
        }
        if (isNegative) {
            result.insert(0, '-');
        }
        return result.toString();
    }
}
