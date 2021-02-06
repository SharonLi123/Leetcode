package leetcode.editor.cn;
public class 验证二叉搜索树{
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
    public boolean isValidBST(TreeNode root) {
        return help(root,null,null);
    }

    public boolean help(TreeNode root,TreeNode min,TreeNode max){
        if (root==null) {
            return true;
        }

        if(min!=null && min.val>=root.val){
            return false;
        }

        if(max!=null && max.val<=root.val){
            return false;
        }

        return help(root.left,min,root) && help(root.right,root,max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
