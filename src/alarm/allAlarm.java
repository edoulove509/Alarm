/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alarm;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author edou5
 */
public class allAlarm extends JFrame {
    
    private JPanel panel;
    private JTextArea text;
    public allAlarm(){
        
        panel = new JPanel();
        text = new JTextArea();
        panel.add(text);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        getContentPane().add(panel,BorderLayout.CENTER);
        
    }
    
}
