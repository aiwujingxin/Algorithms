package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 17:25
 */
public class LeetCode1496 {

    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(x + "_" + y);
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            }
            if (path.charAt(i) == 'S') {
                y--;
            }
            if (path.charAt(i) == 'E') {
                x++;
            }
            if (path.charAt(i) == 'W') {
                x--;
            }
            if (set.contains(x + "_" + y)) {
                return true;
            }
            set.add(x + "_" + y);
        }
        return false;
    }
}
