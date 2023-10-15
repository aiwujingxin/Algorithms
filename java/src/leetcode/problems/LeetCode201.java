package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/15 11:59
 */
public class LeetCode201 {

    public static void main(String[] args) {
        System.out.println(new LeetCode201().rangeBitwiseAnd(5, 7));
    }

    //对所有数字执行按位与运算的结果是所有对应二进制字符串的公共前缀再用零补上后面的剩余位
    public int rangeBitwiseAnd(int left, int right) {
        int offset = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            offset++;
        }
        return left << offset;
    }
}
