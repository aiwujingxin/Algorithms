package knowledge.mathematics.bigdecimal.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 大数任意进制转换 (2..36)
 * <适用场景>
 * 超长整数在十进制与任意 2..36 进制之间互转，超出 long 范围仍成立。
 * <核心思想>
 * 十进制 -> 目标进制：对十进制串反复整除 base 收集余数（低位在前），最后反转。
 * 源进制 -> 十进制：Horner 迭代 acc = acc*base + digit，全程用大数串乘小数、加小数。
 */
public class BaseConversion {

    private static final String DIGITS = "0123456789abcdefghijklmnopqrstuvwxyz";

    /**
     * 十进制大整数字符串转 base 进制（小写字母表示 10 以上数位）。
     */
    public static String fromDecimal(String decimal, int base) {
        String current = trim(decimal);
        if (current.equals("0")) return "0";
        StringBuilder result = new StringBuilder();
        while (!current.equals("0")) {
            int remainder = 0;
            StringBuilder quotient = new StringBuilder();
            for (int i = 0; i < current.length(); i++) {
                int value = remainder * 10 + (current.charAt(i) - '0');
                quotient.append(value / base);
                remainder = value % base;
            }
            result.append(DIGITS.charAt(remainder));
            current = trim(quotient.toString());
        }
        return result.reverse().toString();
    }

    /**
     * base 进制字符串转十进制大整数字符串。
     */
    public static String toDecimal(String number, int base) {
        String accumulator = "0";
        for (int i = 0; i < number.length(); i++) {
            int digit = DIGITS.indexOf(Character.toLowerCase(number.charAt(i)));
            accumulator = addSmall(mulSmall(accumulator, base), digit);
        }
        return accumulator;
    }

    // 大数串乘小数
    private static String mulSmall(String number, int factor) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int product = (number.charAt(i) - '0') * factor + carry;
            result.append(product % 10);
            carry = product / 10;
        }
        while (carry > 0) {
            result.append(carry % 10);
            carry /= 10;
        }
        return trim(result.reverse().toString());
    }

    // 大数串加小数
    private static String addSmall(String number, int addend) {
        StringBuilder result = new StringBuilder();
        int carry = addend;
        for (int i = number.length() - 1; i >= 0; i--) {
            int sum = (number.charAt(i) - '0') + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        while (carry > 0) {
            result.append(carry % 10);
            carry /= 10;
        }
        return trim(result.reverse().toString());
    }

    private static String trim(String s) {
        int start = 0;
        while (start < s.length() - 1 && s.charAt(start) == '0') start++;
        return s.substring(start);
    }
}
