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

class Stack < T > {

    Node list;
    Node tail;
    int len = 0;

    public boolean push(T val) {
        Node node = new Node(val);
        if (tail == null) {
            this.list = node;
            this.tail = node;
            this.len++;
            return true;
        }
        tail.next = node;
        tail = node;
        this.len++;
        return true;
    }

    public boolean pop() {
        Node temp = this.list;
        if (len <= 0) return false;
        if (len == 1) {
            this.list = null;
            this.tail = null;
            this.len--;
            return true;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        this.tail = temp;
        this.len--;
        temp.next = null;
        return true;
    }

    public T peek() {
        if (len <= 0) return null;
        return (T)this.tail.val;
    }

    public int size() {
        return this.len;
    }

    public String toString() {
        return this.list + "";
    }

}