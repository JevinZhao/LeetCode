import java.util.HashMap;

/**
 * 1.两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1_TwoSum {
    /**
     * 自己写  暴力枚举法，主要思路是：取数组中的元素与其他元素进行相加，判断两数之和是否为目标值
     * 时间复杂度： 该方法中有嵌套循环，时间复杂度为O(n^2)
     * 空间复杂度：O(1),只用到一个ints数组
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 两个整数
     */
    public int[] twoSum1(int[] nums, int target) {
        //结果数组初始化
        int[] ints = new int[2];
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    //数组赋值
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;
    }

    /**
     * 哈希表法，空间换时间，一次遍历数组，每遍历一个元素都计算待匹配的值，判断Map中是否存在待匹配的值，
     *  ※ 不满足条件的元素存入Map中，元素值为key，下标为value，满足条件的直接输出两个键值对的value
     * 时间复杂度：一次遍历，时间复杂度为O(n)
     * 空间复杂度：O(n),最坏情况下要存n个键值对
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 两个整数
     */
    public int[] twoSum2(int[] nums, int target) {
        //存数据的Map
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length - 1);
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //计算下标为i的元素的partner
            int another = target - nums[i];
            //判断map中是否存在another，存在就输出下标
            if (hashMap.containsKey(another)) {
                return new int[]{i, hashMap.get(another)};
            }
            //将该元素存入Map中
            hashMap.put(nums[i], i);
        }
        return new int[]{0};
    }
}
