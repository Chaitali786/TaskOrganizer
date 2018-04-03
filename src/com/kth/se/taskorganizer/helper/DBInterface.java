/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kth.se.taskorganizer.helper;

import com.kth.se.taskorganizer.model.TaskDTO;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Public Interface to handle Database Operation
 * @author tmp-sda-1180
 */
public interface DBInterface {
    public void writeToFile(Date dueDate, TaskDTO taskDTO);
    public void writeToFile(Map<Date, TaskDTO> projectMap, String dbFileName);
    public HashMap<Date, TaskDTO> getAllDataFromDB();
    
}
