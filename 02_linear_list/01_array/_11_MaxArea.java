import java.util.Stack;

/**
 * 11.盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _11_MaxArea {
    /**
     * 暴力解法，遍历，找最大值，把结果放入栈中，如果是进栈元素小于之前的，则不进栈。
     * 如果大于则进栈，最后取出栈作为最大面积
     * 暴力解法不行！！！超出时间限制 O(∩_∩)O哈哈~
     *
     * @param height 高度数组
     * @return 最大面积
     */
    public int maxArea1(int[] height) {
        int max = 0;
        //遍历 O(n^2)
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针法，关键在于判断何时移动，从而减少了重复的遍历
     * 最大长度已经确定啦，移动指针只会缩小最大长度，所以要找最高的，不然就不移动指针。
     *
     * @param height 高度数组
     * @return 最大面积
     */
    public int maxArea2(int[] height) {
        int max = 0;
        //定义左右指针
        int left = 0;
        int right = height.length - 1;
        //
        while (left < right) {
            max = Math.max(((right - left) * Math.min(height[right], height[left])), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
