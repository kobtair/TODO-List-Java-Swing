package org.example;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    Button save;
    Button load;
    Footer() {
        this.setLocation(0, 625);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setSize(400, 50);
        save= new Button("save");
        load= new Button("load");
        save.setFocusable(false);
        load.setFocusable(false);
        this.add(save);
        this.add(load);

    }
}
