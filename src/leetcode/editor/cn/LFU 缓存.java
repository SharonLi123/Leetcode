package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFU 缓存{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {

    HashMap<Integer,Integer> keyToVal;
    HashMap<Integer,Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int minFreq;
    int cap;

    public LFUCache(int capacity) {
        this.cap=capacity;
        this.minFreq=0;
        this.keyToVal=new HashMap<>();
        this.keyToFreq=new HashMap<>();
        this.freqToKeys=new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (this.cap <= 0) {
            return;
        }

        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            increaseFreq(key);
            return;
        }

        if(keyToVal.size()>=cap){
            //移除频率最低的
            removeMinFreqKey();
        }

        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq=1;

    }

    private void removeMinFreqKey() {
        //从freqToKeys中获取minFreq
        LinkedHashSet<Integer> keyList= freqToKeys.get(minFreq);
        Integer minKey=keyList.iterator().next();
        keyList.remove(minKey);

        if(keyList.isEmpty()){
            freqToKeys.remove(minFreq);
        }

        keyToVal.remove(minKey);
        keyToFreq.remove(minKey);
    }

    private void increaseFreq(int key) {
        //找到freq
        Integer freq=keyToFreq.get(key);
        keyToFreq.put(key,freq+1);

        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);

        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if(freq==minFreq){
                this.minFreq++;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
