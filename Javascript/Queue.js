class Node {
    val;
    next;
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

class Queue {
    head;
    tail;
    len = 0;
    add(val) {
        let node = new Node(val);
        if (this.len == 0) {
            this.head = node;
            this.tail = node;
            this.len++;
            return true;
        }
        this.tail.next = node;
        this.tail = node;
        this.len++;
        return true;
    }
    size() {
        return this.len;
    }
    peek() {
        return this.tail.val;
    }
    poll() {
        if (this.len <= 0) return null;
        let res = this.head.val;
        this.head = this.head.next;
        this.len--;
        return res;
    }
}
