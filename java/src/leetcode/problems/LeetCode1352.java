package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/26 18:10
 */
public class LeetCode1352 {

    class ProductOfNumbers {

        List<Long> psum;

        public ProductOfNumbers() {
            this.psum = new ArrayList<>();
        }

        public void add(int num) {
            if (num == 0) {
                this.psum = new ArrayList<>();
            } else {
                if (psum.isEmpty()) {
                    psum.add(1L);
                }
                psum.add(psum.get(psum.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            if (psum.size() <= k) {
                return 0;
            }
            return (int) (psum.get(psum.size() - 1) / psum.get(psum.size() - 1 - k));
        }
    }
}