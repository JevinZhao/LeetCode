import java.util.Stack;

class CQueue {
    Stack<Integer> inStack ;
    Stack<Integer> outStack;
    public CQueue() {
    inStack = new Stack<>();
     outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
        dumpInStack();
    }

    public int deleteHead() {
        if(!outStack.isEmpty()){
            return outStack.pop();
        }
        return -1;
    }
    /**
     出栈通用函数
     */
    private void dumpInStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}