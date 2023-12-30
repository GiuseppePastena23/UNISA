package pila;

public class Pila {
    int[] nums;
    int top;

    public Pila() {
        nums = new int[4];
        top = 0;
    }

    public boolean isEmpty(){
        return top <= 0;
    }

    public boolean push(int elem) {
        if(top > 4)
            return false;
        nums[top] = elem;
        top++;
        return true;
    }

    public int pop() {
        if(!this.isEmpty()){
            top--;
            return nums[top];
        }
        return -1;
    }
}
