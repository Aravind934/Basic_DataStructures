import java.util.*;

class Node {
    String key;
    Object val;
    Node next;
    public Node(String key, Object val) {
        this.key = key;
        this.val = val;
    }
    public String toString() {
        return this.val + "->" + this.next;
    }
}

class HashTable {
    Node[] arr;
    int finalSize = 100;

    public HashTable(int size) {
        finalSize = Math.min(size, finalSize);
        arr = new Node[finalSize];
    }

    public int hash(String key) {
        int res = 0;
        for (int i = 0; i < key.length(); i++) {
            res = (key.charAt(i) + 32 + res) % finalSize;
        }
        return res;
    }

    public boolean put(String key, Object val) {
        Node node = new Node(key, val);
        int idx = this.hash(key);
        if (this.arr[idx] == null) {
            this.arr[idx] = node;
            return true;
        }
        Node temp = this.arr[idx];
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return true;
    }

    public Object get(String key) {
        int idx = this.hash(key);
        Object res = null;
        Node temp = this.arr[idx];
        while (true) {
            if (temp == null || temp.key.equals(key)) {
                if (temp != null) res = temp.val;
                break;
            }
            temp = temp.next;
        }
        return res;
    }

    public boolean replace(String key, Object val) {
        int idx = this.hash(key);
        Node temp = this.arr[idx];
        boolean res = false;
        while (true) {
            if (temp == null || temp.key.equals(key)) {
                if (temp != null) {
                    temp.val = val;
                    res = true;
                }
                break;
            }
            temp = temp.next;
        }
        return res;
    }

    public boolean remove(String key) {
        int idx = this.hash(key);
        Node temp = this.arr[idx];
        Node prev = null;
        boolean res = false;
        if (temp == null) return false;
        if (temp.next == null) {
            this.arr[idx] = null;
            return true;
        }
        while (true) {
            if (temp == null || temp.key.equals(key)) {
                if (temp != null) {
                    res = true;
                    prev.next = temp.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return res;
    }

    public String toString() {
        return Arrays.toString(arr);
    }
    
}