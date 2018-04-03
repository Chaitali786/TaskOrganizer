/**
 *
 * @author CHAITALI DEORE
 */
package com.kth.se.taskorganizer.model;

import com.kth.se.taskorganizer.helper.DBHelper;
import com.kth.se.taskorganizer.helper.DBInterface;
import java.io.IOException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectTaskHandler  {

    public int choice;
    public String taskName;
    public String taskStatus;
    public int taskIndex = 0;
    public String date;
    String dueDate;

    Map<Date, TaskDTO> projectMap = new HashMap<>();
    SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
    TaskDTO taskDTO;
    DBInterface  db= new DBHelper();
    private static final String FILENAME = "taskOrganizerFile.txt";

    /**
     * Method To Display Project Menu on console.
     */
    public void displayProjectMenu() {

        System.out.printf("%5s %20s %20s %20s %20s %20s  ", "1)ADD TASK ", "2)SHOW TASK ", "3)SORT TASK ", "4)EDIT TASK ", "5)REMOVE TASK " ,"6)EXIT ");
        System.out.println();
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    /**
     *  Method to accept Menu from user .
     *
     */
    public void chooseProjectTask() {
        char a;

        do {
            System.out.println("PLEASE ENTER YOUR CHOICE:");
            Scanner scChoice = new Scanner(System.in);
            choice = scChoice.nextInt();
            System.out.println();
            switch (choice) {

                case 1:
                    addProject();
                    break;

                case 2:
                    projectMap = db.getAllDataFromDB();
                    showTaskList(projectMap);
                    break;

                case 3:
                    sortProjectList();
                    break;

                case 4:
                    editProjectList();
                    break;
                case 5:
                    removeTask();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

            System.out.println("Do You Want To Continue(Y/N)");
            a = scChoice.next().charAt(0);
        } while (a == 'Y' || a == 'y');

    }

    /**
     * Method To Add Task In Map.
     */
    public void addProject() {
        char a;
        //ObjectOutputStream objectOut = null;
        Date newDate = null;
        myFormat.setLenient(false);
        do {

            Scanner keyboard = new Scanner(System.in);

            System.out.println("ENTER TASK:");
            String taskName = keyboard.nextLine();

            System.out.println("ENTER STATUS:");
            String taskStatus = keyboard.nextLine();

            System.out.println("ENTER TASK DUEDATE(dd/mm/yyyy):");
            String dueDate = keyboard.nextLine();

            //taskDTO = new TaskDTO(taskName, taskStatus, taskIndex);
            try {
                newDate = manipulateDate(dueDate);
            } catch (ParseException ex) {
                Logger.getLogger(ProjectTaskHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int taskIndex = getIndexForTask(newDate);
            db.writeToFile(newDate, new TaskDTO(taskName, taskStatus, taskIndex));
           
            System.out.println("DO YOU WANT TO ADD MORE  TASK (Y/N)");
            a = keyboard.next().charAt(0);
        } while (a == 'Y' || a == 'y');

    }

    
    
    /**
     * Returns task index for new task to be added/edited. If tasks available in
     * database then return (size of existing tasks + 1) otherwise returns 1
     *
     * @param dueDate due date of Task
     * @return Task Index
     */
    public int getIndexForTask(Date dueDate) {
        int taskIndex = 1;
        HashMap<Date, TaskDTO> tasksMap = db.getAllDataFromDB();

        if (tasksMap != null) {
            if (tasksMap.get(dueDate) != null) {
                /*For edit task*/
                TaskDTO task = (TaskDTO) tasksMap.get(dueDate);
                taskIndex = task.getTaskIndex();
            } else {
                /*For new task*/
                taskIndex = tasksMap.size() + 1;
            }
        }
        return taskIndex;
    }

    
    /**
     * This method is String to date 
     * attach current time stamp to date 
     * @param dueDate  Task due date
     * @return newDate  Date
     * @throws ParseException in Date Parsing
     */
    public Date manipulateDate(String dueDate) throws ParseException {
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
        Date newDate = calendar.getTime();
        return newDate;
    }

    /**
     * This method Sort the task list according to date and time.
     */
    public void sortProjectList() {

        projectMap = db.getAllDataFromDB();//getAllTasksFromDB();
        Map<Date, TaskDTO> treeMap = new HashMap<Date, TaskDTO>(projectMap);

        Map<Date, TaskDTO> sortedMap = new TreeMap<Date, TaskDTO>(treeMap);

        showTaskList(sortedMap);

    }

    /**
     * This method edits specified  task.
     */
    public void editProjectList() {

        int taskUserIndex;
        int taskDTOIndex;
        Date date = null;
        String newStatus;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("ENTER TASK INDEX TO EDIT:");
        taskUserIndex = keyboard.nextInt();
        keyboard.nextLine();
        projectMap = db.getAllDataFromDB();
        Map<Date, TaskDTO> tempMap = new HashMap<Date, TaskDTO>(projectMap);
        Set s = tempMap.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            taskDTO = (TaskDTO) entry.getValue();
            date = (Date) entry.getKey();
            taskDTOIndex = taskDTO.getTaskIndex();
            if (taskDTOIndex == taskUserIndex) {
                System.out.println("ENTER NEW STATUS(DONE / PENDING):");
                newStatus = keyboard.nextLine();
                taskDTO.setStatus(newStatus);
                break;
            }
        }   
        db.writeToFile(date, taskDTO);
        tempMap = db.getAllDataFromDB();
        showTaskList(tempMap);
    }

    /**
     * Method to populate task list on screen.
     * @param projectMap   Task Details  
     */
    public void showTaskList(Map projectMap) {

       

        if (projectMap == null) {
            System.out.println(" ******** NO TASK FOUND ******** ");
            System.out.println();
            return;
        }
        System.out.println("Loading ...............");
        printHeadingOfTaskList();
        
        Set s = projectMap.entrySet();

       
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            taskDTO = (TaskDTO) entry.getValue();

            System.out.print(taskDTO.getTaskIndex());
            String newUpdatedDate = myFormat.format(entry.getKey());

            System.out.printf("%20s", newUpdatedDate);

            String toPad = taskDTO.getTask();
            for (int i = toPad.length(); i <= 30; i++) {
                toPad += " ";
            }

            System.out.printf("\t\t%s", toPad);

            System.out.printf(" \t\t %s", taskDTO.getStatus());
            System.out.println();
        }//while
        System.out.println("--------------------------------------------------------------------------------------------------");

    }
    /**
     * Method to Column Heading of tasks details .
     */
    public void printHeadingOfTaskList() {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("INDEX ");
        System.out.printf("%15s", "DUE DATE ");
        System.out.printf("%25s", "TASK");
        System.out.printf("%40s", "STATUS");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------");

    }
    /**
     * Method to remove Task of given index number.
     */
    public void removeTask(){
        int taskUserIndex;
        int taskDTOIndex;
        Date date = null;
        String newStatus;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("ENTER TASK INDEX TO DELETE:");
        taskUserIndex = keyboard.nextInt();
        keyboard.nextLine();
        projectMap = db.getAllDataFromDB();
        Map<Date, TaskDTO> tempMap = new HashMap<Date, TaskDTO>(projectMap);
        Set s = tempMap.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            taskDTO = (TaskDTO) entry.getValue();
            //date = (Date) entry.getKey();
            
            taskDTOIndex = taskDTO.getTaskIndex();
            
            if (taskDTOIndex == taskUserIndex) {
                
                date = getKeyByValue(tempMap,taskDTO);
                System.out.println("DATE FOUND !!!! "+date);
                
                tempMap.remove(date); break;
                // tempMap.values().removeAll(Collections.singleton(date));
            }
        }
        db.writeToFile(tempMap, FILENAME);
        tempMap = db.getAllDataFromDB();
        showTaskList(tempMap);
    
    }
    
    
    /**
     * Generic method to get key based on given value.
     * @param <T> key 
     * @param <E> value
     * @param map map
     * @param value input from user
     * @return key key
     */
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
    for (Entry<T, E> entry : map.entrySet()) {
        if (Objects.equals(value, entry.getValue())) {
            return entry.getKey();
        }
    }
    return null;
    }
}//End of Class
