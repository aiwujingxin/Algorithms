package leetcode.problems;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/7 13:49
 */
public class LeetCode488 {

    public int findMinStep(String board, String hand) {
        Queue<String[]> queue = new ArrayDeque<>();
        queue.add(new String[]{board, hand});
        HashSet<String> set = new HashSet<>();
        set.add(board);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String[] strings = queue.poll();
                String curBoard = strings[0];
                String curHand = strings[1];
                char pre = 0;
                for (int i = 0; i < curBoard.length(); i++) {
                    char c = curBoard.charAt(i);
                    for (int j = 0; j < curHand.length(); j++) {
                        char c1 = curHand.charAt(j);
                        if (c == c1 || i > 0 && pre == c) {
                            StringBuilder sb = new StringBuilder(curBoard);
                            sb.insert(i, c1);
                            removeSame(sb, i);
                            if (sb.isEmpty()) {
                                return step + 1;
                            }
                            String newBoard = sb.toString();
                            if (!set.contains(newBoard)) {
                                set.add(newBoard);
                                String newHand = new StringBuilder(curHand).delete(j, j + 1).toString();
                                queue.add(new String[]{newBoard, newHand});
                            }
                        }
                    }
                    pre = c;
                }
            }
            step++;
        }
        return -1;
    }

    void removeSame(StringBuilder sb, int index) {
        if (index < 0) {
            return;
        }
        int left = index - 1, right = index + 1;
        char c = sb.charAt(index);
        while (left >= 0 && sb.charAt(left) == c) {
            left--;
        }
        while (right < sb.length() && sb.charAt(right) == c) {
            right++;
        }
        if (right - left - 1 >= 3) {
            sb.delete(left + 1, right);
            removeSame(sb, left);
        }
    }
}
