package knowledge.mathematics.bigdecimal.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 大数最大公约数 (二进制 GCD / Stein 算法)
 * <适用场景>
 * 两个超长十进制整数求 gcd。欧几里得需要大数取模（大数除法），
 * 而 Stein 算法只用“减法、折半、判奇偶”，用字符串即可高效实现。
 * <核心思想>
 * gcd(2a,2b)=2gcd(a,b)；gcd(2a,b)=gcd(a,b)（b 奇）；两奇数则 gcd(a,b)=gcd(|a-b|,min)。
 * 折半和判奇偶在十进制串上均可 O(len) 完成，避免实现大数除法。
 */
public class BigGcd {

    /**
     * 非负大整数字符串的最大公约数。
     */
    public static String gcd(String a, String b) {
        a = trim(a);
        b = trim(b);
        if (a.equals("0")) return b;
        if (b.equals("0")) return a;

        int shift = 0;
        while (isEven(a) && isEven(b)) {
            a = halve(a);
            b = halve(b);
            shift++;
        }
        while (isEven(a)) a = halve(a);
        while (!b.equals("0")) {
            while (isEven(b)) b = halve(b);
            if (compare(a, b) > 0) {
                String temp = a;
                a = b;
                b = temp;
            }
            b = subtract(b, a);   // b >= a
        }
        // 补回公共的 2^shift
        for (int i = 0; i < shift; i++) a = doubleValue(a);
        return a;
    }

    private static boolean isEven(String s) {
        return ((s.charAt(s.length() - 1) - '0') & 1) == 0;
    }

    // 整除 2
    private static String halve(String s) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = carry * 10 + (s.charAt(i) - '0');
            result.append(current / 2);
            carry = current % 2;
        }
        return trim(result.toString());
    }

    // 乘 2
    private static String doubleValue(String s) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = (s.charAt(i) - '0') * 2 + carry;
            result.append(current % 10);
            carry = current / 10;
        }
        if (carry > 0) result.append(carry);
        return result.reverse().toString();
    }

    // 大减小 (要求 a >= b)
    private static String subtract(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, borrow = 0;
        while (i >= 0) {
            int diff = (a.charAt(i--) - '0') - borrow - (j >= 0 ? b.charAt(j--) - '0' : 0);
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
        }
        return trim(result.reverse().toString());
    }

    private static int compare(String a, String b) {
        if (a.length() != b.length()) return a.length() - b.length();
        return a.compareTo(b);
    }

    private static String trim(String s) {
        int start = 0;
        while (start < s.length() - 1 && s.charAt(start) == '0') start++;
        return s.substring(start);
    }
}
