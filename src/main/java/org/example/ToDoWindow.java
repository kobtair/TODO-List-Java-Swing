package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Desktop;

public class ToDoWindow extends JFrame implements ActionListener {
    private ArrayList<String> tasks = new ArrayList<>();
    Image image= new ImageIcon("a.png").getImage();
    ToDoPanel toDoPanel=new ToDoPanel();
    MainPanel mainPanel= new MainPanel();
    Footer footer=new Footer();

    ToDoWindow(){
        this.setLayout(new GridLayout());
        this.setSize(400,700);
        this.setTitle("ToDo List");
        this.setIconImage(image);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        toDoPanel.newTask.addActionListener(this);
        toDoPanel.remove.addActionListener(this);
        footer.save.addActionListener(this);
        footer.load.addActionListener(this);
        this.add(toDoPanel);
        this.add(footer);
        this.add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            }
}
