package com.axelor.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Trainee {
	private static final Logger LOGGER= LoggerFactory.getLogger(Trainee.class);
	private String name;
	private String username;
	private List<Task> tasks = new ArrayList<Task>();
	
	public Trainee(String name, String username) {
		this.name = name;
		this.username = username;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public void assign(Task newTask) {
		this.tasks.add(newTask);
	}
	
	public void complete(Task givenTask) {
		givenTask.setCompleted(true);
		givenTask.setCompletedAt(new Date());
	}
	
	public void completeAll() {
		Iterator<Task> allTasks = this.tasks.iterator();
		while(allTasks.hasNext()) {
			this.complete(allTasks.next());
		}
	}
	
	public void logTaskList() {
		List<String> logs = new ArrayList<String>();
		
		logs.add("\n\n");
		logs.add("========================");
		logs.add("Name : " +this.name);
		logs.add("------------------------");
		logs.add("Task List :::: ");
		logs.add("------------------------");
		
		for(int i = 0; i < this.tasks.size(); i++) {
			Task task = this.tasks.get(i);
			String status = task.isCompleted() ? "Completed" : "Pending";
			
			logs.add((i+1) + ". "+task.getTitle());
			logs.add(" - " + task.getDescription());
			logs.add(" - " + status + " " + (task.isCompleted() ? ", " + task.getCompletedAt().toLocaleString() : ""));
		}
		
		logs.add("========================");
		
		MDC.put("traineeCode", this.username + ".axelor@gmail.com");
		
		logs.forEach(LOGGER::info);
		
		MDC.remove("traineeCode");
	}
	
	public List<Task> taskList() {
		return this.tasks;
	}
	
}
