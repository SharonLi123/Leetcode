package leetcode.editor.cn;


public class Union-Find并查集{
    public static void main(String[]args){
        Solution solution=new Solution();
    }
}

class Solution{

}

class UF{
    // 记录连通分量
    private int count;
    // 节点 x 的节点是 parent[x]
    private int[] parent;

    /* 构造函数，n 为图的节点总数 */
    public UF(int n) {
        // 一开始互不连通
        this.count = n;
        // 父节点指针初始指向自己
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    /* 将 p 和 q 连接 */
    public void union(int p, int q){
        int rootP=find(p);
        int rootQ=find(q);
        if(rootP==rootQ){
            return;
        }
        parent[rootQ]=rootP;
        count--;
    }

    /* 返回某个节点 x 的根节点 */
    private int find(int x){
        while (parent[x]!=x){
            x=parent[x];
        }
        return x;
    }

    /* 判断 p 和 q 是否连通 */
    public boolean connected(int p, int q){
        int rootP=find(p);
        int rootQ=find(q);
        return rootP==rootQ;
    }

    /* 返回图中有多少个连通分量 */
    public int count(){
        return count;
    }
}