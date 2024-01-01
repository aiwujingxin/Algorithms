package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/7 16:54
 * @link <a href="https://leetcode.cn/problems/count-zero-request-servers/solutions/2320098/chi-xian-hua-dong-chuang-kou-pythonjavac-b573/">...</a>
 * 离线查询
 * 1851. 包含每个查询的最小区间
 * 1938. 查询最大基因差
 * 2070. 每一个查询的最大美丽值
 * 2343. 裁剪数字后查询第 K 小的数字
 * 2503. 矩阵查询可获得的最大分数
 * 2736. 最大和查询
 * 2747. 统计没有收到请求的服务器数目
 */
public class LeetCode2747 {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < queries.length; index++) {
            queries[index] -= x;
            map.put(queries[index], index);
        }
        Arrays.sort(queries);
        int[] res = new int[queries.length];

        HashMap<Integer, Integer> arr = new HashMap<>();
        int cnt = 0;

        int left = 0, right = 0;
        for (int query : queries) {
            while (right < logs.length && logs[right][1] <= query + x) {
                arr.put(logs[right][0], arr.getOrDefault(logs[right][0], 0) + 1);
                if (arr.get(logs[right][0]) == 1) {
                    cnt++;
                }
                right++;
            }
            while (left < logs.length && logs[left][1] < query) {
                arr.put(logs[left][0], arr.get(logs[left][0]) - 1);
                if (arr.get(logs[left][0]) == 0) {
                    cnt--;
                }
                left++;
            }
            res[map.get(query)] = n - cnt;
        }
        return res;
    }

}
