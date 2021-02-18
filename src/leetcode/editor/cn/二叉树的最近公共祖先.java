package leetcode.editor.cn;
public class 二叉树的最近公共祖先{
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }
        if(root==q || root==p){
            return root;
        }

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }
        if(left==null && right==null){
            return null;
        }
        return left==null?right:left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
