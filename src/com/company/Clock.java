package com.company;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends Thread{
    private JLabel lbl;

    public Clock(JLabel lbl) {
        this.lbl = lbl;
    }

    @Override
    public void run(){
      /*  SimpleDateFormat sdf = new SimpleDateFormat(" hh:mm:ss aa");*/
        while (true){
            Date now = new Date();

            lbl.setText(String.valueOf(now));
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }
    }

}

