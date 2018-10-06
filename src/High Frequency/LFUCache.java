import java.util.HashMap;
import java.util.LinkedHashSet;


/*
public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists; // count To key set
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<Integer>());
    }

    public int get(int key) {
        if (!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if (count == min && lists.get(count).size() == 0)
            min++;
        if (!lists.containsKey(count + 1))
            lists.put(count + 1, new LinkedHashSet<Integer>());
        lists.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0)
            return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        // 新加入元素，需要判断是否达到cap,并且将min置为1！！
        if (vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
            counts.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}



*/


public class LFUCache {
    int min = 0;
    HashMap<Integer, Integer> vals = new HashMap<>();
    HashMap<Integer, Integer> counts = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> countToKey = new HashMap<>();
    int cap = -1;

    public LFUCache(int cap) {
        this.cap = cap;
        countToKey.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        /**
         *如果存在值，那么返回对应的val，调整key对应的访问次数，可能修改min
         *
         * 如果不存在该key，那么返回-1，不做其他任何操作.
         */
        if (vals.containsKey(key)) {
            int count = counts.get(key);
            countToKey.get(count).remove(key);
            if (count == min && countToKey.get(count).isEmpty()) {
                // 更新min值
                ++min;
            }
            // 更新key对应的访问次数
            count++;
            if (!countToKey.containsKey(count)) {
                countToKey.put(count, new LinkedHashSet<>());
            }
            // 更新key对应频率的的位置
            countToKey.get(count).add(key);
            counts.put(key, count);
            return vals.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        /**
         *
         *  如果key已存在, 更新原始对应key的值，然后利用get(key)方法，来模拟增加一次访问的其他操作
         *
         *  如果key不存在：
         *  1. vals.size >=cap，删除访问次数最少且最先放入Cache的节点的节点，
         *
         *  2. vals.size <cap, 不做操作
         *  然后将key的节点放入，vals, counts, countTokey 中，更新min为1
         *
         */
        if (cap <= 0)
            return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            // 利用get方法来更新key在counts和countTokey的位置与min等的值
            get(key);
        } else {
            if (vals.size() >= cap) {
                int deleteKey = countToKey.get(min).iterator().next();
                vals.remove(deleteKey);
                counts.remove(deleteKey);
                countToKey.get(min).remove(deleteKey);
            }
            vals.put(key, value);
            counts.put(key, 1);
            countToKey.get(1).add(key);
            min = 1;
        }
    }

}

