class MyHashMap {
    
    private class HMNode {
        public int key;
        public int value;
        
        HMNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<HMNode>[] buckets;
    private int size;
    
    public MyHashMap() {
        size = 0;
        buckets = new LinkedList[5];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private HMNode find(LinkedList<HMNode> ll, int key) {
        for (HMNode node: ll) {
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }
    
    private int hashFunc(int key) {
        Integer keyObj = key;
        int hCode = keyObj.hashCode();
        int absHCode = Math.abs(hCode);
        int bi = absHCode % buckets.length;
        return bi;
    }
    
    public void put(int key, int value) {
        int bi = hashFunc(key);
        
        HMNode node = find(buckets[bi], key);
        
        if (node != null) {
            node.value = value;
        } else {
            HMNode newNode = new HMNode(key, value);
            buckets[bi].addLast(newNode);
            size++;
        }
        
        double lambda = ((size * 1.0) / buckets.length);
        if (lambda > 2.0) {
            LinkedList<HMNode>[] oldBuckets = buckets;
            buckets = new LinkedList[oldBuckets.length * 2];
            for(int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (LinkedList<HMNode> ll: oldBuckets) {
                for (HMNode hmNode: ll) {
                    put(hmNode.key, hmNode.value);
                }
            }
        }
    }
    
    public int get(int key) {
        int bi = hashFunc(key);
        
        HMNode node = find(buckets[bi], key);
        
        if (node != null) {
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void remove(int key) {
        int bi = hashFunc(key);
        
        HMNode node = find(buckets[bi], key);
        
        if (node != null) {
            buckets[bi].remove(node);
            size--;
        }
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */