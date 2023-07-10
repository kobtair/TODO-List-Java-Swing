package org.example;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    JLabel display=new JLabel();
    MainPanel(){
    this.setLocation(0, 51);
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);
        this.setSize(400, 600);
        display.setForeground(Color.white);
        display.setText("");
        this.add(display);
    }
}
