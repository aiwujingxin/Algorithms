package leetcode.lcp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/9 01:29
 */
public class LCP46 {


    //对线性操作的做线性拆分，将以 val = k * x + b 的形式表达出来

    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int n = finalCnt.length + 1, m = plans.length;

        //oriParam 数组表示每个位置 i 的系数 k
        int[] oriParam = new int[n];
        //oriCnt 数组表示每个位置 i 的常数 b
        int[] oriCnt = new int[n];

        oriParam[0] = 1;

        for (int i = 0; i < n - 1; i++) {
            oriCnt[i + 1] = finalCnt[i];
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            //保存相邻场馆
            addRelations(e[0], e[1], graph);
            addRelations(e[1], e[0], graph);
        }
        for (int i = m - 1; i >= 0; i--) {
            int idx = plans[i][1];
            int num = plans[i][0];
            //模拟 plans 的操作
            operate(num, idx, oriParam, graph);
            operate(num, idx, oriCnt, graph);
        }
        //汇总k0,k1,k2...及 y - b0 - b1 - ...
        int param = 0;
        for (int i = 0; i < n; i++) {
            totalNum -= oriCnt[i];
            param += oriParam[i];
        }
        //求解x
        int x = (int) (totalNum / param);
        //将常数数组加上 k * x 即为初始值
        for (int i = 0; i < n; i++) {
            oriCnt[i] = oriParam[i] * x + oriCnt[i];
        }
        return oriCnt;
    }

    private void operate(int num, int idx, int[] array, HashMap<Integer, List<Integer>> related) {
        if (num == 1) {
            array[idx] *= 2;
        } else {
            for (int neb : related.getOrDefault(idx, new ArrayList<>())) {
                if (num == 2) {
                    array[neb] -= array[idx];
                } else {
                    array[neb] += array[idx];
                }
            }
        }
    }

    private void addRelations(int x, int y, HashMap<Integer, List<Integer>> related) {
        List<Integer> relations = related.getOrDefault(x, new ArrayList<>());
        relations.add(y);
        related.put(x, relations);
    }
}
