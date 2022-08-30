class Node {
    Object val;
    Node next;
    public Node(Object val) {
        this.val = val;
    }
    public String toString() {
        return this.val + "->" + this.next;
    }
}

class Queue < T > {
    Node head;
    Node tail;
    int len = 0;

    public boolean add(T val) {
        Node node = new Node(val);
        if (len == 0) {
            this.head = node;
            this.tail = node;
            this.len++;
            return true;
        }
        tail.next = node;
        tail = node;
        this.len++;
        return true;
    }

    public int size() {
        return this.len;
    }

    public T peek() {
        return (T) this.tail.val;
    }

    public T poll() {
        if (len <= 0) return null;
        T res = (T) this.head.val;
        this.head = this.head.next;
        this.len--;
        return res;
    }

    public String toString() {
        return this.head + "";
    }
    
}