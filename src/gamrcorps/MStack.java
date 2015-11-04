package src.gamrcorps;

import java.util.ArrayList;
import java.util.List;

//Standard stack class for storing data in a program

@SuppressWarnings("unchecked")
public class MStack {
    private List stack;

    public MStack() {
        stack = new ArrayList<>();
    }

    //Remove and return object at the top of the stack
    public Object pop() {
        return grab(stack.size() - 1);
    }

    //Return object at the top of the stack
    public Object peek() {
        return peek(stack.size() - 1);
    }

    //Remove and return object at the index specified
    public Object grab(int index) {
        return stack.size() > 0 ? stack.remove(index) : MNumber.zero();
    }

    //Return object at the index specified
    public Object peek(int index) {
        return stack.size() > 0 ? stack.get(index) : MNumber.zero();
    }

    //Put an object at the top of the stack
    public void push(Object value) {
        stack.add(value);
    }

    //Put an object at a specific index, and shift other values upwards
    public void put(int index, Object value) {
        stack.add(index, value);
    }

    //Set an object at a specific index to the specified object
    public void set(int index, Object value) {
        stack.set(index, value);
    }
}
