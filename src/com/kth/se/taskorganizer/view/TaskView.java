package com.kth.se.taskorganizer.view;
import java.util.Scanner;

import com.kth.se.taskorganizer.controller.TaskController;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This class is View Class 
 * @author Chaitali DEORE
 *         SDA 3
 * 
 *
 */
public class TaskView {
	public int  choice;
	public TaskController taskController = new TaskController();
	
	/**
         * Method to display Welcome Message On Screen
         * @throws ParseException  Date Format Exception
         * @throws IOException  Exception in file handling
         */
	public void screenView() throws ParseException, IOException
	{
		System.out.printf("%80s","#############################################");
		System.out.println();
		System.out.printf("%80s","###########   W E L C O M E     #############");
		System.out.println();
		System.out.printf("%80s","###########        TO           #############");
		System.out.println();
		System.out.printf("%80s","########### T A S K  ORGANIZER  #############");
		System.out.println();
		System.out.printf("%80s","#############################################");
		System.out.println();
		System.out.println();
            try {
                taskController.manageProject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaskView.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
        
}
