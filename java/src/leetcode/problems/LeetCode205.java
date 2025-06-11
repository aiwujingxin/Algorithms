package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 12:52
 */
public class LeetCode205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        Arrays.fill(mapS, -1);
        Arrays.fill(mapT, -1);
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (mapS[sc] == -1 && mapT[tc] == -1) {
                mapS[sc] = tc;
                mapT[tc] = sc;
            } else if (mapS[sc] != tc || mapT[tc] != sc) {
                return false;
            }
        }
        return true;
    }
}
