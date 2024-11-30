class Node{
    int key;
    int val;
    Node next = null;
    Node prev = null;

    public Node(int _key, int _val){
        this.key = _key;
        this.val = _val;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node H;
    Node T;
    int cap;

    public Node deleteNode(Node rem){
        Node r = rem.next;
        Node l = rem.prev;

        Node tmp = l;
        l.next = r;
        r.prev = tmp;

        rem.next = null;
        rem.prev = null;

        return rem;
    }

    public void addNode(Node node){
        Node tmp = T.prev;
        tmp.next = node;
        node.next = T;
        node.prev = tmp;
        T.prev = node;
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        H = new Node(-1, -1);
        T = new Node(-1, -1);

        H.next = T;
        T.prev = H;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node tmp = map.get(key);

        // Extract the node and add before the tail
        Node del = deleteNode(tmp);
        addNode(del);

        return tmp.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node tmp = map.get(key);
            tmp.val = value;

            // Extract the node and add before the tail
            Node del = deleteNode(tmp);
            addNode(del);
            return;
        }

        Node newNode = new Node(key, value);

        if(map.size() == cap){
            Node del = deleteNode(H.next);
            map.remove(del.key);
        }

        addNode(newNode);
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */