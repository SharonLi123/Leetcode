package leetcode.editor.cn;
public class 被围绕的区域{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        if(board.length==0){
            return;
        }
        int m=board.length;
        int n=board[0].length;

        UF uf=new UF(m*n+1);
        int dummy=m*n;

        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                uf.union(i*n,dummy);
            }
            if(board[i][n-1]=='O'){
                uf.union((i+1)*n-1,dummy);
            }
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                uf.union(j,dummy);
            }
            if(board[m-1][j]=='O'){
                uf.union((m-1)*n+j,dummy);
            }
        }

        int[][] d=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(board[i][j]=='O'){
                    for(int k=0;k<4;k++){
                        int x=i+d[k][0];
                        int y=j+d[k][1];
                        if(board[x][y]=='O'){
                            uf.union(x*n+y,i*n+j);
                        }
                    }
                }
            }
        }

        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(!uf.connected(dummy, i * n + j)){
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class UF{
    private int count;
    private int[] size;
    private int[] parent;

    public UF(int n){
        this.count=n;
        this.size=new int[n];
        this.parent=new int[n];
        for (int i=0;i<n;i++){
            size[i]=1;
            parent[i]=i;
        }
    }

    /* 将 p 和 q 连通 */
    public void union(int p, int q) {
        int rootP=find(p);
        int rootQ=find(q);

        if (rootP==rootQ){
            return;
        }

        if(size[rootP]>size[rootQ]){
            parent[rootQ]=rootP;
            size[rootP]+=size[rootQ];
        }else {
            parent[rootP]=rootQ;
            size[rootQ]+=size[rootP];
        }

        count--;
    }

    /* 判断 p 和 q 是否互相连通 */
    public boolean connected(int p, int q) {
        int rootP=find(p);
        int rootQ=find(q);
        return rootP==rootQ;
    }

    private int find(int x){
        while(parent[x]!=x){
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
