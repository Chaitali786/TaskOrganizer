package com.kth.se.taskorganizer.controller;

import com.kth.se.taskorganizer.model.ProjectTaskHandler;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
/**
 * 
 * @author Chaitali Deore
 *         SDA 3
 */
public class TaskController {
	
	public void manageProject() throws ParseException, IOException, ClassNotFoundException
	{
		//System.out.println("Manage Project !!!!");
		ProjectTaskHandler proTaskHandler = new ProjectTaskHandler();
		proTaskHandler.displayProjectMenu();
                
		proTaskHandler.chooseProjectTask();
	}
    
    
}
