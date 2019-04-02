package com.example.towersofhanoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView disk0TV, disk1TV, disk2TV, fakeDiskTV;
    private Disk disk0, disk1, disk2, fakeDisk;
    private ViewGroup tower0VG, tower1VG, tower2VG, placeholderVG;
    private Stack tower0Stk, tower1Stk, tower2Stk, placeholderStk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //#FIXME: Do I need variables for the TVs since I have it in Disk?  NO
        //this section was left in incase inclass solution differs greatly
        this.disk0TV = this.findViewById(R.id.disk0);
        this.disk1TV = this.findViewById(R.id.disk1);
        this.disk2TV = this.findViewById(R.id.disk2);
        //this.fakeDiskTV = this.findViewById(R.id.fakeTV);

        this.disk0 = new Disk(1, this.disk0TV);
        this.disk1 = new Disk(2, this.disk1TV);
        this.disk2 = new Disk(3, this.disk2TV);
        //this.fakeDisk = new Disk(-1);

        this.placeholderVG = this.findViewById(R.id.placeHolderVG);
        this.tower0VG = this.findViewById(R.id.tower0VG);
        this.tower1VG = this.findViewById(R.id.tower1VG);
        this.tower2VG = this.findViewById(R.id.tower2VG);

        this.placeholderStk = new Stack("PlaceHolder");
        this.tower0Stk = new Stack("Tower0");
        this.tower1Stk = new Stack("Tower1");
        this.tower2Stk = new Stack("Tower2");


        //Fill First Stack
        this.tower0Stk.push(this.disk2);
        this.tower0Stk.push(this.disk1);
        this.tower0Stk.push(this.disk0);
        this.displayTowers();
    }

    //0
    public void tower0ButtonPressed(View v)
    {
        if(this.placeholderStk.peek().getSize() != -1)
        {
            if(this.tower0Stk.isSmaller(this.placeholderStk.peek()))
            {
                //ADD to tower
                Disk tempDisk = this.placeholderStk.pop();
                this.tower0Stk.push(tempDisk);

                View temp = this.placeholderVG.getChildAt(0);
                this.placeholderVG.removeViewAt(0);
                this.tower0VG.addView(temp, 0);
            }
        }
        else if(this.tower0Stk.peek().getSize() != -1)
        {
            //REMOVE from tower
            Disk tempDisk = this.tower0Stk.pop();
            this.placeholderStk.push(tempDisk);

            View temp = this.tower0VG.getChildAt(0);
            this.tower0VG.removeViewAt(0);
            this.placeholderVG.addView(temp);
        }
        this.displayTowers();
    }

    //1
    public void tower1ButtonPressed(View v)
    {
        if(this.placeholderStk.peek().getSize() != -1)
        {
            if(this.tower1Stk.isSmaller(this.placeholderStk.peek()))
            {
                //ADD to tower
                Disk tempDisk = this.placeholderStk.pop();
                this.tower1Stk.push(tempDisk);

                View temp = this.placeholderVG.getChildAt(0);
                this.placeholderVG.removeViewAt(0);
                this.tower1VG.addView(temp, 0);
            }
        }
        else if(this.tower1Stk.peek().getSize() != -1)
        {
            //REMOVE from tower
            Disk tempDisk = this.tower1Stk.pop();
            this.placeholderStk.push(tempDisk);

            View temp = this.tower1VG.getChildAt(0);
            this.tower1VG.removeViewAt(0);
            this.placeholderVG.addView(temp);
        }
        this.displayTowers();
    }

    //2
    public void tower2ButtonPressed(View v)
    {
        if(this.placeholderStk.peek().getSize() != -1)
        {
            if(this.tower2Stk.isSmaller(this.placeholderStk.peek()))
            {
                //ADD to tower
                Disk tempDisk = this.placeholderStk.pop();
                this.tower2Stk.push(tempDisk);

                View temp = this.placeholderVG.getChildAt(0);
                this.placeholderVG.removeViewAt(0);
                this.tower2VG.addView(temp, 0);
            }
        }
        else if(this.tower2Stk.peek().getSize() != -1)
        {
            //REMOVE from tower
            Disk tempDisk = this.tower2Stk.pop();
            this.placeholderStk.push(tempDisk);

            View temp = this.tower2VG.getChildAt(0);
            this.tower2VG.removeViewAt(0);
            this.placeholderVG.addView(temp);
        }
        this.displayTowers();
    }

    public void displayTowers()
    {
        this.placeholderStk.display();
        this.tower0Stk.display();
        this.tower1Stk.display();
        this.tower2Stk.display();
    }
}
