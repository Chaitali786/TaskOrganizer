package com.kth.se.taskorganizer.startup;
import com.kth.se.taskorganizer.controller.TaskController;
import com.kth.se.taskorganizer.view.TaskView;
/**
 * 
 * @author Chaitali
 *
 */
public class TaskOrganizer {
	public static void main(String[] args)
	{
		TaskController taskController = new TaskController();
		taskController.manageProject();
		//TaskView taskview =new TaskView();
        //System.out.println("This is Launcher class!!!!! It will make call to TaskView Class");
        
        //taskview.displayMenu();
        //taskview.makeChoice();
	}

}
