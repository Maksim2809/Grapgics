package com.company;

import com.company.coordinatesystem.CartesianScreenPlane;
import com.company.coordinatesystem.Converter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CartesianPainter extends Painter {
    CartesianScreenPlane cartesianScreenPlane ;
    static final int EPS = 5;
    boolean left = true;

    public CartesianPainter(CartesianScreenPlane csPlane, boolean b){
        cartesianScreenPlane = csPlane;
        left = b;
    }

    public void ValueMaus(int x, int y, boolean l){
    }

    public void addDot(int x, int y){

    }

    @Override
    public void paint(Graphics g) {
        drawSetka(g);
        drawAxis(g);
        if(left) drawFuncktions(g);
        else{
            drawParametrF(g);
        }

    }

    private void drawAxis(Graphics g){
        g.setColor(Color.BLUE);

        if (cartesianScreenPlane.getXMin()>0){
            g.drawLine(2,
                    0,
                    2,
                    cartesianScreenPlane.getHeight());
            for (int i = (int)cartesianScreenPlane.getYMin();i<cartesianScreenPlane.getYMax();i++){
                g.drawString(""+i,
                        15,
                        Converter.yCrt2Scr(i,cartesianScreenPlane));
            }
        }
        else{
            g.drawLine(Converter.xCrt2Scr(0,cartesianScreenPlane),
                    0,
                    Converter.xCrt2Scr(0,cartesianScreenPlane),
                    cartesianScreenPlane.getHeight());
            for (int i = (int)cartesianScreenPlane.getYMin(); i<cartesianScreenPlane.getYMax();i++){
                g.drawString(""+i,
                        Converter.xCrt2Scr(0, cartesianScreenPlane)+10,
                        Converter.yCrt2Scr(i,cartesianScreenPlane));
            }
        }
        if (cartesianScreenPlane.getXMax()<0){
            g.drawLine(cartesianScreenPlane.getWidth()-2,
                    0,
                    cartesianScreenPlane.getWidth()-2,
                    cartesianScreenPlane.getHeight()
            );
        }

        if (cartesianScreenPlane.getYMin()>0){
            g.drawLine(0,cartesianScreenPlane.getHeight()-2,
                    cartesianScreenPlane.getWidth(),
                    cartesianScreenPlane.getHeight()-2 );
            for (int i = (int)cartesianScreenPlane.getXMin(); i<cartesianScreenPlane.getXMax();i++){
                g.drawString(""+i,
                        Converter.xCrt2Scr(i, cartesianScreenPlane),
                        cartesianScreenPlane.getHeight()-7);
            }
            if ((int)cartesianScreenPlane.getXMax()==cartesianScreenPlane.getXMax()){
                g.drawString(""+(int)cartesianScreenPlane.getXMax(),
                        cartesianScreenPlane.getWidth()-3,
                        cartesianScreenPlane.getHeight()-7);
            }
            else{
                g.drawString(""+(int)cartesianScreenPlane.getXMax(),
                        Converter.xCrt2Scr((int)cartesianScreenPlane.getXMax(), cartesianScreenPlane),
                        cartesianScreenPlane.getHeight()-7);
            }
        }
        else{
            g.drawLine(0,Converter.yCrt2Scr(0,
                    cartesianScreenPlane),
                    cartesianScreenPlane.getWidth(),
                    Converter.yCrt2Scr(0,cartesianScreenPlane) );
            for (int i = (int)cartesianScreenPlane.getXMin(); i<cartesianScreenPlane.getXMax();i++){
                g.drawString(""+i,
                        Converter.xCrt2Scr(i, cartesianScreenPlane),
                        Converter.yCrt2Scr(0,cartesianScreenPlane)-5);
            }
            if ((int)cartesianScreenPlane.getXMax()==cartesianScreenPlane.getXMax()){
             g.drawString(""+(int)cartesianScreenPlane.getXMax(),
                        cartesianScreenPlane.getWidth()-3,
                        Converter.yCrt2Scr(0,cartesianScreenPlane)-5);
            }
            else{
                g.drawString(""+(int)cartesianScreenPlane.getXMax(),
                        Converter.xCrt2Scr((int)cartesianScreenPlane.getXMax(), cartesianScreenPlane),
                        Converter.yCrt2Scr(0,cartesianScreenPlane)-5);
            }
        }
        if (cartesianScreenPlane.getYMax()<0){
            g.drawLine(0,
                    2,
                    cartesianScreenPlane.getWidth(),
                    2);

            for (int i = (int)cartesianScreenPlane.getXMin(); i<cartesianScreenPlane.getXMax();i++){
                g.drawString(""+i,
                        Converter.xCrt2Scr(i, cartesianScreenPlane),
                        10);
            }
            if ((int)cartesianScreenPlane.getXMax()==cartesianScreenPlane.getXMax()){
                g.drawString(""+(int)cartesianScreenPlane.getXMax(),
                        cartesianScreenPlane.getWidth()-3,
                        10);
            }
            else{
                g.drawString(""+(int)cartesianScreenPlane.getXMax(),
                        Converter.xCrt2Scr((int)cartesianScreenPlane.getXMax(), cartesianScreenPlane),
                        10);
            }
        }

    }

    private void drawSetka(Graphics g){
        g.setColor(Color.BLACK);
        if (cartesianScreenPlane.getXMin()<0){
            for (int i =0; i>cartesianScreenPlane.getXMin();i-=1){
                g.drawLine(Converter.xCrt2Scr(i,cartesianScreenPlane),
                        0,
                        Converter.xCrt2Scr(i,cartesianScreenPlane),
                        cartesianScreenPlane.getHeight());
            }
            for (int i =0; i<=cartesianScreenPlane.getXMax();i+=1){
                g.drawLine(Converter.xCrt2Scr(i,cartesianScreenPlane),
                        0,
                        Converter.xCrt2Scr(i,cartesianScreenPlane),
                        cartesianScreenPlane.getHeight());
            }
        }
        else{
            for (int i =(int)cartesianScreenPlane.getXMin(); i<=cartesianScreenPlane.getXMax();i++){
                g.drawLine(Converter.xCrt2Scr(i,cartesianScreenPlane),
                        0,
                        Converter.xCrt2Scr(i,cartesianScreenPlane),
                        cartesianScreenPlane.getHeight());
            }
        }

        if(cartesianScreenPlane.getYMin()<0){
            for (int i =0;i>cartesianScreenPlane.getYMin();i=i-1){
                g.drawLine(0,
                        Converter.yCrt2Scr(i,cartesianScreenPlane),
                        cartesianScreenPlane.getWidth(),
                        Converter.yCrt2Scr(i,cartesianScreenPlane));
            }
            for (int i = 0; i<cartesianScreenPlane.getYMax();i++){
                g.drawLine(0,
                        Converter.yCrt2Scr(i,cartesianScreenPlane),
                        cartesianScreenPlane.getWidth(),
                        Converter.yCrt2Scr(i,cartesianScreenPlane));
            }
        }
        else{
            for(int i =(int)cartesianScreenPlane.getYMin();i< cartesianScreenPlane.getYMax();i++){
                g.drawLine(0,
                        Converter.yCrt2Scr(i,cartesianScreenPlane),
                        cartesianScreenPlane.getWidth(),
                        Converter.yCrt2Scr(i,cartesianScreenPlane));
            }
        }
    }
    private void drawFuncktions(Graphics g){
        g.setColor(Color.RED );
        for (int i=1;i<cartesianScreenPlane.getWidth()+1;i++){
            double x0 = Converter.xScr2Crt(i-1, cartesianScreenPlane);
            double x1 = Converter.xScr2Crt(i, cartesianScreenPlane);
            int y0 = Converter.yCrt2Scr(Funcktions(x0), cartesianScreenPlane);
            int y1 = Converter.yCrt2Scr(Funcktions(x1), cartesianScreenPlane);
            g.drawLine(i-1,y0,i,y1);
        }
    }
    private double Funcktions(double x){
        double y = Math.sin(x);
        return y;
    }
    private void drawParametrF(Graphics g){
        g.setColor(Color.BLUE );
        double t2 = cartesianScreenPlane.tmax;
        double t1 = cartesianScreenPlane.tmin;
        for(double i = 0; i<10*(t2-t1);i++){
            int x0 = Converter.xCrt2Scr(fx(t1 + i/10),cartesianScreenPlane);
            int y0 = Converter.yCrt2Scr(fy(t1 + i/10),cartesianScreenPlane);
            int x1 = Converter.xCrt2Scr(fx(t1 + (i-1)/10) , cartesianScreenPlane);
            int y1 = Converter.yCrt2Scr(fy(t1 + (i-1)/10), cartesianScreenPlane);
            g.drawLine(x0,y0,x1,y1);
        }
    }
    private double fx(double t){
        return Math.sin(t);
    }
    private double fy(double t){
        return t;
    }
}
