/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alarm;
import com.darkprograms.speech.microphone.MicrophoneAnalyzer;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

/**
 *
 * @author edou5l
 */
public class AlarmNew extends JFrame {
    private static JTextField textfield2;
    
    private JLabel label;
    private JPanel panel;
    
    
    public AlarmNew(){
        
    }
    public void createComponent() throws LineUnavailableException{
        panel = new JPanel();
        this.setLayout(null);
        setContentPane(panel);
        panel.add(drawForm());
    }
    public static JPanel drawForm() throws LineUnavailableException{
        //Set panel with layout and border
        JPanel form = new JPanel();
        form.setBorder(BorderFactory.createTitledBorder("Form"));
        form.setLayout(new BoxLayout(form, BoxLayout.PAGE_AXIS));
        JComboBox combo = new JComboBox();
        //Create field and labels for form panel and add to form panel
        File folder = new File("src/audio");
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
        JLabel label2 = new JLabel("Time");
            form.add(label2);
         textfield2 = new JTextField(5);
            form.add(textfield2);
        
        JLabel sound = new JLabel("Sound");
            form.add(sound);
            form.add(combo);
        JButton calc = new JButton("Save");
            form.add(calc);
            calc.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String DATE_FORMAT_NOW = "HH:mm";
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
                    String stringDate = sdf.format(date );
                    
                    if(stringDate==textfield2.getText()){
                        System.out.println("ok ok");
                    }
                    
                }
                    
            });
           
        //Set return
        return form;
        
       } // Ends method drawForm
        return null;
    
    }
    public void display(){
        this.setSize(500,300);
        this.setLocationRelativeTo(this);
        this.setVisible(true);
    }
    
    public void playAudio(String file){
        Media media = new Media(new File(file).toURI().toString());
        MediaPlayer mediaplayer = new MediaPlayer(media);
        mediaplayer.play();
    }
    
    public void setTime(String s){
        
    }
}
