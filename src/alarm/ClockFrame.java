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
import javax.swing.*;
/**
 *
 * @author edou5
 */
 class ClockFrame extends JFrame {
    private JTextField jtextTime;
    private JLabel labelTime;
    String time;
    public ClockFrame(){
        
        
        labelTime = new JLabel(time);
        labelTime.setFont(new Font("",Font.PLAIN,30));
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(labelTime);
        this.setContentPane(content);
        this.setTitle("Oloj Alam");
        this.pack();
        this.setLocationRelativeTo(this);
        Timer t = new Timer(1000, new ClockListener());
        t.start();
        
    }
    
    class ClockListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            SimpleDateFormat date_format = new SimpleDateFormat("hh : mm : ss");
            labelTime.setText(date_format.format(Calendar.getInstance().getTime()));
            
        }
    }
    
}
