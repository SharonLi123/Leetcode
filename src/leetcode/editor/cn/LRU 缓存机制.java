package leetcode.editor.cn;

import java.util.HashMap;

public class LRU 缓存机制{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private int capacity;
    private DoubleList cache;
    private HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        cache=new DoubleList();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node= map.get(key);
            cache.remove(node);
            cache.addLast(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            cache.remove(node);
        }
        if(cache.size()>=capacity){
            Node node=cache.removeFirst();
            map.remove(node.key);

        }
        Node node1=new Node(key,value);
        cache.addLast(node1);
        map.put(key,node1);
    }
}

class Node{
    public int key;
    public int val;
    public Node prev,next;

    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}

class DoubleList{
    private Node head,tail;
    private int size;

    public DoubleList(){
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        this.size=0;
    }

    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeFirst(){
        if (head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size(){
        return size;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
