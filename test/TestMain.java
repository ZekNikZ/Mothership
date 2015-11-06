package test;

import src.gamrcorps.mothership.*;

public class TestMain {
    public static void main(String[] args) {
        MStack stack = new MStack();
        MParser parser = new MParser("2 30+72-2*8/\"Test\"\"Test2\"\"Test3\"'H'E'L'L'O", stack, true);
        System.out.println(stack.toString(""));
    }
}