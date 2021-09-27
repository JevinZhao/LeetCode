import java.util.*;

/**
 * 15.三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _15_ThreeSum {
    /**
     * 暴力枚举法， 三层循环遍历,测试超时，^_^
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     *
     * @param nums 目标数组
     * @return 答案
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        //非空判断
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        //初始化，利用hashset去重
        Set<List<Integer>> set = new HashSet<>();
        //数组排序，方便后面去重  O(nlogn)
        Arrays.sort(nums);
        //遍历  O(n^3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    //判断是否为0
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 双指针法，将问题转换成两数之和 + 一些去重的小技巧
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param nums  数组
     * @return  答案
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        //非空判断
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        //初始化
        List<List<Integer>> list = new ArrayList<>();
        //数组排序，方便后面去重  O(nlogn)
        Arrays.sort(nums);
        //遍历  O(n^2)
        for (int i = 0; i < nums.length; i++) {
            //当一个元素与其后一个元素相同时，跳过后一个元素，也是一种去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //目标之和
            int target = -nums[i];
            //定义左，右指针
            int left = i + 1;
            int right = nums.length - 1;
            //当左指针小于右指针时，就要一直比下去
            while (left < right) {
                //计算左右指针之和
                int sum = nums[left] + nums[right];
                //符合条件放入list
                if (sum == target) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //当左/右指针指向的元素与后一个元素相等时，直接跳过后一个元素，继续往后走
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (sum < target) {
                    //若两数之和小于目标值，则左指针要往后移动一位
                    left++;
                } else {
                    //若两数之和大于目标值，则右指针要往前移动一位
                    right--;
                }
            }
        }
        return list;
    }
}
