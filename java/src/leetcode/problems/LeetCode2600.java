package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/16 22:58
 */
public class LeetCode2600 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes + numZeros) {
            return Math.min(k, numOnes);
        }
        return numOnes - (k - (numOnes + numZeros));
    }
}
