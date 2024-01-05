import java.util.Stack;

/**
 * 1944. 队列中可以看到的人数
 * 有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
 * <p>
 * 一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且
 * <p>
 * min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
 * <p>
 * 请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。
 */
public class _20240105_1944_CanSeePersonsCount {
    /**
     * 思路：这些人数，正好可以在维护单调栈时的出栈过程中计算。单调栈是严格递减的，栈顶每个小于当前人身高的元素，都会被弹出栈，如果此时栈非空，
     * 那么栈顶元素表示下标为 i的人能看到的最后一个人。最后将当前人的身高 heights[i]入栈。
     *
     * @param heights
     * @return
     */
    public int[] canSeePersonsCount(int[] heights) {
        int h = heights.length;
        int[] ans = new int[h];
        //构建单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = h - 1; i >= 0; i--) {
            //单调栈维护，当前栈顶元素比要进栈的小，删除栈顶
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                ans[i]++;
            }
            //弹出了最后一个栈元素
            if (!stack.isEmpty()) {
                ans[i]++;
            }
            //进栈
            stack.push(heights[i]);
        }

        return ans;
    }
}
