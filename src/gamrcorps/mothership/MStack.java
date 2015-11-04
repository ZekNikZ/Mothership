package src.gamrcorps.mothership;

import java.util.ArrayList;
import java.util.List;

//Standard stack class for storing data in a program

@SuppressWarnings("unchecked")
public class MStack implements MObject {
    private List<MObject> stack;

    public MStack() {
        stack = new ArrayList<MObject>();
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
    public void push(MObject value) {
        stack.add(value);
    }

    //Put an object at a specific index, and shift other values upwards
    public void put(int index, MObject value) {
        stack.add(index, value);
    }

    //Set an object at a specific index to the specified object
    public void set(int index, MObject value) {
        stack.set(index, value);
    }

    public int length() {
        return stack.size();
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < stack.size(); i++) {
            temp += stack.get(i);
        }
        return temp;
    }

    public String toString(String separator) {
        String temp = "";
        for (int i = 0; i < stack.size(); i++) {
            temp += stack.get(i);
            temp += separator;
        }
        return temp;
    }
}
