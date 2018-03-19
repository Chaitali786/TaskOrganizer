package com.kth.se.taskorganizer.model;

public class TaskDTO {
	String task ;
	String status ;
    int taskIndex=0;
	public TaskDTO(String task, String status,int taskIndex){
		this.task =task;
		this.status=status;
		this.taskIndex = taskIndex;
	}
	public String getTask()
	{return task;}
	public String getStatus()
	{return status;}
	public int getTaskIndex()
	{return taskIndex;}
	
}//End Of Task
