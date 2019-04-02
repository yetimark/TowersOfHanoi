package com.example.towersofhanoi;

import android.view.ViewGroup;
import android.widget.TextView;

public class Stack
{
    private Node top;
    private int count;
    private String name;

    public Stack(String name)
    {
        this.top = null;
        this.count = 0;
        this.name = name;
    }

    public void push(Disk payload)
    {
        Node n = new Node(payload);
        n.setNextNode(this.top);
        this.top = n;
        this.count++;
    }

    public Disk pop()
    {
        //We are assuming we will not call pop on an empty list
        Node nodeToReturn = this.top;
        this.top = this.top.getNextNode();
        nodeToReturn.setNextNode(null);
        this.count--;
        return nodeToReturn.getPayload();
    }

    public Disk peek()
    {
        //FIXME: Spent about 2 hours getting an error from line 44 by having .getPayload() added
        Disk temp = new Disk(-1);

        if(this.top != null)
        {
            temp = this.top.getPayload();
        }
        //System.out.println("Peek: " + temp.getSize());
        return temp;
    }

    public void display()
    {
        System.out.println("| " + this.name + " Begins");
        //show elements on per line
        if(this.top == null)
        {
            System.out.println("* Empty Stack *");
        }
        else    //stuff is in here
        {
            Node currNode = this.top;

            do {
                System.out.println("* " + currNode.getPayload().getSize() + " *");    //#FIXME: Display size
                currNode = currNode.getNextNode();
            }
            while (currNode != null);
        }
        System.out.println("| " + this.name + " Ends");
    }

    public boolean isSmaller(Disk newDisk)
    {
        boolean isSmaller = false;
        if((newDisk.getSize() < this.peek().getSize()) || (this.peek().getSize() == -1))
        {
            isSmaller = true;
        }
        return isSmaller;
    }

    public int getCount()
    {
        return this.count;
    }
}
