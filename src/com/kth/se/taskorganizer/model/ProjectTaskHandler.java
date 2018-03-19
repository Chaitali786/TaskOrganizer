/**
 *
 * @author CHAITALI DEORE
 */
package com.kth.se.taskorganizer.model;
import java.io.File;
import java.util.Scanner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.Set;
import java.util.TreeMap;

public class ProjectTaskHandler {
	/**
     * @param args the command line arguments
     */
    public int  choice;
    public String taskName;
    public String taskStatus;
    public int taskIndex=0;
    //public String date;
    HashMap<Date,TaskDTO > projectMap = new HashMap<Date, TaskDTO>();
    SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
    TaskDTO taskDTO;
    
	
	/***************************
	 * DISPLAY MENU FOR PROJECT
	 ***************************/
	public void displayProjectMenu()
	{
		
		System.out.printf("%20s","1)ENTER TASK ");
		System.out.println();
		System.out.printf("%20s","2)SHOW  TASK ");
		System.out.println();
		System.out.printf("%20s","3)EDIT  TASK ");
		System.out.println();
		System.out.printf("%14s","4)EXIT ");
		System.out.println();
		System.out.printf("--------------------------------------------");
		System.out.println();
	}
	
	/****************************
	 * HANDLE  MENU FOR PROJECT
	 * ***************************/
	public void chooseProjectTask()
	{   
		char a;
	    do
        {
		       Scanner scChoice = new Scanner(System.in);
		       System.out.println("PLEASE ENTER YOUR CHOICE:  ");
		       choice = scChoice.nextInt();
		       System.out.println();
		       switch(choice) {
                    case 1 :
                    //System.out.println("Add Project"); 
                    addProject();
                    break;
                    case 2 :
                    sortProjectList();
                    
                    break;
                    case 3 :
                    sortProjectList();
                    break;
                    default :
                    System.out.println("Invalid Choice");
                }//End of Switch
		
	    System.out.println("Do You Want To Continue(Y/N)");
        a = scChoice.next().charAt(0);
        } while(a =='Y'|| a =='y');
	
	 }//End of chooseprojectMap
	
	/**
	 * 
	 */
	public void addProject(){
	    char a;
		do
        {
               
               Scanner keyboard= new Scanner( System.in ); 
               
               System.out.println("ENTER TASK:");
               taskName= keyboard.nextLine();
               
               System.out.println("ENTER STATUS:");
               taskStatus= keyboard.nextLine();
               taskIndex=taskIndex + 1;
               taskDTO = new TaskDTO(taskName,taskStatus,taskIndex);
               
               try {
                         System.out.println("ENTER TASK DUEDATE(dd/mm/yyyy):");
                         String dueDate = keyboard.nextLine();
                         Date dueDateObj = myFormat.parse(dueDate); 
                         projectMap.put(dueDateObj,taskDTO);
                   } catch (ParseException e) {
                          e.printStackTrace();
                   }
               System.out.println("DO YOU WANT TO ADD MORE  TASK (Y/N)");
               a = keyboard.next().charAt(0);
        }while(a =='Y'|| a =='y');
		
	}//End of add project
	
	/**
	 * 
	 */
	
	public void sortProjectList(){
		
		System.out.printf("INDEX ");
		System.out.printf("%15s","DUE DATE ");
		System.out.printf("%15s","TASK");
		System.out.printf("%35s","STATUS");
	    System.out.println();
        System.out.println("---"+"      "+"------------"+"        "+"----------------"+"               "+"-----------");
        
		
        Map<Date,TaskDTO> treeMap = new TreeMap<Date,TaskDTO>(projectMap);
        Set s = treeMap.entrySet();
        Iterator it = s.iterator();
        while ( it.hasNext() ) {
              Map.Entry entry = (Map.Entry) it.next();
              taskDTO = (TaskDTO)entry.getValue();
              System.out.print(taskDTO.getTaskIndex());
              String newUpdatedDate = myFormat.format(entry.getKey());
              System.out.printf("%20s",newUpdatedDate);
              System.out.printf("%20s",taskDTO.getTask());
              System.out.printf("%30s",taskDTO.getStatus());
              System.out.println();
        }//while
	}//end of method
	
	
}//End of Class
