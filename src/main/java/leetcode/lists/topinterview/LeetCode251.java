package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/5 12:58
 */
public class LeetCode251 {
    class Vector2D {

        private int[][] vector;
        private int inner = 0;
        private int outer = 0;

        public Vector2D(int[][] v) {
            vector = v;
        }

        private void advanceToNext() {
            while (outer < vector.length && inner == vector[outer].length) {
                inner = 0;
                outer++;
            }
        }

        public int next() {
            if (!hasNext()) {
                return -1;
            }
            return vector[outer][inner++];
        }

        public boolean hasNext() {
            advanceToNext();
            return outer < vector.length;
        }
    }
}
