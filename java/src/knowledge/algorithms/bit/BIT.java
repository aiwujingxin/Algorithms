package knowledge.algorithms.bit;

import knowledge.algorithms.dp.compressdp.CompressDP;
import knowledge.datastructure.adv.BITree;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 01:29
 * @description 位运算
 * <基础操作>
 * @see LeetCode67       二进制求和
 * @see LeetCode136      只出现一次的数字
 * @see LeetCode137      只出现一次的数字 II
 * @see LeetCode191      位1的个数
 * @see LeetCode231      2 的幂 (x & (x - 1))
 * @see LeetCode260      只出现一次的数字 III
 * @see LeetCode342      4 的幂
 * @see LeetCode190      颠倒二进制位
 * @see LeetCode201      数字范围按位与
 * @see LeetCode371      两整数之和
 * @see LeetCode405      数字转换为十六进制数
 * @see LeetCode1680     连接连续二进制数字
 * <进阶掩码应用>
 * @see CompressDP       状压DP
 * @see BITree           树状数组 (lowbit 应用)
 * @see LeetCode318      最大单词长度乘积 (位掩码判交集)
 * @see LeetCode421      数组中两个数的最大异或值 (Trie + XOR)
 * @see LeetCode762      二进制表示中质数个计算置位
 * @see LeetCode2680     最大或值
 * @see LeetCode2220     转换数字的最少位翻转次数
 * @see LeetCode1386     安排电影院座位
 * <组合与生成>
 * @see LeetCode78       子集生成 (位枚举)
 * @see LeetCode90       子集 II
 * @see LeetCode89       格雷编码
 * @see LeetCode1017     负二进制转换
 * @see LeetCode1558     得到目标数组的最少函数调用次数
 * <与>
 * @see LeetCode2275     按位与结果大于零的最长组合
 * @see LeetCode2419     按位与最大的最长子数组
 */
public interface BIT {

    // 位掩码 0x55555555    （二进制  0101010101⋯01）
    // 位掩码 ~0x55555555   （二进制  1010101010⋯10）

    // 取最低位 1
    static int lowbit(int x) {
        return x & -x;
    }

    // 移除最低位 1
    static int removeLastBit(int x) {
        return x - (x & -x);
    }

    // 判断奇数
    static boolean isOdd(int x) {
        return (x & 1) == 1;
    }

    // 判断偶数
    static boolean isEven(int x) {
        return (x & 1) == 0;
    }

    // 判断是否为 2 的幂
    static boolean isPowerOfTwo(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }

    static boolean isPowerOfFour(int x) {
        return x > 0 && (x & (x - 1)) == 0 && (x & 0x55555555) > 0;
    }

    // 计算二进制 1 的个数
    static int bitCount(int x) {
        int cnt = 0;
        while (x != 0) {
            x &= (x - 1); // 每次去掉最低位 1
            cnt++;
        }
        return cnt;
    }

    // 不用加号实现加法
    static int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }

    // 翻转二进制位（32 位）
    static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }

    // 提取某一位 (从低位 0 开始)
    static int getBit(int x, int i) {
        return (x >> i) & 1;
    }

    // 设置某一位为 1
    static int setBit(int x, int i) {
        return x | (1 << i);
    }

    // 清除某一位
    static int clearBit(int x, int i) {
        return x & ~(1 << i);
    }

    // 翻转某一位
    static int toggleBit(int x, int i) {
        return x ^ (1 << i);
    }
}
