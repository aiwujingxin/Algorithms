package leetCode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-22 10:58 下午
 */
public class Offer44 {

    public static void main(String[] args) {
        //1 2 3 4 5 6 7 8 9 1 0 1 1 1 2 1 3
        System.out.println(new Offer44().findNthDigit(490));
    }

    public int findNthDigit(int n) {
        int digit = 1;   // n所在数字的位数
        long start = 1;  // 数字范围开始的第一个数
        long count = 9;  // 占多少位

        //1、确定所求数位的所在数字的位数 n
        while (n > count) {//到不了digit + 1 位数，那就在digit位数
            //n 一直在减，剩余多少个数
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }

        //2、确定所求数位所在的数字 num
        long num = start + (n - 1) / digit;

        //3、确定所求数位在 num 的哪一数位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
