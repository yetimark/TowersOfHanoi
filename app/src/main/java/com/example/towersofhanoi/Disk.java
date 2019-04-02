package com.example.towersofhanoi;

import android.widget.TextView;

public class Disk
{
    private int size;
    private TextView tv;

    public Disk(int size)
    {
        this.size = size;
        this.tv = null;
    }

    public Disk(int size, TextView tv)
    {
        this.size = size;
        this.tv = tv;
    }

    public int getSize()
    {
        return this.size;
    }

    public TextView getTV()
    {
        return this.tv;
    }
}
