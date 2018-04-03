/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kth.se.taskorganizer.helper;

import com.kth.se.taskorganizer.model.ProjectTaskHandler;
import com.kth.se.taskorganizer.model.TaskDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmp-sda-1180
 */
public class DBHelper  implements DBInterface{
    private static final String fileName = "taskOrganizerFile.txt";
    
    
    /**
     * This method saves specified task to the file
     *
     * @param dueDate task date
     * @param taskDTO task details
     */
    public void writeToFile(Date dueDate, TaskDTO taskDTO)
    {
          HashMap<Date, TaskDTO> projectMap=null;
          ObjectOutputStream objectOut = null;
          try {

            File dbFile = new File(fileName);
            
            if (dbFile.exists()) {
                FileInputStream istream = null;

                istream = new FileInputStream(fileName);

                ObjectInputStream p = null;

                p = new ObjectInputStream(istream);
                projectMap = (HashMap<Date, TaskDTO>) p.readObject();

                

            }
            if (projectMap == null) {
                    projectMap = new HashMap<>();
                }
                projectMap.put(dueDate, taskDTO);
                writeToFile(projectMap, fileName);

                
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectTaskHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param projectMap Task Detail
     * @param dbFileName File Name 
     */  
    @Override
    public void writeToFile(Map<Date, TaskDTO> projectMap, String dbFileName) 
            {
    
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(dbFileName);
            ObjectOutputStream objectOut = null;
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(projectMap);
            objectOut.close();
            System.out.println("Record Saved Succesfully!!!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     * This method returns all the tasks from database
     *
     * @return task details from database
     */
    public HashMap<Date, TaskDTO> getAllDataFromDB()
    {
        HashMap<Date, TaskDTO> tasksMap = null;

        File dbFile = new File(fileName);

        if (dbFile.exists()) {
            FileInputStream istream = null;
            try {
                istream = new FileInputStream(dbFile);
                ObjectInputStream p = null;
                p = new ObjectInputStream(istream);
                tasksMap = (HashMap<Date, TaskDTO>) p.readObject();

            } catch (IOException | ClassNotFoundException exception) {
                Logger.getLogger(ProjectTaskHandler.class.getName()).log(Level.SEVERE, null, exception);
            }

        }
        return tasksMap;
    }
    
}
