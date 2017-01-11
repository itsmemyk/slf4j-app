package com.axelor.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team {
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
	
	public void addMember(Trainee newMember) {
		this.trainees.add(newMember);
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
