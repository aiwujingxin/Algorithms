package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/8 18:13
 */
public class LeetCode874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "_" + obstacles[i][1]);
        }

        char direction = 'U';
        int max = 0;
        for (int i = 0; i < commands.length; i++) {

            if (commands[i] == -2) {
                direction = turnLeft(direction);
            } else if (commands[i] == -1) {
                direction = turnRight(direction);
            } else {
                int step = commands[i];

                switch (direction) {
                    case 'U':
                        for (int u = 1; u <= step; u++) {
                            if (set.contains(x + "_" + (y + u))) {
                                break;
                            }
                        }
                        break;
                    case 'D':
                        int d;
                        for (d = 1; d <= step; d++) {
                            if (set.contains(x + "_" + (y - d))) {
                                break;
                            }
                        }
                        y = y - (d - 1);
                        break;
                    case 'L':
                        int l;
                        for (l = 1; l <= step; l++) {
                            if (set.contains((x - l) + "_" + y)) {
                                break;
                            }

                        }
                        x -= (l - 1);
                        break;
                    case 'R':
                        int r;
                        for (r = 1; r <= step; r++) {
                            if (set.contains((x + r) + "_" + y)) {
                                break;
                            }
                        }
                        x += (r - 1);
                        break;
                }
            }
            // System.out.println("x " + x + " y " + y);
            max = Math.max(max, x * x + y * y);
        }

        return max;
    }

    private char turnRight(char direction) {
        if (direction == 'U') {
            return 'R';
        }
        if (direction == 'R') {
            return 'D';
        }
        if (direction == 'L') {
            return 'U';
        }
        if (direction == 'D') {
            return 'L';
        }
        return ' ';
    }

    private char turnLeft(char direction) {
        if (direction == 'U') {
            return 'L';
        }
        if (direction == 'R') {
            return 'U';
        }
        if (direction == 'L') {
            return 'D';
        }
        if (direction == 'D') {
            return 'R';
        }
        return ' ';
    }
}
