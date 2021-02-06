package leetcode.editor.cn;
public class 二叉搜索树中的搜索{
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
    public TreeNode searchBST(TreeNode root, int val) {

        while (root!=null){
            if(root.val==val){
                return root;
            }else if(root.val>val){
                root=root.left;
            }else {
                root=root.right;
            }
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
