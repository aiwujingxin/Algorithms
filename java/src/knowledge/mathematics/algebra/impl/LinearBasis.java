package knowledge.mathematics.algebra.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 异或线性基 (Linear Basis over GF(2))
 * <适用场景>
 * 一组数在异或意义下的“张成空间”。凡是问“子集异或能否得到 x”“异或最大/最小值”
 * “异或第 k 小”“本质不同的异或值个数”，都是线性基的直接应用。
 * <核心不变量>
 * basis[i] 若非零，则其最高位恰为第 i 位；插入时不断用高位基消去当前数的最高位，
 * 最终要么被完全消为 0（可被已有基表出），要么在某空位落地成为新基。
 * <本质>
 * 把 n 个数压缩成至多 63 个线性无关的基向量，秩即线性无关个数，
 * 可表出的不同异或值共 2^rank 个。
 */
public class LinearBasis {

    private static final int BITS = 63;
    private final long[] basis = new long[BITS + 1];
    private int size;

    /**
     * 插入一个数；若它扩充了基则返回 true。
     */
    public boolean insert(long value) {
        for (int bit = BITS; bit >= 0; bit--) {
            if (((value >> bit) & 1) == 0) continue;
            if (basis[bit] == 0) {
                basis[bit] = value;
                size++;
                return true;
            }
            value ^= basis[bit];
        }
        return false;
    }

    /**
     * 判断 value 能否由已插入元素的子集异或得到。
     */
    public boolean canRepresent(long value) {
        for (int bit = BITS; bit >= 0; bit--) {
            if (((value >> bit) & 1) == 1) value ^= basis[bit];
        }
        return value == 0;
    }

    /**
     * 子集异或能取到的最大值。
     */
    public long maxXor() {
        long result = 0;
        for (int bit = BITS; bit >= 0; bit--) {
            if ((result ^ basis[bit]) > result) result ^= basis[bit];
        }
        return result;
    }

    /**
     * 子集异或能取到的最小非零值（不含空集的 0）。
     */
    public long minXor() {
        for (int bit = 0; bit <= BITS; bit++) {
            if (basis[bit] != 0) return basis[bit];
        }
        return 0;
    }

    /**
     * 线性基的秩：可表出 2^rank 个不同的异或值。
     */
    public int rank() {
        return size;
    }
}
