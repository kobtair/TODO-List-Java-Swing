package org.example;

import javax.swing.*;
import java.awt.*;


public class ToDoPanel extends JPanel{
    Button newTask;
    Button remove;
    ToDoPanel() {
        this.setLocation(0, 0);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setSize(400, 35);
        newTask = new Button("add");
        newTask.setFocusable(false);
        remove = new Button("remove");
        remove.setFocusable(false);
        this.add((newTask));
        this.add(remove);

    }

}
