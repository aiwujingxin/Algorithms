package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/10 15:03
 */
public class LeetCode8_v1 {
    public int myAtoi(String str) {
        String strTrim = str.trim();    // remove any leading and trailing whitespace
        if (strTrim.length() == 0) {
            return 0;
        }

        int index = 0, sign = 1;
        long result = 0;
        if (strTrim.charAt(index) == '+' || strTrim.charAt(index) == '-') {
            sign = strTrim.charAt(index) == '+' ? 1 : -1;  // get the sign of the number
            index++;
        }
        // convert string to integer without overflow
        while (index < strTrim.length()) {
            int digit = strTrim.charAt(index) - '0';    // get the first digit
            if (digit < 0 || digit > 9) {
                break;
            }

            result = result * 10 + digit; // add the digit to result
            if (result > Integer.MAX_VALUE) {    // detect the overflow
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) (result * sign);
    }
}
