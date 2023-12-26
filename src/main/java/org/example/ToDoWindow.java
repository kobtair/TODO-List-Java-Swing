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
        if(e.getSource()==toDoPanel.newTask){
         String newItem = JOptionPane.showInputDialog("Enter the Task");
         if(newItem!=null && newItem !="") {
             tasks.add(newItem);
         }
         StringBuilder taskFile= new StringBuilder("<html> ");
            for(int i=0;i<tasks.size();i++){
                taskFile.append(i + 1).append(". ").append(tasks.get(i)).append("<br>");
            }
            taskFile.append("<html>");
            mainPanel.display.setText(taskFile.toString());

        }
        if(e.getSource()==toDoPanel.remove){
           try {
               String remFile = "<html> ";
               for (int i = 0; i < tasks.size(); i++) {
                   remFile = remFile + (i + 1) + ". " + tasks.get(i) + "<br>";
               }
               remFile = remFile + "<br>Specify the task number to remove the task: <html>";
               int remItem = Integer.parseInt(JOptionPane.showInputDialog(remFile));
               tasks.remove(remItem - 1);
           }
           catch(Exception err){
                JOptionPane.showMessageDialog(null,"Please specify valid task number");
            }
            String taskFile="<html> ";
            for(int i=0;i<tasks.size();i++){
                taskFile= taskFile + (i+1)+". "+tasks.get(i)+"<br>";
            }
            taskFile= taskFile+"<html>";
            mainPanel.display.setText(taskFile);
        }
        if(e.getSource()==footer.save){
            JLabel label = new JLabel();
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(null);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                FileWriter writer = null;
                try {
                    writer = new FileWriter(file.getAbsolutePath()+".txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String taskFile="";
                for(int i=0;i<tasks.size();i++){
                    taskFile= taskFile + (i+1)+". "+tasks.get(i) +"\n";
                }
                try {
                    writer.write(taskFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,("File Saved as: " + file.getName()));

            }else{
                label.setText("Save command canceled");
            }
        }
        if(e.getSource()==footer.load){
            JLabel label = new JLabel();
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(null);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                FileReader reader = null;
                try {
                    reader = new FileReader(file.getAbsolutePath());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                int data= 0;
                try {
                    data = reader.read();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String read="";
                while (data!=-1){
                    read= read +(char) data;
                    try {
                        data= reader.read();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                try {
                    reader.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Desktop desktop = Desktop.getDesktop();
                if(file.exists())         //checks file exists or not
                {
                    try {
                        desktop.open(file);              //opens the specified file
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        }else{
                label.setText("Load command canceled");
            }
        }
    }
}
