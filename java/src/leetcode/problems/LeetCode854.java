package leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/30 17:50
 */
public class LeetCode854 {

    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis = new HashSet<>();

        ArrayDeque<String> queue = new ArrayDeque<>();
        int level = 0;
        queue.add(s1);

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String rem = queue.remove();
                if (vis.contains(rem)) {
                    continue;
                }
                vis.add(rem);
                if (rem.equals(s2)) {
                    return level;
                }
                for (String s : getNeighbors(rem, s2)) {
                    if (!vis.contains(s)) {
                        queue.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
    }


    // 获取邻居比较复杂
    public ArrayList<String> getNeighbors(String rem, String s2) {
        ArrayList<String> res = new ArrayList<>();

        int idx = -1;
        for (int i = 0; i < rem.length(); i++) {
            if (rem.charAt(i) != s2.charAt(i)) {
                idx = i;
                break;
            }
        }

        for (int j = idx + 1; j < rem.length(); j++) {
            if (rem.charAt(j) == s2.charAt(idx)) {
                String s = swap(rem, idx, j);
                res.add(s);
            }
        }

        return res;
    }

    public String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);

        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);

        return sb.toString();
    }
}
