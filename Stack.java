public class Stack {

    public static void main(String[] args){
        Stack myStack = new Stack();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        while(!myStack.isEmpty()){
            myStack.pop();
        }
    }
    int number[] = new int[10];
    //LIFO
    int top;

    public Stack(){
        top = -1;
        for (int i = 0; i < number.length; i++) {
            number[i] = 0;
        }
    }

    boolean isEmpty(){
        if (top == -1) return true;
        else return false;
    }

    void push(int val){
        top++;
        number[top] = val;
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            throw new ArithmeticException();
        }
        else {
        int val = number[top];
        top--;
        System.out.println(val);
        return val;
        }
    }
}
