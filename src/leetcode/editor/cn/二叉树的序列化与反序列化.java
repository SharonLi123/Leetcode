package leetcode.editor.cn;

import com.sun.tools.hat.internal.model.Root;

import java.util.LinkedList;

public class 二叉树的序列化与反序列化{
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        traverse(root,sb);
        return sb.toString();
    }

    /**
     * 前序遍历
     * @param root
     * @param sb
     */
    void traverse(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#").append(",");
            return;
        }

        sb.append(root.val).append(",");
        traverse(root.left,sb);
        traverse(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes= new LinkedList<>();
        for (String s:data.split(",")){
            nodes.addLast(s);
        }
        return help(nodes);
    }

    TreeNode help(LinkedList<String> nodes){
        String first= nodes.removeFirst();
        if(first.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left=help(nodes);
        root.right=help(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
