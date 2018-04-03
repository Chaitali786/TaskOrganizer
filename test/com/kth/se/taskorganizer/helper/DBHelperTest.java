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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tmp-sda-1180
 */
public class DBHelperTest {
    
    public DBHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of writeToFile method, of class DBHelper.
     */
    @Test
    public void testWriteToFile_Date_TaskDTO() {
        System.out.println("writeToFile");
        Date dueDate = null;
        TaskDTO taskDTO = null;
        DBHelper instance = new DBHelper();
        instance.writeToFile(dueDate, taskDTO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToFile method, of class DBHelper.
     */
    @Test
    public void testWriteToFile_Map_String() {
        System.out.println("writeToFile");
        Map<Date, TaskDTO> projectMap = null;
        String dbFileName = "";
        DBHelper instance = new DBHelper();
        instance.writeToFile(projectMap, dbFileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDataFromDB method, of class DBHelper.
     */
    @Test
    public void testGetAllDataFromDB() {
        System.out.println("getAllDataFromDB");
        DBHelper instance = new DBHelper();
        HashMap<Date, TaskDTO> expResult = null;
        HashMap<Date, TaskDTO> result = instance.getAllDataFromDB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
