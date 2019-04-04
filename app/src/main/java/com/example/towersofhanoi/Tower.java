package com.example.towersofhanoi;

import android.view.ViewGroup;

public class Tower
{
    private Disk top;
    private int count;
    //private ViewGroup VG;

    public Tower()
    {
        this.top = null;
        this.count = 0;
        //this.VG = VG;
    }

    public int getCount()
    {
        return this.count;
    }

    public Disk peek()
    {
        return this.top;
    }

    public boolean push(Disk newTop)
    {
        if(this.top == null)
        {
            this.top = newTop;
            this.count++;
            return true;
        }
        else if(newTop.getSize() < this.top.getSize())
        {
            newTop.setNextDisk(this.top);
            this.top = newTop;
            this.count++;
            return true;
        }
        else
        {
            System.out.println("Sorry Filled by: " + this.top.getSize());
            return false;
        }
    }

    public Disk pop()
    {
        Disk temp = null;
        if(this.top != null)
        {
            temp = this.top;
            this.top = this.top.getNextDisk();
            temp.setNextDisk(null);
            this.count--;
        }
        return temp;
    }

    public void display()
    {
        System.out.println("Tower Count: " + this.count);
        Disk currDisk = this.top;
        while(currDisk != null)
        {
            currDisk.display();
            currDisk = currDisk.getNextDisk();
        }
        System.out.println("Tower Ends \n ");
    }

}
