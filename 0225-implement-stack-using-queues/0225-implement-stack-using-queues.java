class MyStack {
    // two queues, main and aux
    Queue<Integer> main;
    Queue<Integer> aux;
    
    public MyStack() {
        main = new ArrayDeque<>();
        aux = new ArrayDeque<>();
    }
    
    // we can make push operation O(1), pop and top functions will be O(n)
    // we can make push opeationn O(n), pop and top funtions will have o(1)
    
    // 1, 2, 3, 4, 5, 6
    public void push(int x) {
        main.add(x);
    }
    
    // aux -     
    // main - 1, 2, 3, 4, 5, 6
    public int helper() {
        while (main.size() > 1) {
            aux.add(main.remove());
        }
        // O(n)
        int topStack = main.remove();
        main = aux;
        aux = new ArrayDeque<>();
        return topStack;
    }
    
    public int pop() {
        int topStack = helper();
        return topStack;
    }
    
    public int top() {
        int topStack = helper();
        main.add(topStack);
        return topStack;
    }
    
    public boolean empty() {
        // if size of main is 0 then return true else false
        return main.size() == 0; // 0 == 0
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */