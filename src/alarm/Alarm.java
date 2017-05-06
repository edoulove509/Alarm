/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alarm;

import java.io.*;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javax.sound.sampled.AudioFileFormat.Type;
import java.applet.*;
import java.util.Scanner;
import javafx.embed.swing.JFXPanel;

import sun.audio.AudioData;
import sun.audio.ContinuousAudioDataStream;
import java.util.*;

/**
 *
 * @author edou5
 */ 
public class Alarm {
    private static String filename;
    private JFrame frame;
    private JTabbedPane tab_pane;
    private String f = "audio/nos.mp3";
    private static final String file = "data.txt";
    
    Alarm(){
        frame = new JFrame();
        frame.setSize(new Dimension(400,350));
        frame.setLocationRelativeTo(frame);
        tab_pane = new JTabbedPane();
        
        ClockFrame clock = new ClockFrame(); //create a new Object ClockFrame
        AlarmPane alarm = new AlarmPane();
        //alarm.setAlarm(11, 14, f);
        
        //clock.setSize(500, 350);
        //clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //clock.setVisible(true);
        
        
        tab_pane.addTab("Date & Time", clock.getContentPane());
        tab_pane.addTab("Alarm",alarm.getContentPane());
        tab_pane.setVisible(true);
        
        
        frame.add(tab_pane, BorderLayout.CENTER);
        frame.setVisible(true);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LineUnavailableException {
        // TODO code application logic here
        //JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        //Calendar cal = Calendar.getInstance();
        //System.out.println(cal.get(Calendar.HOUR_OF_DAY)+ " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND));
        final JFXPanel fxPanel = new JFXPanel();
        Alarm alarm = new Alarm();
        //alarm.getData();
        }
    
    /* public void getData(){
        try{
            File f = new File(file);
            Scanner in = new Scanner(f);
            
            while(in.hasNextLine()) // Checks if there is another line
            {
                ArrayList<String> l = new ArrayList<String>();
                Scanner check = new Scanner(in.nextLine());
                
                while(check.hasNext()) // Checks if there is another word in a same line
                {
                    l.add(check.next());
                   //System.out.println(check.next());
                   //System.out.println(l);
                   
                 }
                String h = l.get(0);
                String m = l.get(1);
                String path = l.get(2);
                
                System.out.println(h + " " + m + " "+ path);
                System.out.println(l);
                
                
                
              }
            
            
        }
        catch(Exception e){e.printStackTrace();}
    }*/
    
    
}
