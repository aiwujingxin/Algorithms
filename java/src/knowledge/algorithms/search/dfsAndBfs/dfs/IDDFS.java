package knowledge.algorithms.search.dfsAndBfs.dfs;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 05/21/25 10:44
 * @description 迭代加深搜索
 */
public class IDDFS {
    public static void main(String[] args) {
        int numerator = 4;
        int denominator = 13;
        List<Integer> result = findEgyptianFractions(numerator, denominator);
        System.out.println("埃及分数表示:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print("1/" + result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" + ");
            }
        }
    }

    public static List<Integer> findEgyptianFractions(int numerator, int denominator) {
        List<Integer> result = new ArrayList<>();
        // 迭代加深搜索，从1层开始逐步增加深度
        for (int depth = 1; ; depth++) {
            if (dfs(numerator, denominator, depth, 2, result)) {
                return result;
            }
            result.clear(); // 清除之前尝试的结果
        }
    }

    private static boolean dfs(long remainingNumerator, long remainingDenominator, int remainingDepth, int start, List<Integer> result) {
        // 基本情况：已经找到解
        if (remainingNumerator == 0) {
            return true;
        }

        // 到达最大深度但还没找到解
        if (remainingDepth == 0) {
            return false;
        }

        // 计算下一个单位分数的分母的最小可能值
        // 它应该 ≥ max(start, ceil(1/f)) = max(start, ceil(d/n))
        long minNextDenominator = Math.max(start,
                (remainingDenominator + remainingNumerator - 1) / remainingNumerator);

        // 尝试所有可能的分母
        for (long nextDenominator = minNextDenominator; ; nextDenominator++) {
            // 计算剩余部分
            long newNumerator = remainingNumerator * nextDenominator - remainingDenominator;
            if (newNumerator < 0) {
                continue; // 跳过使剩余部分为负的情况
            }

            long newDenominator = remainingDenominator * nextDenominator;

            // 约分
            long gcd = gcd(newNumerator, newDenominator);
            newNumerator /= gcd;
            newDenominator /= gcd;

            result.add((int) nextDenominator);
            if (dfs(newNumerator, newDenominator, remainingDepth - 1, (int) nextDenominator + 1, result)) {
                return true;
            }
            result.remove(result.size() - 1); // 回溯
        }
    }

    // 计算最大公约数
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
