package com.axelor.app;

import java.util.Arrays;

public class MainApp {
    
    public static void main ( String [] args ) {
    	Task junit = new Task("JUnit", "Create one demo java Application for jUnit Testing");
    	Task slf4j = new Task("Slf4j", "Create one demo java Application to make custom logging system");
    	Task git = new Task("Git", "Create single app, maintain different programs in different branch");
    	Task eclipse = new Task("Eclipse", "Kindly check all custom settings for eclipse project");
    	Task joiningReport = new Task("Project Report", "Kindly submit all project reports to college");
    	Task gradle = new Task("Gradle", "Create java app using gradle [Hint: apply dependency]");
    	Task training = new Task("Training", "Teaching to axelor team");
    	
		Trainee agaAxelor = new Trainee("Akshay", "aga");
		Trainee jsoAxelor = new Trainee("Jai", "jso");
		Trainee ugoAxelor = new Trainee("Umesh", "ugo");
		Trainee tboAxelor = new Trainee("Tushar", "tbo");
		Trainee mmahAxelor = new Trainee("Mayank", "mmah");
		
		Arrays.asList(junit, slf4j, git).forEach(t -> agaAxelor.assign(t));		
		agaAxelor.completeAll();
		
		jsoAxelor.assign(eclipse);		
		ugoAxelor.assign(joiningReport);		
		tboAxelor.assign(gradle);
		
		Arrays.asList(training).forEach(t -> {
			mmahAxelor.assign(t);
			mmahAxelor.complete(t);
		});				
		
    	Team axelor= new Team("Axelor Trainees");
    	
    	Arrays.asList(agaAxelor, jsoAxelor, ugoAxelor, tboAxelor, mmahAxelor, mmahAxelor)
			.forEach(m -> axelor.addMember(m));
    	
    	axelor.logReports();
    }
}