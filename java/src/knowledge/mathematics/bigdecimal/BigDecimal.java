package knowledge.mathematics.bigdecimal;

import knowledge.mathematics.bigdecimal.impl.*;
import leetcode.problems.LeetCode166;
import leetcode.problems.LeetCode29;
import leetcode.problems.LeetCode415;
import leetcode.problems.LeetCode43;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/5 13:23
 * @description 高精度计算模板与题型导航
 * <解题识别>
 * 结果位数超过 long，或题目明确禁止使用 BigInteger 时，使用字符串/数组模拟竖式运算。
 * <表示方式>
 * - 十进制字符串:输入输出自然，逐位运算直观。
 * - int[] 分块:每格存 10^4/10^9，位数很大时显著减少循环次数。
 * - 逆序链表:低位在前，天然适配进位和借位。
 * <核心纪律>
 * 1. 符号、前导零、小数点与绝对值运算分层处理。
 * 2. 加减统一维护 carry/borrow；减法先比较绝对值决定符号。
 * 3. 乘法结果数组长度最多 m+n；除法按“当前余数试商”逐位推进。
 * 4. 工程代码优先 java.math.BigInteger/BigDecimal；手写模板主要用于理解和受限题目。
 * <模板索引>
 * @see BigDecimalAdd  字符串加法
 * @see BigDecimalSub  字符串减法
 * @see BigDecimalMul 字符串乘法
 * @see knowledge.mathematics.bigdecimal.impl.Karatsuba Karatsuba乘法 (O(n^1.58))
 * @see BigDecimalDiv 字符串除法
 * @see knowledge.mathematics.bigdecimal.impl.BigDecimalPow 高精度快速幂
 * @see knowledge.mathematics.bigdecimal.impl.BigDecimalSqrt 高精度开平方 (Newton's Method)
 * @see knowledge.mathematics.bigdecimal.impl.BigNumberMod 大数取模与大指数快速幂
 * @see knowledge.mathematics.bigdecimal.impl.BigGcd 大数最大公约数 (Stein 算法)
 * @see knowledge.mathematics.bigdecimal.impl.BaseConversion 大数任意进制转换 (2..36)
 * @see knowledge.mathematics.bigdecimal.impl.RepeatingDecimal 分数转小数 (循环节标注)
 * @see LinkedListAdd  逆序链表加法
 * @see LinkedListSub  逆序链表减法
 * <代表题目>
 * @see LeetCode415 [E] 字符串相加
 * @see LeetCode43  [M] 字符串相乘
 * @see LeetCode29  [M] 两数相除
 * @see LeetCode166 [M] 分数到小数（余数首次位置用于识别循环节）
 */
public interface BigDecimal {
}
