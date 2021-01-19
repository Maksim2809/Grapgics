package com.company;

import com.company.coordinatesystem.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MainWindow extends JFrame implements Spinner{
    ControlPanel controlPanel;
    GraphicsPanel mainPanel;
    CartesianScreenPlane csPlane ;
    CartesianPainter p;

    ControlPanel2 controlPanel2;
    GraphicsPanel mainPanel2;
    CartesianScreenPlane csPlane2 ;
    CartesianPainter p2 ;

    static final Dimension MIN_SIZE = new Dimension(450, 350);
    static final Dimension MIN_FRAME_SIZE = new Dimension(600, 500);
    public MainWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1200,500));
        setTitle("Экзамен");

        mainPanel = new GraphicsPanel();
        controlPanel = new ControlPanel();

        mainPanel2 = new GraphicsPanel();
        controlPanel2 = new ControlPanel2();

        mainPanel.setBackground(Color.WHITE);
        controlPanel.setBorder(new EtchedBorder());

        mainPanel2.setBackground(Color.WHITE);
        controlPanel2.setBorder(new EtchedBorder());

        GroupLayout gl = new GroupLayout(getContentPane());
        setLayout(gl);
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(4)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(mainPanel, (int)(MIN_SIZE.height*0.8), MIN_SIZE.height, GroupLayout.DEFAULT_SIZE)
                                .addComponent(mainPanel2, (int)(MIN_SIZE.height*0.8), MIN_SIZE.height, GroupLayout.DEFAULT_SIZE)
                )
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(controlPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)

                )
                //.addComponent(mainPanel, (int)(MIN_SIZE.height*0.8), MIN_SIZE.height, GroupLayout.DEFAULT_SIZE)
                //.addGap(4)
                //.addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(4)
        );
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(4)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(mainPanel, MIN_SIZE.width, MIN_SIZE.width, GroupLayout.DEFAULT_SIZE)
                                .addComponent(controlPanel, MIN_SIZE.width, MIN_SIZE.width, GroupLayout.DEFAULT_SIZE)
                )
                .addGap(4)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(mainPanel2, MIN_SIZE.width, MIN_SIZE.width, GroupLayout.DEFAULT_SIZE)
                                .addComponent(controlPanel2, MIN_SIZE.width, MIN_SIZE.width, GroupLayout.DEFAULT_SIZE)
                )
                .addGap(4)
        );
        pack();

        csPlane = new CartesianScreenPlane(
                mainPanel.getWidth(),
                mainPanel.getHeight(),
                -5,5,
                -5,5
        );
        csPlane2 = new CartesianScreenPlane(
                mainPanel2.getWidth(),
                mainPanel2.getHeight(),
                -5,5,
                -5,5
        );
        csPlane2.tmin = -5;
        csPlane2.tmax = 5;
        mainPanel.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                csPlane.setSize(mainPanel.getWidth(),mainPanel.getHeight());
                csPlane2.setSize(mainPanel2.getWidth(),mainPanel2.getHeight());
                mainPanel.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
        p = new CartesianPainter(csPlane, true );
        p2 = new CartesianPainter(csPlane2, false);
        controlPanel2.addIsc(this);
        controlPanel.addIsc(this);
        mainPanel.addPainter(p);
        mainPanel2.addPainter(p2);
    }

    @Override
    public void spinerValue1(double xmin, double xmax, double ymin, double ymax) {
        csPlane.valueSpiner(xmin,xmax,ymin,ymax);
        mainPanel.repaint();
    }

    @Override
    public void spinerValue2(double tmin, double tmax) {
        double xmin = 0;
        double xmax = 0;
        double ymin = 0;
        double ymax = 0;
        for(double i = 0; i<10*(tmax-tmin);i++){
            double x = fx(tmin + i/10);
            double y = fy(tmin + i/10);
            if (x<xmin) xmin = x;
            if (x>xmax) xmax = x;
            if (y<ymin) ymin = y;
            if (y>ymax) ymax = y;
        }
        csPlane2.valueSpiner(xmin,xmax,ymin,ymax);
        csPlane2.valueSpiner2(tmin,tmax);
        mainPanel2.repaint();
    }

    private double fx(double t){
        return Math.sin(t);
    }
    private double fy(double t){
        return t;
    }
}
