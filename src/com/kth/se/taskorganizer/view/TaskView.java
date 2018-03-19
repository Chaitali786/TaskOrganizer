package com.kth.se.taskorganizer.view;
import java.util.Scanner;

import com.kth.se.taskorganizer.controller.TaskController;
/**
 * <class Detail> 
 * @author chaitali
 *
 */
public class TaskView {
	public int  choice;
	public TaskController taskController = new TaskController();
	
	/**
	 * Method info
	 */
	public void screenView()
	{
		System.out.printf("%50s","#############################################");
		System.out.println();
		System.out.printf("%50s","###########   W E L C O M E     #############");
		System.out.println();
		System.out.printf("%50s","###########        TO           #############");
		System.out.println();
		System.out.printf("%50s","########### T A S K  ORGANIZER  #############");
		System.out.println();
		System.out.printf("%50s","#############################################");
		System.out.println();
		System.out.println();
		taskController.manageProject();
	}
}
