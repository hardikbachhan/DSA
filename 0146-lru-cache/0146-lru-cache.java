class LRUCache {
    
    public class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public String toString() {
            return key + "->" + value;
        }
    }
    
    public int cap;
    public HashMap<Integer, Node> cache;
    public Node head;
    public Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    // head ->  1 -> 2 -> 3 -> tail
    public void moveNodeToFront(Node curr) {
        Node temp = curr;
        // removing curr from current position
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // adding temp to start of dll
        temp.next = head.next;
        head.next.prev = temp;
        head.next = temp;
        temp.prev = head;
    }
    
    public void removeNode(Node curr) {
        if (cache.containsKey(curr.key) == false) {
            return;
        }
        curr.prev.next = tail;
        tail.prev = curr.prev;
        curr.prev = null;
        curr.next = null;
    }
    
    public void addNewNode(Node curr) {
        curr.next = head.next;
        head.next.prev = curr;
        head.next = curr;
        curr.prev = head;
    }
    
    public int get(int key) {
        // check if key exists in hashmap
        if (cache.containsKey(key)) {
            // if yes 
            // put node in front of dll
            // return value saved in node
            int rv = cache.get(key).value;
            moveNodeToFront(cache.get(key));
            return rv;
        }
        // if no
        // return -1    
        return -1;
    }
    
    public void put(int key, int value) {
        // check if key already exists in cache
        if (cache.containsKey(key)) {
            // if yes 
            // update value in node and put node in front of dll
            cache.get(key).value = value;
            moveNodeToFront(cache.get(key));
        } else {
            // if no
                // check if size of cache will not become greater than capacity on adding process
            if (cache.size() == cap) {
                // System.out.println("inside cap condition");
                // remove lru process from cache and dll
                int removeKey = tail.prev.key;
                // System.out.println("removeKey -> " + removeKey);
                removeNode(tail.prev);
                cache.remove(removeKey);
                // add key value pair in cache
            }
            // add key value pair in cache 
            // put node in front of dll
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            // add new node to dll at front
            addNewNode(newNode);
        }
        // System.out.println("put -> " + key +  " = " + cache);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */