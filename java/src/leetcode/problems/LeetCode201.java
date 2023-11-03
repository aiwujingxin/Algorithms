package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 12:32
 */
public class LeetCode201 {

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
