package com.oops.ex2;

class StackLinkedListImpl{
    private int[] x;
    private final int SIZE;
    private int top;

    public StackLinkedListImpl(int size) {
        this.SIZE = size;
        this.x = new int[SIZE]; 
        this.top = -1;
    }

    public void pushLLStack(int element) {
        if (top >= SIZE - 1) {   // 
            System.out.println("Stack Overflow!");
            return;
        }
        x[++top] = element;     
    }

    public int popLLStack() {
        if (top == -1) {      
            System.out.println("Stack Underflow!");
            return -99;
        }
        return x[top--];     
    }
}