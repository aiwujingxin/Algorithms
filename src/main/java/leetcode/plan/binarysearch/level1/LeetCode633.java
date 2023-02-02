package leetcode.plan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 18:08
 */
public class LeetCode633 {

    public static void main(String[] args) {
        System.out.println(new LeetCode633().judgeSquareSum(2147483646));
        System.out.println(new LeetCode633().judgeSquareSum(999999999));
    }

    //https://leetcode.com/problems/sum-of-square-numbers/discuss/2622127/JAVA-or-Binary-Search

    public boolean judgeSquareSum(int c) {
        long s = 0;
        long e = (long) Math.sqrt(c);
        while (s <= e) {
            long mid = s * s + e * e;
            if (mid == (long) c) {
                return true;
            } else if (mid > (long) c) {
                e--;
            } else {
                s++;
            }
        }
        return false;
    }
}
