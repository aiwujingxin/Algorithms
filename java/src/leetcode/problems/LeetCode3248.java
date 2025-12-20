package leetcode.problems;

import java.util.List;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 12/16/25 13:53
 */
public class LeetCode3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for(String c : commands) {
            if(Objects.equals(c, "DOWN")) {
                x++;
            }
            if(Objects.equals(c, "RIGHT")) {
                y++;
            }
            if(Objects.equals(c, "UP")) {
                x--;
            }
            if(Objects.equals(c, "LEFT")) {
                y--;
            }
        }
        System.out.println(x);
        System.out.println(y);
        return (x * n) + y;
    }
}
