/**
 *
 * @author CHAITALI DEORE
 */
package com.kth.se.taskorganizer.model;
import java.io.File;
import java.util.Scanner;

import java.text.DateFormat;
import java.text.ParseException;
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
    public String projectName;
    //public String date;
    HashMap<Date, String > projectMap = new HashMap<Date, String>();
    
	
	/***************************
	 * DISPLAY MENU FOR PROJECT
	 ***************************/
	public void displayProjectMenu()
	{
		System.out.println(" ************************************** ");
		System.out.println(" ***** WELCOME TO TASK ORGANIZER ****** ");
		System.out.println(" ************************************** ");
		System.out.println("1)ENTER  TASK :  ");
		System.out.println("2)SHOW TASK LIST");
		System.out.println("3)SORT TASK LIST (DATE WISE) ");
		System.out.println("4)EXIT ");
		System.out.println("--------------------------------------------");
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
		       System.out.println("Choose one option:  ");
		       choice = scChoice.nextInt();
		       System.out.println();
		       switch(choice) {
                    case 1 :
                    System.out.println("Add Project"); 
                    addProject();
                    break;
                    case 2 :
                    showProjectDetails();
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
	
	/***************************************
	 * ADD PROJECT DETAILS 
	 * USER INPUT: PROJECT NAME AND DUE DATE  
	 ***************************************/
	public void addProject(){
	    char a;
		do
        {
               SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
               Scanner keyboard= new Scanner( System.in ); 
               System.out.println("Enter Project:");
               projectName = keyboard.nextLine();
               try {
                         System.out.println("Enter Project DueDate (dd mm yyyy):");
                         String dueDate = keyboard.nextLine();
                         Date dueDateObj = myFormat.parse(dueDate);
                         projectMap.put(dueDateObj,projectName);
                   } catch (ParseException e) {
                          e.printStackTrace();
                   }
                
                System.out.println("Do You Want Add More Project (Y/N)");
                a = keyboard.next().charAt(0);
        }while(a =='Y'|| a =='y');
		
	}//End of add project
	
	/***************************************
	 * SHOW PROJECT DETAILS 
	 * OUTPUT: PROJECT NAME AND DUE DATE  
	 ***************************************/
	public void showProjectDetails(){
		System.out.println("############ PROJECT LIST ############## ");
        Set set = projectMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
             Map.Entry mentry = (Map.Entry)iterator.next();
             System.out.print( mentry.getKey()+":");
             System.out.println(mentry.getValue());
        }//End of While
		
		
	}//end of method
	
	/*****************************************
	 * SORT PROJECT LIST ACCORDING TO DUEDATE
	 * OUTPUT: PROJECT NAME AND DUE DATE  
	 *****************************************/
	public void sortProjectList(){
		System.out.println("############ SORT PROJECT LIST ############## ");
        Map<Date, String> treeMap = new TreeMap<Date, String>(projectMap);
        Set s = treeMap.entrySet();
        Iterator it = s.iterator();
        while ( it.hasNext() ) {
              Map.Entry entry = (Map.Entry) it.next();
              Date key = (Date) entry.getKey();
              String value = (String) entry.getValue();
              System.out.println(key + " => " + value);
        }//while
	}//end of method
	
}//End of Class
