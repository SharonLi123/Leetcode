package leetcode.editor.cn;
public class 反转链表{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //使用递归
        if(head==null || head.next==null){
            return head;
        }

        ListNode last=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;

/*        ListNode pre=null;
        while (head!=null){
            ListNode temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
