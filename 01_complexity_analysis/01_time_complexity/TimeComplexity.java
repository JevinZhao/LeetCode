/**
 * 时间复杂度
 */
public class TimeComplexity {
    /**
     * 测试一些方法
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 常量阶：O(1),即执行时间与n无关，代码的执行时间不随 n 的增大而增长
     * 一般情况下，只要算法中不存在循环语句、递归语句，即使有成千上万行的代码，其时间复杂度也是Ο(1)
     *
     * @param n
     */
    public void cal1(int n) {
        int i = 8;
        int j = 6;
        int sum = i + j;
        System.out.println(sum);
    }

    /**
     * 对数阶：O(logn)，O(nlogn)；x=logn，所以，这段代码的时间复杂度就是 O(logn)。
     * 对数之间是可以互相转换的，log3n 就等于 log32 * log2n，所以 O(log3n) = O(C * log2n)，
     * 其中 C=log32 是一个常量。基于我们前面的一个理论：在采用大 O 标记复杂度的时候，可以忽略系数，
     * 即 O(Cf(n)) = O(f(n))。所以，O(log2n) 就等于 O(log3n)
     * 如果一段代码的时间复杂度是 O(logn)，我们循环执行 n 遍，时间复杂度就是 O(nlogn) 了。
     * 而且，O(nlogn) 也是一种非常常见的算法时间复杂度。
     * 比如，归并排序、快速排序的时间复杂度都是 O(nlogn)
     *
     * @param n
     */
    public void cal2(int n) {
        int i = 1;
        while (i <= n) {
            i = i * 2;
        }
    }

    /**
     * 线性阶：O(n)
     *
     * @param n
     */
    public int cal3(int n) {
        int sum = 0;
        int i = 1;
        for (; i <= n; ++i) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * 线性阶：O(m+n)，O(m*n)
     *m 和 n 是表示两个数据规模。我们无法事先评估 m 和 n 谁的量级大，所以我们在表示复杂度的时候，
     * 就不能简单地利用加法法则，省略掉其中一个。
     * 所以，上面代码的时间复杂度就是 O(m+n)
     * @param n
     */
    public int cal3(int n, int m) {
        int sum_1 = 0;
        int i = 1;
        for (; i < m; ++i) {
            sum_1 = sum_1 + i;
        }
        int sum_2 = 0;
        int j = 1;
        for (; j < n; ++j) {
            sum_2 = sum_2 + j;
        }

        return sum_1 + sum_2;
    }
    /**
     * 最好时间复杂度，最坏时间复杂度，平均时间复杂度，均摊时间复杂度（摊还分析法）
     * O(1)，O(n)，O(n)，O(1)
     * @param n
     */
    public int cal4(int[] array, int n, int x) {
        int i = 0;
        int pos = -1;
        for (; i < n; ++i) {
            if (array[i] == x) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
