package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-12-04 3:29 下午
 */
public class Offer67 {

    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            /*
                这里这个条件的意思为，因为题目要求不能超过int范围，所以需要判断结果是否越界
                因为res每次都会 * 10 ，所以外面定义了一个int最大值除以10的数字
                此时只需要保证本次循环的res * 10 + chars[j] 不超过 int 即可保证不越界
                res > number 意思是，此时res已经大于number了，他 * 10 一定越界
                res == number && chars[j] > '7' 的意思是，当res == number时，即：214748364
                此时res * 10 变成 2147483640 此时没越界，但是还需要 + chars[j]，
                而int最大值为 2147483647，所以当chars[j] > 7 时会越界
             */
            if (res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

}
