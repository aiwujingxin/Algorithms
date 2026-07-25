package knowledge.mathematics.probability.impl;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @description Fisher-Yates 洗牌算法
 * 用于在 O(N) 时间内等概率随机打乱一个数组
 */
public class FisherYates {

    /**
     * 打乱整型数组
     */
    public static void shuffle(int[] arr) {
        shuffle(arr, new Random());
    }

    /**
     * 用给定 Random 打乱整型数组，便于复现与测试。
     */
    public static void shuffle(int[] arr, Random random) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /**
     * 打乱对象数组
     */
    public static void shuffle(Object[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
