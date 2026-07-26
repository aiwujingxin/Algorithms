package knowledge.algorithms.bit;

import knowledge.algorithms.dp.compressdp.CompressDP;
import knowledge.datastructure.adv.BIT.BITree;
import knowledge.datastructure.adv.BIT.BITree2D;
import knowledge.datastructure.adv.BIT.BITreeKth;
import knowledge.datastructure.adv.BIT.BITreeMax;
import knowledge.datastructure.adv.BIT.BITreeRange;
import knowledge.datastructure.adv.BIT.BITreeRangeMax;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 01:29
 * @description 位运算核心技巧与经典题单
 * <基础题>
 * @see LeetCode476      数字的补数
 * @see LeetCode693      交替位二进制数
 * @see LeetCode231      2 的幂
 * @see LeetCode342      4 的幂
 * @see LeetCode191      位 1 的个数
 * @see LeetCode338      比特位计数
 * @see LeetCode190      颠倒二进制位
 * <与>
 * @see LeetCode2275     按位与结果大于零的最长组合
 * @see LeetCode2419     按位与最大的最长子数组
 * @see LeetCode2871     将数组分割成最多数目的子数组
 * @see LeetCode2401     最长优雅子数组
 * @see LeetCode201      数字范围按位与
 * @see LeetCode3133     数组最后一个元素的最小值
 * @see LeetCode2941     子数组的最大 GCD-Sum
 * <或>
 * @see LeetCode2568     最小无法得到的或值
 * @see LeetCode898      子数组按位或操作
 * @see LeetCode2411     按位或最大的最小子数组长度
 * <异或>
 * @see LeetCode136      只出现一次的数字
 * @see LeetCode260      只出现一次的数字 III
 * @see LeetCode137      只出现一次的数字 II
 * @see LeetCode645      错误的集合
 * @see LeetCode3215     用偶数异或设置位计数三元组 II
 * <BITree>
 * @see BITree           树状数组 (单点改 + 前缀和查)
 * @see BITree2D         二维树状数组 (单点改 + 矩形和查)
 * @see BITreeRange      区间改区间查树状数组 (差分双 BIT)
 * @see BITreeKth        权值树状数组 (第 K 小 / 逆序对)
 * @see BITreeMax        前缀最大值树状数组
 * @see BITreeRangeMax   区间最大值树状数组
 * @see XorBasis         线性基 (子集异或最大/最小/第 K 小)
 * <Trie树>
 * @see LeetCode421      数组中两个数的最大异或值
 * @see LeetCode1707     与数组中元素的最大异或值
 * @see LeetCode3344     最大尺寸数组
 * <模拟算术>
 * @see LeetCode67       二进制求和
 * @see LeetCode371      两整数之和
 * @see LeetCode29       两数相除
 * <其他综合>
 * @see LeetCode1017     负二进制转换
 * @see LeetCode1558     得到目标数组的最少函数调用次数
 * @see LeetCode2571     将整数减少到零需要的最少操作数
 * @see LeetCode89       格雷编码
 * @see LeetCode405      数字转换为十六进制数
 * @see LeetCode1680     连接连续二进制数字
 * @see LeetCode477      汉明距离总和
 * @see LeetCode2425     所有数对的异或和
 * @see LeetCode2275     按位与结果大于零的最长组合
 * @see LeetCode2505     所有子序列和的按位或
 * @see LeetCode3153     所有数对中数位不同之和
 * <状态压缩>
 * @see CompressDP       状压DP
 * @see LeetCode318      最大单词长度乘积
 * @see LeetCode187      重复的DNA序列
 * @see LeetCode762      二进制表示中质数个计算置位
 * @see LeetCode2680     最大或值
 * @see LeetCode2220     转换数字的最少位翻转次数
 * @see LeetCode1386     安排电影院座位
 * <子集与组合>
 * @see LeetCode78       子集
 * @see LeetCode90       子集 II
 * @see LeetCode1178     猜字谜
 */
public interface BIT {

    // 位掩码 0x55555555    （二进制  0101010101⋯01，偶数位为1）
    // 位掩码 0xAAAAAAAA    （二进制  1010101010⋯10，奇数位为1）
    // 位掩码 a = -1;       （二进制  111...1111111）和任何数 AND 都等于那个数

    // ================= 基础操作 =================
    // 取最低位 1 (例如 1010 -> 0010)
    static int lowbit(int x) {
        return x & -x;
    }

    // 移除最低位 1
    static int removeLastBit(int x) {
        return x & (x - 1);
    }

    // 提取某一位 (从低位 0 开始)
    static int getBit(int x, int i) {
        return (x >> i) & 1;
    }

    // 设置某一位为 1
    static int setBit(int x, int i) {
        return x | (1 << i);
    }

    // 清除某一位为 0
    static int clearBit(int x, int i) {
        return x & ~(1 << i);
    }

    // 翻转某一位 (0变1, 1变0)
    static int toggleBit(int x, int i) {
        return x ^ (1 << i);
    }

    // ================= 属性判断 =================
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

    // 判断是否为 4 的幂
    static boolean isPowerOfFour(int x) {
        return x > 0 && (x & (x - 1)) == 0 && (x & 0x55555555) != 0;
    }

    // 判断两个整数是否符号相反 (0 被视为正数)
    static boolean hasOppositeSigns(int x, int y) {
        return (x ^ y) < 0;
    }

    // ================= 进阶计算 =================
    // 计算二进制 1 的个数 Integer.bitCount(x)
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
            int carry = (a & b) << 1; // 进位
            a ^= b;                   // 无进位加法
            b = carry;
        }
        return a;
    }

    // 翻转二进制位（32 位） API: Integer.reverse(n)
    static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1; // 必须是无符号右移
        }
        return res;
    }

    //  获取最高位的 1 (例如 00101100 -> 00100000) API: Integer.highestOneBit(x)
    static int highestOneBit(int x) {
        x |= (x >> 1);
        x |= (x >> 2);
        x |= (x >> 4);
        x |= (x >> 8);
        x |= (x >> 16);
        return x - (x >>> 1);
    }

    // 将数字拆解为 32 位数组
    static int[] toBinaryArray(int num) {
        int[] a = new int[32];
        for (int i = 0; i < 32; i++) {
            // a[0] 是最高位(符号位), a[31] 是最低位
            a[i] = (num >> (31 - i)) & 1;
        }
        return a;
    }
}
