package com.yu.canvassurfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.SurfaceHolder;

public class DrawingThread extends Thread {
    SurfaceHolder surfaceHolder;

    public DrawingThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run() {
        Canvas canvas = surfaceHolder.lockCanvas();
        if(canvas != null){
            //rectangle
            canvas.drawRGB(80,80,80);
            canvas.drawRoundRect(new RectF(50,50,150,300), 0, 0, new Paint(Paint.ANTI_ALIAS_FLAG));

            //triangle
            Path path = new Path();
            path.moveTo(100,520);
            path.lineTo(340,200);
            path.lineTo(510,520);
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setStyle(Paint.Style.FILL);
            p.setARGB(255,255,20,147);
            canvas.drawPath(path,p);

            //circle
            path.reset();
            path.addCircle(550,750,150, Path.Direction.CW);
            p.setARGB(255,148,0,211);
            canvas.drawPath(path,p);

            //text
            p.setARGB(255,143, 254, 9);
            p.setTextSize(90);
            canvas.drawText("Yuri krasavchik", 200, 1000, p);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
