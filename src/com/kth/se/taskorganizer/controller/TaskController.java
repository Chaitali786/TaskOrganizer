package com.kth.se.taskorganizer.controller;

import com.kth.se.taskorganizer.model.ProjectTaskHandler;

public class TaskController {
	
	public void manageProject()
	{
		//System.out.println("Manage Project !!!!");
		ProjectTaskHandler proTaskHandler = new ProjectTaskHandler();
		proTaskHandler.displayProjectMenu();
		proTaskHandler.chooseProjectTask();
	}
    public void manageTask()
    {
    	System.out.println("Manage Task");
    }
    
}
