package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/26 19:09
 *
 * <a href="https://leetcode.com/problems/the-skyline-problem/solutions/61287/java-binary-indexed-tree-solution/">...</a>
 */
public class LeetCode218_BIT {
    private int[] biTree;

    private void add(int r, int h) { // here r is in the reduced array
        while (r > 0) {
            biTree[r] = Math.max(biTree[r], h);
            r -= r & (-r);
        }
    }

    private int find(int l) { // here l is in the reduced array
        int ret = 0;
        while (l < biTree.length) {
            ret = Math.max(ret, biTree[l]);
            l += l & (-l);
        }
        return ret;
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<int[]>();

        int[][] xidx = new int[buildings.length * 2][3]; // array of [x, i/o, idx]
        for (int i = 0; i < buildings.length; i++) {
            xidx[2 * i] = new int[]{buildings[i][0], 1, i}; // in
            xidx[2 * i + 1] = new int[]{buildings[i][1], 2, i}; // out
        }

        Arrays.sort(xidx, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0]; // sort from left to right
            else return a[1] - b[1]; // in before out; otherwise, <out, 0> will be add to the list and cause problem
        });

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int num = 0;
        for (int[] x : xidx) {
            map.put(x[0], ++num); // map of (x : number), to reduce space usage
        }
        biTree = new int[num + 1];

        int l, r, h;
        int curhigh = 0; // start hight
        for (int[] x : xidx) {
            if (x[1] == 1) { // left side of a building
                l = buildings[x[2]][0];
                r = buildings[x[2]][1];
                h = buildings[x[2]][2];
                add(map.get(r), h);
            } else {
                l = buildings[x[2]][1]; // assign r to l, to find hight after the building end
            }

            int tmp = find(map.get(l) + 1); // find the highest after

            if (tmp != curhigh) {
                int size = list.size();
                if (size > 0 && list.get(size - 1)[0] == l) { // 2 hight with the same x
                    curhigh = list.get(size - 1)[1] = Math.max(tmp, list.get(size - 1)[1]);
                } else {
                    list.add(new int[]{l, tmp});
                    curhigh = tmp;
                }
            }
        }
        return list;
    }
}
