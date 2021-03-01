package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }

        int min=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Queue<TreeNode> temp=new LinkedList<>();
            //遍历队列里的每个节点
            while (!queue.isEmpty()){
                TreeNode curr= queue.poll();
                if(curr.left==null && curr.right==null){
                    return min;
                }
                if(curr.left!=null){
                    temp.offer(curr.left);
                }
                if(curr.right!=null){
                    temp.offer(curr.right);
                }
            }
            queue.addAll(temp);
            min++;
        }
        return min;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
