class MyQueue {
    Stack<Integer> main;
    Stack<Integer> aux;
    
    public MyQueue() {
        main = new Stack<>();
        aux = new Stack<>();
    }
    // 1, 2, 3, 4, 5, 6
    public void push(int x) {
        main.push(x);
    }
    
    public int helper() {
        while (main.size() > 1) {
            aux.push(main.pop());
        }
        int rv = main.pop();
        return rv;
    }
    
    public int pop() {
        int top = helper();
        while (aux.size() > 0) {
            main.push(aux.pop());
        }
        return top;
    }
    
    public int peek() {
        int top = helper();
        main.push(top);
        while (aux.size() > 0) {
            main.push(aux.pop());
        }
        return top;
    }
    
    public boolean empty() {
        return main.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */