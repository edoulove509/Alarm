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
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;
import com.darkprograms.speech.microphone.MicrophoneAnalyzer;
import javax.sound.sampled.AudioFileFormat.Type;
import java.applet.*;
import java.util.Scanner;
import javafx.embed.swing.JFXPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.*;
import sun.audio.AudioData;
import sun.audio.ContinuousAudioDataStream;

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
        frame.setSize(new Dimension(400,300));
        frame.setLocationRelativeTo(frame);
        tab_pane = new JTabbedPane();
        
        ClockFrame clock = new ClockFrame();
        AlarmPane alarm = new AlarmPane();
        alarm.setAlarm(8, 20, f);
        
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
        alarm.getData();
        }
    
    public void getData(){
        try{
            File f = new File(file);
            Scanner sc = new Scanner(f);
            
            while(sc.hasNextLine()){
                System.out.println(sc.next());
            }
            System.out.println(sc.next());
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    
}
