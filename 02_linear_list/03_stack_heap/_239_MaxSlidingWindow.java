import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _239_MaxSlidingWindow {
    /**
     * 思路：1.MaxHeap，在优先队列的基础上重写,将数组值与下标组成一个二维数组，放入优先队列中，自定义排序
     *
     * 2.双端队列
     */
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];//比较数值大小，如果不相等就按大小排序，否则按下标排序
            }
        });
        //放元素到优先队列
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i],i});
        }
        int[] res=new int[n-k+1];//结果数组
        res[0]=queue.peek()[0];
        //开始滑动
        for (int i = k; i <n ; i++) {
            queue.offer(new int[]{nums[i],i});
            //当遇到比当前堆顶大的数值时，移除当前，加入新元素
            while(queue.peek()[1]<=i-k){
                queue.poll();
            }
            //给出数值
            res[i-k+1]=queue.peek()[0];
        }
        return res;
    }
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        //解释一下为什么队列中要存放数组下标的值而不是直接存储数值，因为要判断队首的值是否在窗口范围内，由数组下标取值很方便，而由值取数组下标不是很方便。
        return result;
    }
    public void xxl(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("llk",1);
        "".hashCode();
    }


}
