package leetcode.editor.cn;
public class 二叉搜索树中的插入操作{
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //root.val>val ? root.left : root.right
        if (root==null){

            return new TreeNode(val);
        }

        TreeNode pre=null;
        TreeNode node=root;

        while (node!=null){
            pre=node;
            if(node.val>val){
                node=node.left;
            }else {
                node=node.right;
            }
        }

        if(pre.val>val && pre.left==null){
            pre.left=new TreeNode(val);
        }else {
            pre.right=new TreeNode(val);
        }
        return root;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
