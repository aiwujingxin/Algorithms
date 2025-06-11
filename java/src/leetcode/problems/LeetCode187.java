package leetcode.problems;

import knowledge.datastructure.string.search.impl.RabinKarp;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 11:35
 * @description RabinKarp解法
 * @see RabinKarp
 */
public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            nums[i] = c == 'A' ? 1 : c == 'C' ? 2 : c == 'G' ? 3 : 4;
        }
        int mul = 4;
        int pow = 1;
        for (int i = 0; i < 9; i++) {
            pow *= mul;
        }
        int right = 0;
        int left = 0;
        int hash = 0;
        HashSet<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        while (right < n) {
            hash = hash * mul + nums[right];
            while (right - left + 1 == 10) {
                if (set.contains(hash)) {
                    res.add(s.substring(left, right + 1));
                }
                set.add(hash);
                hash = hash - pow * nums[left];
                left++;
            }
            right++;
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences_map(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String t = s.substring(i, i + 10);
            map.put(t, map.getOrDefault(t, 0) + 1);
            if (map.get(t) >= 2) {
                set.add(t);
            }
        }
        return new ArrayList<>(set);
    }
}
