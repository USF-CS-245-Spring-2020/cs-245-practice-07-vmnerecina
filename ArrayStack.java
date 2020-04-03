/*
victoria nerecina
CS245 - practice assignment 7

ArrayStack

+push(T): void
    adds item to top of Stack
    arr[top] = item
    arr = arr + 1

+pop(): T
    removes item from Stack and returns item
    top = top - 1;
    return arr[top];

+peek(): T
    returns last item/ top of the Stack

+empyty(): boolean

 */

import java.util.*;
import java.util.Arrays;
import java.lang.*;


public class ArrayStack<T> implements Stack<T>
{
    public T[]arr;
    public int top;
    public int size;

    public ArrayStack()
    { //contructor
        arr = (T[]) new Object[10];
        top = 0; //
        size = 10;
    }



    public void growStack()
    {
        T[] newArr = (T[]) new Object[size * 2];
        //newArr = new T [size * 2];

        for(int i = 0; i < size; i++)
        {
            newArr[i] = arr[i];
        }
        arr = newArr;
        size = size * 2;
    }



    public void push(T item)
    { // adds item to top of Stack
        if(top == size)
        {
            growStack();
        }
        arr[top++] = item;
    }



    public T pop() throws Exception
    {//removes item from Stack and returns item
        if(top == 0) //if top == 0, if top is empty
        {
            throw new Exception("empty Stack");
        }
        else
            //remove top
            return arr[--top]; //return top and decrement
    }



    public T peek() throws Exception
    { //returns last item/ top of the Stack
        if(top == 0) //if top == 0, if top is empty
        {
            throw new Exception("empty Stack");
        }
        else
            return arr[top]; //returns top

    }



    public boolean empty()
    { //returs "true" if Stack is empty, "false" if Stack filled
        return top == 0;
    }
}