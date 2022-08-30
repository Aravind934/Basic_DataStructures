class Node {
    val;
    next;
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

class Stack {
    head;
    tail;
    len = 0;
    push(val) {
        let node = new Node(val);
        if (this.len === 0) {
            this.len++;
            this.head = node;
            this.tail = node;
            return true;
        }
        let temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        this.len++;
        temp.next = node;
        this.tail = node;
        return true;
    }
    size() {
        return this.len;
    }
    pop() {
        if (this.len <= 0) return null;
        if (this.len === 1) {
            this.len--;
            this.head = null;
            this.tail = null;
            return true;
        }
        let temp = this.head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        this.len--;
        this.tail = temp;
        return true;
    }
    peek() {
        return this.tail.val;
    }
}

let stack = new Stack();
stack.push(100);
stack.push(200);
stack.push(300);
console.log(stack.peek());
