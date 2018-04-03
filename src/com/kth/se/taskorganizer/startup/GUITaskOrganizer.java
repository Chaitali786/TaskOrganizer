
package com.kth.se.taskorganizer.startup;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author CHAITALI
 */

public class GUITaskOrganizer {

    /**
     * @param args the command line arguments
     */
    private static final String Menu_Text_Heading = "Menu For Task Organizer ";
    private JLabel menuStateLabelADD = new JLabel("<html>1)ADD TASK<br>2)SHOW TASK<br>3)SORT TASK<br>4)EDIT TASK<br>5)REMOVE TASK<br>6)EXIT</html>"
                                               , SwingConstants.CENTER);
    
    /**
     * Method to create GUI of TaskOrganizer Menu.
     */
    public void  displayMenuframe()
    {
       JFrame frame = new JFrame("Welcome To Task Organizer");
       frame.setLayout(new FlowLayout());
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 25);
        menuStateLabelADD.setFont(labelFont);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.add(menuStateLabelADD);
        frame.setBounds(200, 0, 350, 50);
        frame.toFront();
        
        frame.setVisible(true);
        // optional, but nice to have.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}

