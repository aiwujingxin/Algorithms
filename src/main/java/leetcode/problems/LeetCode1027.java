package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2021-12-26 11:24 PM
 */
public class LeetCode1027 {


    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        // 特判
        if (n == 0) {
            return 0;
        }
        // 定义哈希表，第一个键表示数组下标索引，其嵌套的哈希表用于存储该元素以不同的公差所包含的最长序列
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 1;
        // 遍历数组
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            // 向前遍历，寻找不同公差的最长序列
            for (int j = i - 1; j >= 0; j--) {
                // 如果遇到了重复的元素，可以直接跳过，因为肯定不会比后面的元素能组成更长的序列
                if (map.get(i).containsKey(A[i] - A[j])) {
                    continue;
                }
                // 获取以这两个元素差为公差的最长子序列
                int cur = map.get(j).getOrDefault(A[i] - A[j], 0);
                // 比较答案
                res = Math.max(res, cur + 2);
                // 存入当前元素，某公差下的最长序列
                map.get(i).put(A[i] - A[j], cur + 1);
            }
        }

        return res;
    }

    public int longestArithSeqLengthV2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Map<Integer, Integer>[] countMaps = new HashMap[nums.length];
        int longest = 2;
        countMaps[0] = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if (countMaps[i] == null) {
                countMaps[i] = new HashMap<>();
            }
            for (int j = 0; j < i; j++) {
                int seq = nums[i] - nums[j];
                int count = countMaps[j].getOrDefault(seq, 1) + 1;
                countMaps[i].put(seq, count);
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public int longestArithSeqLengthV3(int[] nums) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            dp.put(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                int dif = nums[i] - nums[j];
                int len = dp.get(j).getOrDefault(dif, 1) + 1;
                if (len > ans) {
                    ans = len;
                }
                dp.get(i).put(dif, len);
            }
        }
        return ans;
    }

    public int longestArithSeqLengthV4(int[] nums) {
        int max = maxElement(nums); //to find the max element
        int min = minElement(nums); //to find the min element
        int diff = max - min; //to find the max possible diff
        int n = nums.length;
        int[][] dp = new int[n][2 * diff + 2]; // 2*diff done coz diff can be negative
        for (int[] d : dp) {
            Arrays.fill(d, 1); //every element can be included atleast once in any AP(by just including himself)
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int difference = nums[i] - nums[j] + diff; //diff is added coz the 'difference' could be negative too
                int temp = dp[j][difference];
                dp[i][difference] = Math.max(dp[i][difference], temp + 1); //updation for the current difference
                if (ans < dp[i][difference]) //for the final answer
                {
                    ans = dp[i][difference];
                }
            }
        }

        return ans;

    }


    public int maxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (Integer e : arr) {
            if (max < e) {
                max = e;
            }
        }

        return max;
    }

    public int minElement(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (Integer e : arr) {
            if (min > e) {
                min = e;
            }
        }

        return min;
    }


    public int longestArithSeqLengthV5(int[] A) {

        int n = A.length;

        // There can only be a single sequence of n if n is less than 3
        if (n < 3) {
            return n;
        }

        // notice the constraints in the problem, the min possible value of A[i] can be 0
        // and the max possible value can be 500, what this means is that the max possible difference
        // between any two numbers in A is 500 or -500, by setting an array of size 1001
        // we can represent any value in that range by simply adding 500 to any diff
        // e.g. -500 diff == 0, 0 diff == 500, 500 diff == 1000. This allows us to use the much
        // more efficent array data structure as a opposed to a complex data structure like a hash map.
        int[][] sequences = new int[n][1001];
        int maxSequence = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // get the diff of the two numbers we are considering.
                int diff = A[j] - A[i] + 500;

                // the idea here is that if by some earlier calculation, we encounterd
                // A[i] with the same diff that is between A[i] and A[j], then A[j] belongs
                // to the same sequence as A[i] and we record the new sequnce length of A[j]
                // considering that in the future we find and A[k] that has the same
                // diff of A[k] - A[j] as A[j] - A[i]. If this diff has never been encountered
                // before then the default sequence length is 2.
                sequences[j][diff] = sequences[i][diff] > 0 ? sequences[i][diff] + 1 : 2;

                // examine each sequence length encountered and choose the maximum.
                maxSequence = Math.max(sequences[j][diff], maxSequence);

            }
        }

        return maxSequence;
    }
}
