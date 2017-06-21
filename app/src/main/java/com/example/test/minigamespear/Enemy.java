package com.example.test.minigamespear;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by Андрей on 19.06.2017.
 */

public class Enemy extends Creature {
    public boolean isAlive;

    public Enemy(int points, double x, double y, double x1, double y1, double v, int size) {
        this.points = points;
        this.isAlive = true;
        this.x=x;
        this.y=y;
        this.v=v;
        this.sin=y1-y;
        this.cos=x1-x;
        this.size=size;
        this.paint=new Paint();
        paint.setColor(0xffff0000);
        Log.d("spawn enemy","The enemy was added (size="+this.size+").");
    }

    @Override
    public void draw(Canvas canvas) {
        this.r=1+(this.size-Player.size)*0.2;
        float x=C_PNCOBATEJIb.xToP(this.x-Player.x),
                y=C_PNCOBATEJIb.yToP(this.y-Player.y),
                r=C_PNCOBATEJIb.rToP(this.r);
        canvas.drawCircle(x,y,r,this.paint);
        Log.d("enemy",x+" "+y+" "+r);
        Log.d("enemy",this.x+" "+this.y+" "+this.r);
    }

    @Override
    public void move(Player player) {
        this.x+=this.v*this.cos;
        this.y+=this.v*this.sin;
        if(getR(Player.x,Player.y)<=(this.r+player.r)){
            if(this.size>player.size)player.suffer();
            else player.eat(this);
            this.isAlive=false;
        }
    }
    private double getR(double x,double y){
        return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
    }
}
