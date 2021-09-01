/**
 * 空间复杂度
 */
public class SpaceComplexity {
    public static void main(String[] args) {
        print(100) ;
    }
    public static void print(int n) {
        int i = 0;
        int[] a = new int[n];
        for (; i <n; ++i) {
            a[i] = i * i;
        }

        for (i = n-1; i >= 0; --i) {
            System.out.println(a[i]);
        }
    }
}
