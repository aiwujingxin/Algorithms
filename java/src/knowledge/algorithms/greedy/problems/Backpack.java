package knowledge.algorithms.greedy.problems;

import knowledge.algorithms.dp.backpack.zeroOne.ZeroOnePack;

import java.util.Arrays;

public class Backpack implements ZeroOnePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int sum = 0;
        int N = W.length;
        double[][] goods = new double[N][];
        for (int i = 0; i < N; i++) {
            goods[i] = new double[]{(double) C[i], (double) W[i], (double) W[i] / (double) C[i]};
        }
        Arrays.sort(goods, ((o1, o2) -> Double.compare(o2[2], o1[2])));
        for (int i = 0; i < N; i++) {
            if (V >= goods[i][0]) {
                sum += (int) goods[i][1];
                V -= (int) goods[i][0];
            }
        }
        return sum;
    }
}
