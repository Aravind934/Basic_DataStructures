class ArrayList < T > {

    Object[] list;
    int idx = 0;

    public ArrayList(int size) {
        this.list = new Object[size];
    }

    public T[] add(T val) {
        if (idx >= list.length) {
            Object[] temp = new Object[this.list.length + 10];
            for (int i = 0; i < list.length; i++) {
                temp[i] = this.list[i];
            }
            this.list = temp;
        }
        list[idx++] = val;
        return (T[]) list;
    }

    public T get(int idx) {
        if (idx >= this.idx || idx < 0) {
            return null;
        }
        return (T) this.list[idx];
    }
    public boolean set(int idx, T val) {
        if (idx >= this.idx || idx < 0) {
            return false;
        }
        this.list[idx] = val;
        return true;
    }

    public boolean remove(int idx) {
        if (idx >= this.idx || idx < 0) {
            return false;
        }
        for (int i = idx + 1; i < this.list.length; i++) {
            this.list[i - 1] = this.list[i];
        }
        this.idx--;
        return true;
    }

    public int size() {
        return this.idx;
    }

    public boolean isEmpty() {
        return this.idx == 0;
    }

    public String toString() {
        return Arrays.toString(this.list);
    }

}