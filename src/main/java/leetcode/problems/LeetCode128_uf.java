package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/31 00:28
 */
public class LeetCode128_uf {

    public static void main(String[] args) {
        System.out.println(new LeetCode128_uf().longestConsecutive(new int[]{100, 99, 101}));
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();

        for (int n : nums) {
            fathers.put(n, n);
            counts.put(n, 1);
            all.add(n);
        }

        for (int num : nums) {
            if (all.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }
            if (all.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }
        }

        int longest = 0;
        for (int length : counts.values()) {
            longest = Math.max(longest, length);
        }
        return longest;
    }

    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            fathers.put(fatherOfI, fatherOfJ);
            int countOfI = counts.get(fatherOfI);
            int countOfJ = counts.get(fatherOfJ);
            counts.put(fatherOfJ, countOfI + countOfJ);
        }
    }

    private int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }
}
