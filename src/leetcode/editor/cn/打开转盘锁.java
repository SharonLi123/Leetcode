package leetcode.editor.cn;

import java.util.*;

public class 打开转盘锁{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        for(String s:deadends){
            if(s.equals("0000")){
                return -1;
            }
        }
        if(target.equals("0000")){
            return 0;
        }
        int minTime=1;
        Deque<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        visited.add("0000");
        queue.add("0000");

        while (!queue.isEmpty()){
            Deque<String> temp=new LinkedList<>();
            while (!queue.isEmpty()){
                String curr=queue.poll();
                for(int i=0;i<4;i++){
                    String afterAdd=up(curr,i);
                    if(!visited.contains(afterAdd)){
                        temp.offer(afterAdd);
                        visited.add(afterAdd);
                        for(String s:deadends){
                            if (afterAdd.equals(s)){
                                temp.pollLast();
                                break;
                            }
                            if(afterAdd.equals(target)){
                                return minTime;
                            }
                        }
                    }

                    String afterDown=down(curr,i);
                    if(!visited.contains(afterDown)){
                        temp.offer(afterDown);
                        visited.add(afterDown);
                        for(String s:deadends){
                            if (afterDown.equals(s)){
                                temp.pollLast();
                                break;
                            }
                            if(afterDown.equals(target)){
                                return minTime;
                            }
                        }
                    }

                }
            }
            queue.addAll(temp);
            minTime++;
        }

        return -1;
    }

    String up(String curr,int i){
        char[] cs=curr.toCharArray();
        cs[i]+=1;
        if(cs[i]=='0'+10){
            cs[i]='0';
        }
        return new String(cs);
    }

    String down(String curr,int i){
        char[] cs=curr.toCharArray();
        cs[i]-=1;
        if(cs[i]=='0'-1){
            cs[i]='9';
        }
        return new String(cs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
