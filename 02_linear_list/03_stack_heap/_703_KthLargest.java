import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _703_KthLargest {
    /**
     * 思路：1.每进来一个元素就把所有元素进行排序，返回最大元素,时间复杂度 K*logK
     * <p>
     * 2.使用MinHeap，Java中的优先队列就是一种最小堆，利用最小堆的特性（自排序） 时间复杂度：log2（K）
     */
    final PriorityQueue<Integer> queue;
    final int k;

    public _703_KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        //数据加入最小堆
        for (int n :nums){
            add(n);
        }
    }

    public int add(int val) {
        queue.offer(val);
        //如果此时优先队列的大小大于 k，我们需要将优先队列的队头元素弹出，以保证优先队列的大小为 k。
        if (queue.size()>k){
            queue.poll();
        }
        return queue.peek();
    }
}
