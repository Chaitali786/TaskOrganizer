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
	public void displayMenu()
	{
		System.out.println(" ############################################################### ");
		System.out.println(" ############## WELCOME TO TASK ORGANIZER ###################### ");
		System.out.println(" ############################################################### ");
		System.out.println(" 1)ORGANIZE PROJECT  ");
		System.out.println(" 2)ORGANIZE TASK ");
		System.out.println(" 3)EXIT");
		System.out.println("--------------------------------------------");
	}//End of displayMenu
	public void makeChoice()
	{   
		char a;
	do
    {
		Scanner scChoice = new Scanner(System.in);
		System.out.println("CHOOSE ONE OPTION ::: ");
		choice = scChoice.nextInt();
		System.out.println();
		switch(choice) {
        case 1 :
           //System.out.println("ENTER PROJECT DETAILS !"); 
           taskController.manageProject();
           break;
        case 2 :
        	 System.out.println("We will add new Task!!!!");
        	 taskController.manageTask();
             break;
        case 3 :
           System.out.println("Good Bye");
           break;
        default :
           System.out.println("Invalid grade");
         }//End of Switch
		
	  System.out.println("Do You Want To Continue(Y/N)");
      a = scChoice.next().charAt(0);
     } while(a =='Y'|| a =='y');
	
	}//End of makeChoices 
	
	
}
