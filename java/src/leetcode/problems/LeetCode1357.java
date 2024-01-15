package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 18:05
 */
public class LeetCode1357 {

    class Cashier {

        int n;
        int index = 0;
        int discount;
        int[] products;
        int[] prices;
        HashMap<Integer, Integer> map = new HashMap<>();

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount;
            for (int i = 0; i < products.length; i++) {
                map.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            index++;
            if (index % n == 0) {
                double sum = 0;
                int n = product.length;
                for (int i = 0; i < n; i++) {
                    int origin = map.get(product[i]);
                    sum += (origin - (double) (discount * origin) / 100) * amount[i];
                }
                return sum;
            }
            double sum = 0;
            int n = product.length;
            for (int i = 0; i < n; i++) {
                sum += map.get(product[i]) * amount[i];
            }
            return sum;
        }
    }

}
