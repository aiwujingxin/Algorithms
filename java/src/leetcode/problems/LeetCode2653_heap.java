package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/4 00:37
 */

public class LeetCode2653_heap {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        DualHeap dualHeap = new DualHeap(nums, x);

        for (int right = 0; right < n; right++) {
            // 新元素进入窗口
            dualHeap.add(right);

            // 窗口长度超过 k，移除最左侧元素
            if (right >= k) {
                dualHeap.remove(right - k);
            }

            // 窗口形成，获取第 x 小的数
            if (right >= k - 1) {
                int value = dualHeap.getXthSmallest();
                answer[right - k + 1] = Math.min(value, 0);
            }
        }

        return answer;
    }

    static class DualHeap {

        private final int[] nums;
        private final int x;

        // 保存窗口内最小的 x 个元素：大根堆
        private final PriorityQueue<Integer> small;

        // 保存窗口内剩余元素：小根堆
        private final PriorityQueue<Integer> large;

        // removed[i] = true，表示下标 i 对应的元素已经离开窗口
        private final boolean[] removed;

        // inSmall[i] = true，表示下标 i 对应的元素逻辑上属于 small
        private final boolean[] inSmall;

        // 两个堆中有效元素的数量
        private int smallSize;
        private int largeSize;

        DualHeap(int[] nums, int x) {
            this.nums = nums;
            this.x = x;

            // 大根堆：值大的排前面
            this.small = new PriorityQueue<>((a, b) -> {
                if (nums[a] != nums[b]) {
                    return Integer.compare(nums[b], nums[a]);
                }
                return Integer.compare(b, a);
            });

            // 小根堆：值小的排前面
            this.large = new PriorityQueue<>((a, b) -> {
                if (nums[a] != nums[b]) {
                    return Integer.compare(nums[a], nums[b]);
                }
                return Integer.compare(a, b);
            });

            this.removed = new boolean[nums.length];
            this.inSmall = new boolean[nums.length];
        }

        public void add(int index) {
            pruneSmall();

            // small 不足 x 个，或者当前元素不大于 small 堆顶
            if (smallSize < x
                    || nums[index] <= nums[small.peek()]) {
                small.offer(index);
                inSmall[index] = true;
                smallSize++;
            } else {
                large.offer(index);
                inSmall[index] = false;
                largeSize++;
            }

            balance();
        }

        public void remove(int index) {
            // 只做删除标记，不直接从堆中查找并删除
            removed[index] = true;

            if (inSmall[index]) {
                smallSize--;
            } else {
                largeSize--;
            }

            // 如果待删除元素刚好在堆顶，就立即清理
            pruneSmall();
            pruneLarge();

            balance();
        }

        public int getXthSmallest() {
            pruneSmall();
            return nums[small.peek()];
        }

        private void balance() {
            pruneSmall();
            pruneLarge();

            // small 中有效元素超过 x 个
            while (smallSize > x) {
                pruneSmall();

                int index = small.poll();

                large.offer(index);
                inSmall[index] = false;

                smallSize--;
                largeSize++;
            }

            // small 中有效元素不足 x 个
            while (smallSize < x && largeSize > 0) {
                pruneLarge();

                int index = large.poll();

                small.offer(index);
                inSmall[index] = true;

                largeSize--;
                smallSize++;
            }

            pruneSmall();
            pruneLarge();
        }

        private void pruneSmall() {
            while (!small.isEmpty() && removed[small.peek()]) {
                small.poll();
            }
        }

        private void pruneLarge() {
            while (!large.isEmpty() && removed[large.peek()]) {
                large.poll();
            }
        }
    }

}
