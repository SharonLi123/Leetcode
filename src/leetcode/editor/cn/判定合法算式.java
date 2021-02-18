package leetcode.editor.cn;

public class 判定合法算式 {
    boolean equationsPossible(String[] equations) {
        UF uf=new UF(26);

        for(String s:equations){
            if(s.charAt(1)=='='){
                uf.union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }

        for(String s:equations){
            if(s.charAt(1)=='!'){
                if(uf.connected(s.charAt(0)-'a',s.charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
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
