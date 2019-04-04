package com.example.towersofhanoi;

import android.widget.TextView;

public class Disk
{
    private int size;
    private Disk nextDisk;

    public Disk(int size)
    {
        this.size = size;
        this.nextDisk = null;
    }

    public int getSize()
    {
        return this.size;
    }

    public Disk getNextDisk()
    {
        return this.nextDisk;
    }

    public void setNextDisk(Disk newNext)
    {
        this.nextDisk = newNext;
    }

    public void display()
    {
        String answer = "";
        for(int i = 0; i < this.size; i++)
        {
            answer += "*";
            answer += "*";
        }
        System.out.println(answer);
    }
}
