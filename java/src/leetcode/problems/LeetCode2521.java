package leetcode.problems;

import knowledge.mathematics.impl.Prime;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 22:25
 */
public class LeetCode2521 {

    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            for (int j = 2; j <= num; j++) {
                if (num % j == 0) {
                    if (Prime.isPrime(j)) {
                        set.add(j);
                    }
                }
            }
        }
        return set.size();
    }
}
