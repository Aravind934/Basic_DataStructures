class ArrayList {
    list = [];
    add(val) {
        this.list.push(val);
        return this.list;
    }
    get(idx) {
        if (idx < 0 || idx >= this.list.length) return null;
        return this.list[idx];
    }
    set(idx, val) {
        if (idx < 0 || idx >= this.list.length) return false;
        this.list[idx] = val;
        return true;
    }
    remove(idx) {
        if (idx >= this.list.length || idx < 0) return false;
        for (let i = idx + 1; i < this.list.length; i++) {
            this.list[i - 1] = this.list[i];
        }
        this.list.pop();
        return true;
    }
    isEmpty() {
        return this.list.length === 0;
    }
    size() {
        return this.list.length;
    }
}
