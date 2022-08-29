class Node {
    val;
    next;
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    list;
    len = 0;
    add(val) {
        let node = new Node(val);
        if (this.len == 0) {
            this.list = node;
            this.len++;
            return this.list;
        }
        let temp = this.list;
        while (temp.next != null) {
            i++;
            temp = temp.next;
        }
        temp.next = node;
        this.len++;
        return this.list;
    }
    size() {
        return this.len;
    }
    get(idx) {
        if (idx < 0 || idx >= this.len) {
            return null;
        }
        let i = 0;
        let temp = this.list;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        return temp.val;
    }
    set(idx, val) {
        if (idx < 0 || idx >= this.len) {
            return null;
        }
        let i = 0;
        let temp = this.list;
        if (this.len == 0) {
            temp.val = val;
            return true;
        }
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        temp.val = val;
        return true;
    }
    remove(idx) {
        if (idx < 0 || idx >= this.len) {
            return false;
        }
        if (idx === 0) {
            this.list = this.list.next;
            return true;
        }
        let i = 0;
        let temp = this.list;
        while (i < idx - 1) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return true;
    }
}
