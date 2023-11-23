package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 12:19
 */
public class Offer67 {

    public int strToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        boolean flag = false;
        int bound = Integer.MAX_VALUE / 10;
        int index = 0;
        if (str.charAt(0) == '-') {
            flag = true;
            index = 1;
        } else if (str.charAt(0) == '+') {
            index = 1;
        }
        long num = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            if (num > bound || num == bound && str.charAt(index) - '0' > 7) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + (str.charAt(index) - '0');
            index++;
        }
        if (flag) {
            return num > Integer.MAX_VALUE ? Integer.MIN_VALUE : -1 * (int) num;
        }
        return num > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) num;
    }
}
