//59.2 队列的最大值
//思路：双端队列



//双端队列：31 ms/10.32%; 48.9 MB/92.96%
class MaxQueue {

    //队列声明
    Deque<Integer> deque;
    Queue<Integer> queue;

    public MaxQueue() {
        //初始化两个队列
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }
    
    public int max_value() {
        if(!deque.isEmpty())
            return deque.peekFirst();
        return -1;
    }
    
    public void push_back(int value) {
        queue.add(value);
        while(!deque.isEmpty() && deque.peekLast()<value)//是循环不是if判断
            deque.removeLast();
        deque.addLast(value);
    }
    
    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.removeFirst();
        return queue.remove();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
