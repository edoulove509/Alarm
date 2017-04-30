/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alarm;

import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    AlarmPane(){
        panel_alarm = new JPanel();
        panel_alarm.setBackground(Color.red);
        getContentPane().add(panel_alarm,BorderLayout.NORTH);
        
        add_alarm = new JButton("Add Alarm");
        panel_alarm.add(add_alarm);
        
        panel_button = new JPanel();
        //panel_button.add(add_alarm);
        add_alarm.addActionListener(new ActionListener(
        
        ) {

            @Override
            public void actionPerformed(ActionEvent e) {
                AlarmNew new_alarm = new AlarmNew();
                try {
                    new_alarm.createComponent();
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(AlarmPane.class.getName()).log(Level.SEVERE, null, ex);
                }
                new_alarm.display();
                JDialog d = new JDialog(new_alarm);
                d.setModal(true);
            }
        });
        
    }
    
}
