package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;

public class 滑动窗口最大值{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue=new MonotonicQueue();
        ArrayList<Integer> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i<k-1){
                queue.push(nums[i]);
            }else {
                queue.push(nums[i]);
                res.add(queue.max());
                queue.pop(nums[i-k+1]);
            }
        }

        int[] arr=new int[res.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=res.get(i);
        }

        return arr;
    }
}

class MonotonicQueue{
    LinkedList<Integer> queue=new LinkedList<>();

    public void push(int x){
        while (!queue.isEmpty() && queue.peekLast()<x){
            queue.pollLast();
        }
        queue.offerLast(x);
    }

    public int max(){
        return queue.peekFirst();
    }

    public void pop(int x){
        if(x==queue.peekFirst()){
            queue.pollFirst();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
