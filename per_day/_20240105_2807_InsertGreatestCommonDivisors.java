/**
 * 给你一个链表的头 head ，每个结点包含一个整数值。
 * <p>
 * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
 * <p>
 * 请你返回插入之后的链表。
 * <p>
 * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
 */
public class _20240105_2807_InsertGreatestCommonDivisors {

    /**
     * 思路：模拟插入过程
     * @param head
     * @return
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node=head;
        while(node.next!=null){
            int val=gcd(node.val,node.next.val);
            node.next = new ListNode(val,node.next);
            //更新node
            node=node.next.next;//从新链表第3个节点开始
        }
        return node;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode insertGreatestCommonDivisors2(ListNode head) {
        ListNode node=head;
        if(node.next!=null){
            insertGreatestCommonDivisors2(head.next);
            int val=gcd(node.val,node.next.val);
            node.next = new ListNode(val,node.next);
        }
        return node;
    }
    //取2数最大公约数
    public int gcd(int a,int b){
      while (b!=0){
          int temp=a%b;
          a=b;
          b=temp;
      }
        return a;
    }
}
