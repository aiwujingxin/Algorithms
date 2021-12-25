package jove;

/**
 * @author jingxinwu
 * @date 2021-12-23 7:07 PM
 */

/**
 * 第三题： 计算bit位  1)获取二进制正数中1位的数量  2)获取二进制补码中1位的数量
 */
public class Number03 {

    //11
    public static void main(String[] args) {
        System.out.println(new Number03().count(9999));//10011100001111  =8
        System.out.println(new Number03().count(7));//0000 0111  =3
//        System.out.println(new Number03().count1(-7));//原码：10000111，==  1111 1000    1111 1001 ==6
    }

    public int count(int n) {

        if (n == 0) {
            return 0;
        }
        int count = 0;
        int bit = 1;
        while (n > 0) {
            if ((n & bit) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int count1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n > 0) {
            int count = 0;
            int bit = 1;
            while (n > 0) {
                if ((n & bit) == 1) {
                    count++;
                }
                n = n >> 1;
            }
            return count;
        } else {
            //TODO
            return -1;
        }
    }
}
