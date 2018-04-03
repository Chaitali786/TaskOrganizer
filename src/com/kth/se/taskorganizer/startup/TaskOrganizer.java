package com.kth.se.taskorganizer.startup;
import com.kth.se.taskorganizer.view.TaskView;
import java.io.IOException;
import java.text.ParseException;
/**
 * Startup Class Of Task Organizer 
 * @author Chaitali DEORE
 *         SDA 3
 * Startup Class for Task Organizer.
 *
 */
public class TaskOrganizer {
	public static void main(String[] args) throws ParseException
	{
		TaskView taskView =new TaskView();
                GUITaskOrganizer guiTaskOrganizer = new GUITaskOrganizer();
                try {
                      guiTaskOrganizer.displayMenuframe();
                      taskView.screenView();
                      
                } catch (IOException ex) {
                    System.out.println("No such file or directory");
                      
                }
        
	}
        

}
