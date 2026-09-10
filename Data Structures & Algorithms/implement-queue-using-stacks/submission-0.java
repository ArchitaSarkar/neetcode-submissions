class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    private void pushAtButtom(int x)
    {
        int s=s1.size();
        for(int i=0;i<s;i++)
        {
            s2.push(s1.pop());
        }
        s1.push(x);
         for(int i=0;i<s;i++)
        {
            s1.push(s2.pop());
        }
    }
    public void push(int x) {
        pushAtButtom(x);
    }
    
    public int pop() {
        if (empty()) return -1;
        return s1.pop();
    }
    
    public int peek() {
        if (empty()) return -1;
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.size()==0;
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