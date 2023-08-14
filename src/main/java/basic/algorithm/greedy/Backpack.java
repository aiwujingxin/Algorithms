package basic.algorithm.greedy;


import basic.algorithm.dp.knapsack.knapsack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Backpack implements knapsack {

    @Override
    public int backPack(int packageWeight, int[] weight, int[] goodsValue) {
        int sum = 0;
        List<Goods> goods = getGoods(goodsValue, weight);
        goods.sort(Comparator.comparing(Goods::getPw));
        for (int i = goodsValue.length - 1; i >= 0; i--) {
            if (packageWeight >= weight[i]) {
                sum += goodsValue[i];
                packageWeight -= weight[i];
            }
        }
        return sum;
    }

    List<Goods> getGoods(int[] goodsValue, int[] weight) {
        int length = goodsValue.length;
        List<Goods> goods = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            goods.add(new Goods(goodsValue[i], weight[i], (double) goodsValue[i] / (double) weight[i]));
        }
        return goods;
    }

    public static class Goods {
        int prices;
        int weight;
        double pw;

        public Goods(int prices, int weight, double pw) {
            this.prices = prices;
            this.weight = weight;
            this.pw = pw;
        }

        public int getPrices() {
            return prices;
        }

        public void setPrices(int prices) {
            this.prices = prices;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public double getPw() {
            return pw;
        }

        public void setPw(double pw) {
            this.pw = pw;
        }
    }
}
