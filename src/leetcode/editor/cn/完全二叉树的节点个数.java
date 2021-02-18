package leetcode.editor.cn;
public class 完全二叉树的节点个数{
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
    public int countNodes(TreeNode root) {
        TreeNode left=root;
        TreeNode right=root;

        int hl=0;
        int hr=0;

        while (left!=null){
            hl++;
            left=left.left;
        }

        while (right!=null){
            hr++;
            right=right.right;
        }

        if(hl==hr){
            return (int)Math.pow(2,hl)-1;
        }

        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
