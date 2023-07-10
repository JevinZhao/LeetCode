/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class _41_FirstMissingPositive {
    /**
     * 思路：
     * 遍历数组-->一个一个比对？好像不行 ×
     * 官方解法：
     * 我们将数组中所有小于等于0 的数修改为 N+1；
     * 我们遍历数组中的每一个数 x，它可能已经被打了标记，因此原本对应的数为∣x∣。如果 ∣x∣∈[1,N]，
     * 那么我们给数组中的第 ∣x∣−1 个位置的数添加一个负号。
     * 注意如果它已经有负号，不需要重复添加；
     * 在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1，否则答案是第一个正数的位置加1。
     * @param nums 数组
     * @return answer
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
