package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 17:16
 */
public class LeetCode368_uf {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        UnionFind unionfind = new UnionFind(length, nums);
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    unionfind.union(i, j);
                }
            }
        }
        return unionfind.largestSubset();
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int[] path;
        int[] nums;
        int max;

        public UnionFind(int num, int[] nums) {
            parent = new int[num];
            rank = new int[num];
            path = new int[num];
            this.nums = nums;
            max = 0;
            for (int i = 0; i < num; i++) {
                parent[i] = i;
                rank[i] = 1;
                path[i] = i;
            }
        }

        public void union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);
            if (roota != rootb) {
                if (nums[a] > nums[b]) {
                    parent[b] = a;
                    if (rank[a] < rank[b] + 1) {
                        rank[a] = rank[b] + 1;
                        path[a] = b;
                    }
                    if (rank[max] < rank[a]) {
                        max = a;
                    }
                } else if (nums[a] < nums[b]) {
                    parent[a] = b;
                    if (rank[b] < rank[a] + 1) {
                        rank[b] = rank[a] + 1;
                        path[b] = a;
                    }
                    if (rank[max] < rank[b]) {
                        max = b;
                    }
                }
            }
        }

        public int find(int a) {
            while (parent[a] != a) a = parent[a];
            return parent[a];
        }

        public int getMax() {
            return max;
        }

        public List<Integer> largestSubset() {
            int a = max;
            List<Integer> list = new ArrayList<>();
            list.add(nums[a]);
            while (path[a] != a) {
                a = path[a];
                list.add(nums[a]);
            }
            return list;
        }
    }
}

