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
import java.io.File;
import java.text.SimpleDateFormat;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

/**
 *
 * @author edou5
 */
public class AlarmNew extends JFrame {
    
    private JLabel label;
    private JPanel panel;
    
    public AlarmNew(){
        
    }
    public void createComponent() throws LineUnavailableException{
      // JFrame frame =new JFrame();
        panel = new JPanel();
        
        
        
        
        this.setLayout(null);
        setContentPane(panel);
        
        
        
        panel.add(drawForm());
        
       // frame.add(panel,BorderLayout.NORTH);
       // frame.setVisible(true);
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
        //String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
                combo.setSelectedIndex(1);
         
        
        JLabel label1 = new JLabel("subject");
            form.add(label1);
        JTextField textfield1 = new JTextField(5);
            form.add(textfield1);  
         //form.add(combo);
        JLabel label2 = new JLabel("Time");
            form.add(label2);
        JTextField textfield2 = new JTextField(5);
            form.add(textfield2);
        
        JLabel sound = new JLabel("Sound");
            form.add(sound);
            form.add(combo);
        JButton calc = new JButton("Save");
            form.add(calc);
            calc.addActionListener(new ActionListener(){
                public void actionPerformed(Action e){
                     
                }

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
