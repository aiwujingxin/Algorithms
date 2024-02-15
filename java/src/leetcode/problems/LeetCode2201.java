package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 12:53
 */
public class LeetCode2201 {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<Integer> set = new HashSet<>();
        for (int[] position : dig) {
            set.add(position[0] * n + position[1]);
        }
        int count = 0;
        for (int[] artifact : artifacts) {
            int startRow = artifact[0], startCol = artifact[1], endRow = artifact[2], endCol = artifact[3];
            boolean extracted = true;
            for (int i = startRow; i <= endRow && extracted; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    if (!set.contains(i * n + j)) {
                        extracted = false;
                        break;
                    }
                }
            }
            if (extracted) {
                count++;
            }
        }
        return count;
    }
}
