import java.util.ArrayList;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _26_RemoveDuplicates {
    /**
     * 暴力解法，遍历，将元素放入新数组中
     * 将当前元素与后一个元素进行比较，
     * 若相等，不放入
     * 不相等，放入新数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums 数组
     * @return 数组长度
     */
    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                   list.add(nums[i]);
                }
            }
            return list.size();
        }

    }

    /**
     * 双指针法，快指针用于遍历，慢指针用于放值
     * @param nums 数组
     * @return 返回值
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //这里快慢指针都开始从一开始，直接让第一个元素放入原数组
        //相当于就是将这个数组进行重排
        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;

    }
}
