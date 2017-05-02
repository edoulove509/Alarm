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

/**
 *
 * @author edou5
 */
public class AlarmPane extends JFrame {
    
    private JPanel panel_alarm;
    private JPanel panel_button;
    private JButton add_alarm;
    private final JTextField hour;
    private final JTextField minutes;
    private final JTextArea text;
    private final JPanel panel;
    private static final String file = "data.txt";
    
    
    AlarmPane(){
        panel_alarm = new JPanel();
        panel_alarm.setBackground(Color.red);
        getContentPane().add(panel_alarm,BorderLayout.NORTH);
        
        add_alarm = new JButton("Add Alarm");
        panel_alarm.add(add_alarm);
        
        
        hour = new JTextField(4);
        minutes = new JTextField(4);
            panel_alarm.add(hour);
            panel_alarm.add(minutes);
        JComboBox combo = new JComboBox();
            panel_alarm.add(combo);
        panel = new JPanel();
        text = new JTextArea();
        text.setEditable(false);
        panel.add(text);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        getContentPane().add(panel,BorderLayout.CENTER);
        //Create field and labels for form panel and add to form panel
        File folder = new File("audio");
            if(folder.exists()){
                System.out.println("Folder exist");
            }
            else{
                System.out.println("not Exist");
            }
            File[] listOfFiles = folder.listFiles();
            if(listOfFiles != null){
                int i =0;
                for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    combo.insertItemAt(listOfFile.getName(),i++);
                    
                    
                } else if (listOfFile.isDirectory()) {
                    System.out.println("Directory " + listOfFile.getName());
                }
            }
            combo.setSelectedIndex(1);
            }
            
            
            
            add_alarm.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        BufferedWriter bw = null;
                        FileWriter fw = null;
                        fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);
                        bw.newLine();
			bw.write(hour.getText()+ " "+minutes.getText()+" "+ combo.getSelectedItem());
                        bw.flush();
                        bw.close();
                        //text.setText(hour.getText()+minutes.getText());
                        }
                        
                        catch(IOException ex){
                            ex.printStackTrace();
                        }
            }

            

           
            });
    }
    public void setAlarm( final int a, final int b,String fichier){
        
        Thread thread = new Thread(){
          public void run(){
              int wl = 0;
              while(wl==0){
                  Calendar c = new GregorianCalendar();
                  int hour = c.get(Calendar.HOUR);
                  int minute = c.get(Calendar.MINUTE);
                  if(a==hour && b==minute){
                      
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
    
}
