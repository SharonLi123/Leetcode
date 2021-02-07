package leetcode.editor.cn;
public class 二叉树展开为链表{
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
    public void flatten(TreeNode root) {
        if(root==null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if(root.left!=null){
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;

            TreeNode last=root.right;
            while (last.right!=null){
                last=last.right;
            }
            last.right=temp;
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
