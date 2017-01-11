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
		MDC.put("traineeCode", this.username + ".axelor@gmail.com");
		
		LOGGER.info("\n\n");
		LOGGER.info("========================");
		LOGGER.info("Name : " +this.name);
		LOGGER.info("------------------------");
		LOGGER.info("Task List :::: ");
		LOGGER.info("------------------------");
		for(int i = 0; i < this.tasks.size(); i++) {
			Task task = this.tasks.get(i);
			String status = task.isCompleted() ? "Completed" : "Pending";
			
			LOGGER.info((i+1) + ". "+task.getTitle());
			LOGGER.info(" - " + task.getDescription());
			LOGGER.info(" - " + status + " " + (task.isCompleted() ? ", " + task.getCompletedAt().toLocaleString() : ""));
		}
		LOGGER.info("========================");
		
		MDC.remove("traineeCode");
	}
	
	public List<Task> taskList() {
		return this.tasks;
	}
	
}
