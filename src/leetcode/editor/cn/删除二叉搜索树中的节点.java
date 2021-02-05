package leetcode.editor.cn;
public class 删除二叉搜索树中的节点{
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) {
            return null;
        }
        if(root.val==key){
            //进行删除
            if(root.left==null) {
                root=root.right;
            }else if(root.right==null){
                root=root.left;
            }else {
                TreeNode minNode=getRightMin(root.right);
                root.val=minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right= deleteNode(root.right,key);
        }

        return root;
    }

    public TreeNode getRightMin(TreeNode node){
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
