package leetcode.editor.cn;

import java.util.PriorityQueue;

public class 数据流的中位数{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    //小顶堆
    private PriorityQueue<Integer> large;
    //大顶堆
    private PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {
        large=new PriorityQueue<>();
        small=new PriorityQueue<>((a,b)->{
            return b-a;
        });
    }
    
    public void addNum(int num) {
        if(large.size()<=small.size()){
            small.offer(num);
            large.offer(small.poll());
        }else{
            large.offer(num);
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        } else if (large.size() < small.size()) {
            return small.peek();
        }
        return (large.peek() + small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
