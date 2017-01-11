package com.axelor.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Team {
	private static final Logger LOGGER= LoggerFactory.getLogger(Trainee.class);
	private String name;
	private List<Trainee> trainees = new ArrayList<Trainee>();
	
	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private boolean isMemberExist(Trainee trainee) {
		boolean isExist = trainees.stream().filter((t) -> t.getUsername() == trainee.getUsername()).findAny().orElse(null) != null;
		if (isExist) {
			LOGGER.error("Trainee : " + trainee.getName() + ", already exist in " + this.name);
		}
		return isExist;
	}
	
	public void addMember(Trainee newMember) {
		if (!this.isMemberExist(newMember)) {
			this.trainees.add(newMember);
		}
	}
	
	public void removeMember(Trainee oldMember) {
		this.trainees.remove(oldMember);
	}
	
	public List<Trainee> viewTeamMembers() {
		return this.trainees;
	}
	
	public void logReports() {
    	Iterator<Trainee> traverseTeam = this.viewTeamMembers().iterator();
    	while(traverseTeam.hasNext()) {
    		Trainee trainee = traverseTeam.next();
    		trainee.logTaskList();
    	}
	}
}
