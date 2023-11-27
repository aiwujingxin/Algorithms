package leetcode.problems;

import common.ListNode;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 21:58
 * @description 水塘抽样1/N <a href="https://github.com/jiajunhua/labuladong-fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/%E6%B0%B4%E5%A1%98%E6%8A%BD%E6%A0%B7.md"></a>
 * 假设最后返回的是第 k个满足条件的下标，发生概率为 = 第 k个下标被候选的概率× 后面 k+1 到 m个下标不被候选的概率 = 1/k×(1−/(k+1))×...×(1−1/m) = 1/m
 * @see LeetCode384
 * @see LeetCode398
 */
public class LeetCode382 {

    class Solution {

        ListNode head;
        Random rand;

        public Solution(ListNode head) {
            this.head = head;
            rand = new Random();
        }

        public int getRandom() {
            ListNode temp = head;
            int selected = -1;
            int i = 1;
            while (temp != null) {
                if (rand.nextFloat() < 1.0 / i) {
                    selected = temp.val;
                }
                temp = temp.next;
                i++;
            }

            return selected;
        }
    }
}
