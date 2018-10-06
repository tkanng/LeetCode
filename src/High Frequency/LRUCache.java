import java.util.HashMap;

public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    // 从双向链表中删除某一节点
    public void remove(Node node) {
        if (node == null)
            return;
        // node 是头节点,也是尾节点
        if (node == head && node == end) {
            head = null;
            end = null;
            return;
        }
        // node 是头结点
        if (node == head) {
            head = node.next;
            return;
        }
        // node 是尾节点
        if (node == end) {
            end = end.pre;
            return;
        }
        // node 既不是头节点，也不是尾节点
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    // 设置头结点
    public void setHead(Node node) {
        if (node == null)
            return;
        // 链表为空
        if (head == null) {
            head = node;
            end = node;
            return;
        }
        node.next = head;
        head.pre = node;  // 记得这是一个双向链表！！！！
        head = node;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);

            } else {
                setHead(created);
            }

            map.put(key, created);
        }

    }

    public void printNodes(String explain) {

        System.out.print(explain + ":" + head.toString());
        Node node = head.next;
        while (node != null) {
            System.out.print(node.toString());
            node = node.next;
        }
        System.out.println();
    }
/*
    public static void main(String[] args) {
        LRUCache lruCacheTest = new LRUCache(5);
        lruCacheTest.set(1, 1);
        lruCacheTest.set(2, 2);
        lruCacheTest.set(3, 3);
        lruCacheTest.set(4, 4);
        lruCacheTest.set(5, 5);
        System.out.println("lruCacheTest.get(1):" + lruCacheTest.get(1));
        lruCacheTest.set(6, 6);
        System.out.println("lruCacheTest.get(2):" + lruCacheTest.get(2));
    }
*/
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.key + "-" + this.value + " ";
    }
}
