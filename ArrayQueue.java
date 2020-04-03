/*
victoria nerecina
CS245 - practice assignment 7

ArrayQueue

+enqueue(T): void
    adds item to "back" of the Queue
    arr[back++] = item

+dequeue(): T
    removes an item from "front" of the Queue
    return arr[front++]

+empty(): boolean
    returns "true" if the Queue is empty and "false" if there is at least one item
    return front == back + 1

 */

import java.util.*;
import java.lang.*;


public class ArrayQueue<T> implements Queue<T>
{
    //using circular array help from GeeksforGeeks
    static final int defaultSize = 10;

    public T[]arr;
    public int front; //head
    public int back; //tail
    public int size; //track number of itmes in Queue

    public ArrayQueue(int maxSize)
    { //as circular array
       // arr = new T[maxSize + 1];
        arr = (T[]) new Object[maxSize + 1];
        front = 0; //head
        back = 0; //tail
        size = maxSize + 1;
    }



    public ArrayQueue()
    {
        //arr = new T[defaultSize + 1];
        arr = (T[]) new Object[defaultSize + 1];
        front = 0;
        back = 0;
        size = defaultSize + 1;
    }



    public void growQueue()
    {
        T[] tempArr = (T[]) new Object[size * 2];
        for(int i = 0; i < size; i++)
        {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
        size = size * 2;
    }


    public T dequeue() throws Exception
    { //removes an item from "front" of the Queue
        T value;
        if(front == back)
        {
            throw new Exception("empty Queue");
        }
        value = arr[front];
        front = (front + 1) % size;
        return value;
    }



    public void enqueue(T item)
    { //adds item to "back" of the Queue
        //++size;
        if(back == size)
        {
            growQueue();
        }
        //arr[++back % size] = item; //???????
        arr[back++ % size] = item;
    }



    public boolean empty()
    { //returns "true" if the Queue is empty and "false" if there is at least one item
        return front == back;

    }
}