package leetcode.editor.cn;
public class 把二叉搜索树转换为累加树{
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
    public TreeNode convertBST(TreeNode root) {
        //右根左
        help(root);
        return root;
    }

    int sum=0;
    public void help(TreeNode root){
        if(root==null){
            return;
        }
        help(root.right);
        sum+=root.val;
        root.val=sum;
        help(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
