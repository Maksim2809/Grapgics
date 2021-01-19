package com.company;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel2 extends JPanel {
    private JLabel ltMin;
    private JLabel ltMax;
    private JSpinner stMin;
    private JSpinner stMax;
    private SpinnerNumberModel nmtMin;
    private SpinnerNumberModel nmtMax;
    private static int PREF = GroupLayout.PREFERRED_SIZE;
    private static int DEF  = GroupLayout.DEFAULT_SIZE;
    private Spinner spiner;


    public ControlPanel2(){
        ltMin = new JLabel();
        ltMax = new JLabel();
        ltMin.setText("t_min = ");
        ltMax.setText("t_max = ");
        nmtMin = new SpinnerNumberModel(-5.0, -100.0, 4.9, 0.1);
        nmtMax = new SpinnerNumberModel(5.0, -4.9, 100.0, 0.1);
        stMin = new JSpinner(nmtMin);
        stMax = new JSpinner(nmtMax);

        stMin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                nmtMax.setMinimum((Double)stMin.getValue()+0.1);
                spiner.spinerValue2((double)stMin.getValue(),(double)stMax.getValue());
            }
        });

        stMax.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                nmtMin.setMaximum((Double)stMax.getValue()-0.1);
                spiner.spinerValue2((double)stMin.getValue(),(double)stMax.getValue());
            }
        });

        GroupLayout gl = new GroupLayout(this);
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGap(8)
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(ltMin, PREF, PREF, PREF)
                                        .addComponent(stMin, PREF, PREF, PREF)
                                        .addComponent(ltMax, PREF, PREF, PREF)
                                        .addComponent(stMax, PREF, PREF, PREF)
                        )
                        .addGap(8)
        );

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(4)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(ltMin, PREF, PREF, PREF)
                )
                .addGap(2)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(stMin, DEF, DEF, DEF)
                )
                .addGap(8, 8, Integer.MAX_VALUE)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(ltMax, PREF, PREF, PREF)
                )
                .addGap(2)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(stMax, DEF, DEF, DEF)
                )
                .addGap(4)
        );
        setLayout(gl);
    }

    public void addIsc(Spinner e){
        spiner = e;
    }
}
