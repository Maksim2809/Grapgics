package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GraphicsPanel extends JPanel {
    Painter p = null;

    boolean mouse = true;

    public void addPainter(Painter p){
        this.p = p;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(p!=null) p.paint(g);
    }
}