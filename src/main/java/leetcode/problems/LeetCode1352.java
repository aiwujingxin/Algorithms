package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/26 18:10
 */
public class LeetCode1352 {

    class ProductOfNumbers {

        private List<Integer> products;

        public ProductOfNumbers() {
            products = new ArrayList<>();
            products.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                products = new ArrayList<>();
                products.add(1);
            } else {
                products.add(products.get(products.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            if (products.size() <= k) {
                return 0;
            }
            return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
        }
    }
}
