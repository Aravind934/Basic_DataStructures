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

class LinkedList < T > {

    Node list;
    int len = 0;

    public Node add(T val) {
        Node node = new Node(val);
        if (len == 0) {
            this.list = node;
            this.len++;
            return this.list;
        }
        Node temp = this.list;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        this.len++;
        return this.list;
    }

    public T get(int idx) {
        if (idx < 0 || idx > this.len) {
            return null;
        }
        Node temp = this.list;
        int i = 0;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        return (T) temp.val;
    }

    public boolean set(int idx, T val) {
        if (idx < 0 || idx >= len) {
            return false;
        }
        Node temp = this.list;
        int i = 0;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        temp.val = val;
        return true;
    }

    public boolean remove(int idx) {
        if (idx < 0 || idx >= len) {
            return false;
        }
        int i = 0;
        Node temp = this.list;
        if (idx == 0) {
            temp = temp.next;
            this.list = temp;
            return true;
        }
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        this.list = temp;
        return true;
    }

    public int size() {
        return this.len;
    }

    public String toString() {
        return this.list + "";
    }

}