class Node {
    constructor(key, val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

class HashTable {
    finalSize = 100;
    constructor(size) {
        this.finalSize = Math.min(size, this.finalSize);
        this.arr = [];
        this.arr.fill(null);
    }

    hash(key) {
        let res = 0;
        for (let i = 0; i < key.length; i++) {
            res = (key.charCodeAt() + 32 + res) % this.finalSize;
        }
        return res;
    }

    put(key, val) {
        let node = new Node(key, val);
        let idx = this.hash(key);
        if (this.arr[idx] == null) {
            this.arr[idx] = node;
            return true;
        }
        let temp = this.arr[idx];
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return true;
    }

    get(key) {
        let idx = this.hash(key);
        let res = null;
        let temp = this.arr[idx];
        while (true) {
            if (temp == null || temp.key === key) {
                if (temp != null) res = temp.val;
                break;
            }
            temp = temp.next;
        }
        return res;
    }

    replace(key, val) {
        let idx = this.hash(key);
        let temp = this.arr[idx];
        let res = false;
        while (true) {
            if (temp == null || temp.key === key) {
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

    remove(key) {
        let idx = this.hash(key);
        let temp = this.arr[idx];
        let prev = null;
        let res = false;
        if (temp == null) return false;
        if (temp.next == null) {
            this.arr[idx] = null;
            return true;
        }
        while (true) {
            if (temp == null || temp.key === key) {
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
}
