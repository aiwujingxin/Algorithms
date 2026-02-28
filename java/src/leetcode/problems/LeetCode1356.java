package leetcode.problems;

import java.util.stream.IntStream;

/**
 * @author wujingxinit@outlook.com
 * @date 2/25/26 00:06
 */
public class LeetCode1356 {

    public int[] sortByBits(int[] arr) {
        return IntStream.of(arr)
                .boxed()
                .sorted((a, b) -> {
                    int ca = Integer.bitCount(a);
                    int cb = Integer.bitCount(b);
                    return ca != cb ? ca - cb : a - b;
                })
                .mapToInt(a -> a)
                .toArray();
    }
}
