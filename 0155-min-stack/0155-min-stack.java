class MinStack {
    public Stack<Long> s;
    public int min;
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (s.size() == 0) {
            s.push((long)val);
            min = val;
        } else if (val <= min) {
            long num = (long)(val) + (long)(val) - (long)(min);
            s.push(num);
            min = val;
        } else {
            long num = (long)(val);
            s.push(num);
        }
    }
    
    public void pop() {
        long num = s.pop();
        if (num <= min) {
            min = min + min - (int)num;
        }
    }
    
    public int top() {
        if (s.peek() >= (long)(min)) {
            long rv = s.peek();
            return (int)(rv);
        } else {
            return min;
        }
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */