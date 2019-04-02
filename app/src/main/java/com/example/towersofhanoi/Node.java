package com.example.towersofhanoi;

public class Node
{
    private Disk payload;
    private Node nextNode;

    public Node(Disk payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public void setNextNode(Node nextNode)
    {
        this.nextNode = nextNode;
    }

    public Disk getPayload()
    {
        return this.payload;
    }

    public Node getNextNode()
    {
        return this.nextNode;
    }
}
