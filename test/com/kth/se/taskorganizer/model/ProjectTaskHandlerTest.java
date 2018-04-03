/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kth.se.taskorganizer.model;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import static java.lang.System.in;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.lang.time.DateUtils;


/**
 *
 * @author Chaitali 
 *          SDA 3
 */
public class ProjectTaskHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
    public ProjectTaskHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        //System.setErr(new PrintStream(errContent));
    }
    
    @After
    public void tearDown() {
        System.setOut(System.out);
        //System.setErr(System.err);
    }

    /**
     * Test of displayProjectMenu method, of class ProjectTaskHandler.
     */
    @Test
    public void testDisplayProjectMenu() {
        System.out.println("displayProjectMenu");
        ProjectTaskHandler instance = new ProjectTaskHandler();
        instance.displayProjectMenu();
        
        String expected = "1)ADD TASK ";
        
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of chooseProjectTask method, of class ProjectTaskHandler.
     */
    @Test
    public void testChooseProjectTask() {
        System.out.println("chooseProjectTask");
        ProjectTaskHandler instance = new ProjectTaskHandler();
      

        String input = "8 n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
         System.setIn(in);
                 
         //in = new ByteArrayInputStream("n".getBytes());
         


         //assertEquals("1", inputOutput.getInput());
        instance.chooseProjectTask();
        
        String expected = "PLEASE ENTER YOUR CHOICE:";
        
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addProject method, of class ProjectTaskHandler.
     */
    @Ignore
    public void testAddProject() throws UnsupportedEncodingException {
        System.out.println("addProject");
        ProjectTaskHandler instance = new ProjectTaskHandler();
        Date newDate=null;
        String input = "TESTTASK DONE 11/03/1986";
        String str="...";
        InputStream is = new ByteArrayInputStream(StandardCharsets.UTF_16.encode(input).array());

        //InputStream is = new ByteArrayInputStream( myString.getBytes() );
        //InputStream in = new ByteArrayInputStream(input.getBytes(input));
        
        System.setIn(in);
        
        instance.addProject();
        
        String expected ="ENTER TASK:";
        
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
        assertEquals(expected, actual);
    }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    

    /**
     * Test of getIndexForTask method, of class ProjectTaskHandler.
     */
    @Ignore
    public void testGetIndexForTask() {
        System.out.println("getIndexForTask");
        Date dueDate = null;
        ProjectTaskHandler instance = new ProjectTaskHandler();
        int expResult = 0;
        int result = instance.getIndexForTask(dueDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of manipulateDate method, of class ProjectTaskHandler.
     */
    @Test
    public void testManipulateDate() throws Exception {
        System.out.println("manipulateDate");
        String dueDate =  "11/03/2018";
        ProjectTaskHandler instance = new ProjectTaskHandler();
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
       
        Calendar cal = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();

        Date dueDateObj = myFormat.parse(dueDate);

        calendar.setTime(dueDateObj);
        cal.setTime(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentdate = sdf.format(cal.getTime());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        calendar.add(Calendar.HOUR, hour);
        calendar.add(Calendar.MINUTE, minute);
        calendar.add(Calendar.SECOND, second);
       
        Date expectedDueDateObj = calendar.getTime();
       
       
        
        Date result = instance.manipulateDate(dueDate);
      
        assertEquals (expectedDueDateObj, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sortProjectList method, of class ProjectTaskHandler.
     */
    @Ignore
    public void testSortProjectList() {
        System.out.println("sortProjectList");
        ProjectTaskHandler instance = new ProjectTaskHandler();
        instance.sortProjectList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editProjectList method, of class ProjectTaskHandler.
     */
    @Ignore
    public void testEditProjectList() {
        System.out.println("editProjectList");
        ProjectTaskHandler instance = new ProjectTaskHandler();
        instance.editProjectList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTaskList method, of class ProjectTaskHandler.
     */
    @Ignore
    public void testShowTaskList() {
        System.out.println("showTaskList");
        Map projectMap = null;
        ProjectTaskHandler instance = new ProjectTaskHandler();
        instance.showTaskList(projectMap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printHeadingOfTaskList method, of class ProjectTaskHandler.
     */
    @Ignore
    public void testPrintHeadingOfTaskList() {
        System.out.println("printHeadingOfTaskList");
        ProjectTaskHandler instance = new ProjectTaskHandler();
        instance.printHeadingOfTaskList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class ProjectTaskHandler.
     */
    @Ignore
    public void testRemoveTask() {
        System.out.println("removeTask");
        ProjectTaskHandler instance = new ProjectTaskHandler();
        instance.removeTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeyByValue method, of class ProjectTaskHandler.
     */
    @Ignore
    public void testGetKeyByValue() {
        System.out.println("getKeyByValue");
        Object expResult = null;
        //Object result = ProjectTaskHandler.getKeyByValue(null);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
