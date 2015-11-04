package test;

import src.gamrcorps.mothership.*;

/**
 * Created by Matthew on 11/4/2015.
 */
public class TestMain {
    public static void main(String[] args) {
        MStack stack = new MStack();
        MParser parser = new MParser("2.75 36 72", stack, true);
        System.out.println(stack.toString(" "));
    }
}