package com.example.towersofhanoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView disk0TV, disk1TV, disk2TV;
    private Disk disk0, disk1, disk2, placeHolder;
    private Tower tower0, tower1, tower2;
    private ViewGroup tower0VG, tower1VG, tower2VG, placeHolderVG;
    boolean placeHolderIsEmpty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create TextViews
        this.disk0TV = (TextView)this.findViewById(R.id.disk0);
        this.disk1TV = (TextView)this.findViewById(R.id.disk1);
        this.disk2TV = (TextView)this.findViewById(R.id.disk2);

        //Create Disks
        this.disk0 = new Disk(1);
        this.disk1 = new Disk(2);
        this.disk2 = new Disk(3);
        this.placeHolder = null;

        //Create Towers
        this.tower0 = new Tower();
        this.tower1 = new Tower();
        this.tower2 = new Tower();

        //Create ViewGroups
        this.tower0VG = this.findViewById(R.id.tower0VG);
        this.tower1VG = this.findViewById(R.id.tower1VG);
        this.tower2VG = this.findViewById(R.id.tower2VG);
        this.placeHolderVG = this.findViewById(R.id.placeHolderVG);

        //Fill First Tower
        this.tower0.push(this.disk2);
        this.tower0.push(this.disk1);
        this.tower0.push(this.disk0);
        this.displayTowers();
    }


    //Resets game on win condition
    private void resetGame()
    {
        if(this.tower2.getCount() == 3)
        {
            this.finish();
            this.startActivity(getIntent());
        }
    }

    private void selectSource(Tower tower, ViewGroup towerVG)
    {
        if(tower.peek() != null)
        {
            this.placeHolder = tower.pop();
            TextView temp = (TextView)towerVG.getChildAt(0);
            towerVG.removeViewAt(0);
            this.placeHolderVG.addView(temp);
            this.placeHolderIsEmpty = false;
        }
    }

    private void selectDestination(Tower tower, ViewGroup towerVG)
    {
        if(tower.push(this.placeHolder))
        {
            this.placeHolder = null;
            TextView temp = (TextView)this.placeHolderVG.getChildAt(0);
            this.placeHolderVG.removeViewAt(0);
            towerVG.addView(temp, 0);
            this.placeHolderIsEmpty = true;
        }
    }

    //0
    public void tower0ButtonPressed(View v)
    {
        if(this.placeHolderIsEmpty)
        {
            this.selectSource(this.tower0, this.tower0VG);
        }
        else
        {
            this.selectDestination(this.tower0, this.tower0VG);
        }
        this.displayTowers();
    }

    //1
    public void tower1ButtonPressed(View v)
    {
        if(this.placeHolderIsEmpty)
        {
            this.selectSource(this.tower1, this.tower1VG);
        }
        else
        {
            this.selectDestination(this.tower1, this.tower1VG);
        }
        this.displayTowers();
    }

    //2
    public void tower2ButtonPressed(View v)
    {
        if(this.placeHolderIsEmpty)
        {
            this.selectSource(this.tower2, this.tower2VG);
        }
        else
        {
            this.selectDestination(this.tower2, this.tower2VG);
        }
        this.displayTowers();

        this.resetGame();
    }

    public void displayTowers()
    {
        System.out.println(" \n");
        if(this.placeHolder != null)
        {
            this.placeHolder.display();
        }
        this.tower0.display();
        this.tower1.display();
        this.tower2.display();
        System.out.println("\n ");
    }
}
