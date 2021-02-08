package leetcode.editor.cn;
public class 从中序与后序遍历序列构造二叉树{
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder,int leftI,int rightI,int[] postorder,int leftP,int rightP){
        if(leftI>rightI) {
            return null;
        }
        //先构建根
        TreeNode root=new TreeNode(postorder[rightP]);

        //寻找根节点在中序遍历的下标
        int index=findEle(inorder,leftI,rightI,postorder[rightP]);

        //左边的元素个数
        int lenLeft=index-leftI;
        root.left=build(inorder,leftI,index-1,postorder,leftP,leftP+lenLeft-1);
        root.right=build(inorder,index+1,rightI,postorder,leftP+lenLeft,rightP-1);

        return root;

    }

    public int findEle(int[] inorder,int leftI,int rightI,int ele){

        for(int i=leftI;i<=rightI;i++){
            if(inorder[i]==ele){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
