package leetcode.editor.cn;

import com.sun.jndi.toolkit.ctx.HeadTail;

public class 反转链表 II{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==1){
            return reverse(head,n);
        }

        head.next=reverseBetween(head.next,m-1,n-1);

        return head;
    }

    private ListNode tail=null;

    public ListNode reverse(ListNode head,int n){
        if(n==1){
            tail=head.next;
            return head;
        }

        ListNode last=reverse(head.next,n-1);
        head.next.next=head;
        head.next=tail;
        return last;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
