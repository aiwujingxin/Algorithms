package leetCode.study.recursive;

/**
 * @author jingxinwu
 * @date 2022-01-31 2:22 PM
 */
public class Add {

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     * 示例:
     * 输入: a = 1, b = 1
     * 输出: 2
     * 提示：
     * a,b均可能是负数或 0
     * 结果不会溢出 32 位整数
     *
     * @author ronaldwu
     * @date 2022-01-31 14:23:01
     **/

    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }

}
