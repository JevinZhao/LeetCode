/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _206_ReverseList {
    /**
     * 迭代法：由前一个结点找到下一个节点，并将下一个节点的指针指向前一个节点
     */
    public ListNode reverseList_1(ListNode head) {
        //定义前一个节点和当前节点
        ListNode pre = null;
        ListNode current = head;
        //循环
        while (current != null) {
            //找到下一个节点
            ListNode next = current.next;
            //当前节点指针指向前一个节点
            current.next = pre;
            //将当前节点变成前一个节点
            pre = current;
            //下一个节点变成当前节点
            current = next;
        }
        return pre;
    }
}
