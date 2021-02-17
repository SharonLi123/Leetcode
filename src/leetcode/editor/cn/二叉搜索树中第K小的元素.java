package leetcode.editor.cn;
public class 二叉搜索树中第K小的元素{
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
    public int kthSmallest(TreeNode root, int k) {
        help(root,k);
        return res;
    }

    int res;
    int rank=0;
    public void help(TreeNode root,int k){
        if(root==null){
            return;
        }
        kthSmallest(root.left,k);
        rank+=1;
        if(k==rank){
            res=root.val;
            return;
        }
        kthSmallest(root.right,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
