class MyStack {
    
    Queue<Integer> q;
    public MyStack() {
       q=new LinkedList<>(); 
    }
    
    public void push(int x) {
        int s=q.size();
        q.add(x);
        // now do operations to bring the x at first position
        for(int i=0;i<s;i++)
        {
            q.add(q.remove());
        }
    }
    
    public int pop() {
        if (empty()) return -1;
        int val=q.remove();
        return val;
    }
    
    public int top() {
        if(empty()) return -1;
        return q.peek();
    }
    
    public boolean empty() {
        return q.size()==0;
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