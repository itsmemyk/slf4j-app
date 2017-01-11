package com.axelor.app;

import java.util.Date;

public class Task {
	private String title;
	private String description;
	private Date createdAt;
	private boolean completed;
	private Date completedAt;
	
	public Task(String title, String description, Date createAt) {
		this.title = title;
		this.description = description;
		this.createdAt = createAt;
		this.completed = false;
	}
	
	public Task(String title, String description) {
		this(title, description, new Date());
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean isCompleted) {
		this.completed = isCompleted;
	}

	public Date getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}
	
}
