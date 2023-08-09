package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-11-22 10:58 下午
 */
public class Offer44 {

    public static void main(String[] args) {
        //1 2 3 4 5 6 7 8 9 1 0 1 1 1 2 1 3
        System.out.println(new Offer44().findNthDigit(29));
    }

    public int findNthDigit(int n) {
        int start = 1;
        int digitNum = 1;
        long base = 9;
        while (n > digitNum * base) {
            n -= digitNum * base;
            start *= 10;
            base *= 10;
            digitNum++;
        }
        start += (n - 1) / digitNum;
        String s = String.valueOf(start);
        char c = s.charAt((n - 1) % digitNum);
        return c - '0';
    }
}