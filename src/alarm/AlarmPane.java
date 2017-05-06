/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alarm;

import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author edou5
 */
public class AlarmPane extends JFrame {
    
    private JPanel panel_alarm;
    private JPanel panel_button;
    private JButton add_alarm;
    private JButton button_path;
    private  JTextField hour;
    private  JTextField minutes;
    private JLabel info_label;
    private JLabel label_path;
    private  JTextArea text;
    private  JPanel panel;
    private static final String file = "data.txt";
    private JFileChooser chooser;
    
    
    AlarmPane(){
        panel_alarm = new JPanel(); // make a new alarm panel for adding components
        panel_alarm.setBackground(Color.WHITE);
        panel_alarm.setLayout(null);
        getContentPane().add(panel_alarm);
        
         //Create field and labels for form panel and add to form panel
        add_alarm = new JButton("Add Alarm");
        add_alarm.setBounds(130,220,130,30);
        
        info_label = new JLabel("Use the 24 hour format to set Alarm");
        info_label.setBounds(70,10,220,30);
        
        panel_alarm.add(info_label);
        
        label_path = new JLabel();
        label_path.setBounds(10,175,340,30);
        panel_alarm.add(label_path);
        button_path = new JButton("Browse...");
        button_path.setBounds(130,130,90,30);
        
        JLabel label=new JLabel("Hours :");
        label.setBounds(40,55,70,30);
        label.setFont(new java.awt.Font("Times New Roman",'1',18));
        panel_alarm.add(label);
        
        JLabel min=new JLabel("Minutes :");
        min.setBounds(40,95,70,30);
        min.setFont(new java.awt.Font("Times New Roman",'1',18));
        
         panel_alarm.add(min);
         panel_alarm.add(button_path);
        
        hour = new JTextField(4);
        hour.setBounds(130,60,130,20);
        
        minutes = new JTextField(4);
           minutes.setBounds(130,100,130,20);
            panel_alarm.add(hour);
            panel_alarm.add(minutes);
            panel_alarm.add(label_path);
        
            panel_alarm.add(add_alarm);
             add_alarm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        JOptionPane.showMessageDialog(null, "Alarm is added successfullly", "Add Alarm", JOptionPane.INFORMATION_MESSAGE);
                        
                        
                        BufferedWriter bw = null;
                        FileWriter fw = null;
                        fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);
			bw.write(hour.getText()+ " "+minutes.getText());
                        bw.newLine();
                        bw.flush();
                        bw.close();
                        String h = hour.getText();
                        String m = minutes.getText();
                        
                        System.out.println();
                        
                        
                       Object audio = label_path.getText();
                        
                        /*convert to int h and m*/
                        int heure = Integer.parseInt(h);
                        int minute = Integer.parseInt(m);
                        int amPM = Calendar.getInstance().get(Calendar.AM_PM);
                        
                      String audioMp3 = audio.toString();
                       setAlarm(heure,minute,amPM,audioMp3);//call the setAlarm method 
                       hour.setText("");
                       minutes.setText("");
                       label_path.setText("");
                        
                        }
                        
                        catch(IOException ex){
                            ex.printStackTrace();
                        }
            }
            });
        
        panel_alarm.add(add_alarm);
        button_path.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("*.MP3"));
                chooser.setDialogTitle("choose an Mp3 sound");
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 files", "mp3");
                chooser.setFileFilter(filter);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                  System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                  
                  label_path.setText(chooser.getSelectedFile().toString());
                } else {
                  System.out.println("No Selection ");
                }
            }
        });
    }
    //create method setAlarm for setting alarm
    // which take as args 2 int and one string
    public void setAlarm( final int a, final int b,final int c,String fichier){
        
        Thread thread = new Thread(){
          public void run(){
              int wl = 0;
              while(wl==0){
                  Calendar cal = new GregorianCalendar();
                  int hour = cal.get(Calendar.HOUR_OF_DAY);
                  int minute = cal.get(Calendar.MINUTE);
                  int amPM = cal.get(Calendar.AM_PM);
                  
                  if(a==hour && b==minute){
                        if(c==0){
                            amPM = cal.get(Calendar.AM);
                        }
                        if(c==1){
                            amPM = cal.get(Calendar.PM);
                        }
                        Media media = new Media(new File(fichier).toURI().toString());
                        MediaPlayer mediaplayer = new MediaPlayer(media);
                        mediaplayer.play();
                        JOptionPane.showMessageDialog(null, "Time to wake up", "Alarm Clock", JOptionPane.INFORMATION_MESSAGE);
                        break;
                        
                  }
              }
          }  
        };
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }
    
    public void methodAmPm(String A,String P){
        
    }
    
}
