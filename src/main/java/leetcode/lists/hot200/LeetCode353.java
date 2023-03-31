package leetcode.lists.hot200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/17 14:21
 */
public class LeetCode353 {

    class SnakeGame {

        boolean[][] snake;

        Deque<int[]> queue = new ArrayDeque<>();

        int foodIndex;

        int score;

        int[][] food;

        boolean isLive;

        public SnakeGame(int width, int height, int[][] food) {
            this.snake = new boolean[height][width];
            this.food = food;
            this.snake[0][0] = true;
            this.isLive = true;
            this.queue.add(new int[]{0, 0});
            this.foodIndex = 0;
            this.score = 0;
        }

        public int move(String direction) {
            if (!isLive) {
                return -1;
            }
            int[] next = nextStep(direction);

            if (!canMove(next)) {
                isLive = false;
                return -1;
            }
            if (canEat(next)) {
                score++;
                foodIndex++;
            } else {
                changeTail();
            }
            changeHead(next);
            return score;
        }

        private void changeHead(int[] next) {
            queue.addFirst(next);
            snake[next[0]][next[1]] = true;
        }

        private boolean canMove(int[] next) {
            if (!isLive) {
                return false;
            }
            if (next[0] < 0 || next[1] < 0 || next[0] > snake.length - 1 || next[1] > snake[0].length - 1) {
                return false;
            }
            if (queue.size() <= 4) {
                return true;
            }
            if (queue.peekFirst()[0] == queue.peekLast()[0] && queue.peekFirst()[1] == queue.peekLast()[1]) {
                return true;
            }
            return !snake[next[0]][next[1]];
        }

        private boolean canEat(int[] next) {
            if (!isLive) {
                return false;
            }
            if (foodIndex == food.length) {
                return false;
            }
            return food[foodIndex][0] == next[0] && food[foodIndex][1] == next[1];
        }

        private void changeTail() {
            int[] tail = queue.pollLast();
            snake[tail[0]][tail[1]] = false;
        }

        private int[] nextStep(String direction) {
            int row = queue.peekFirst()[0];
            int col = queue.peekFirst()[1];
            switch (direction) {
                case "R" -> col += 1;
                case "D" -> row += 1;
                case "U" -> row -= 1;
                case "L" -> col -= 1;
            }
            return new int[]{row, col};
        }
    }
}
