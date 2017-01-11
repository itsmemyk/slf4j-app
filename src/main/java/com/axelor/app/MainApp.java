package com.axelor.app;


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
		
		agaAxelor.assign(junit);
		agaAxelor.assign(slf4j);
		agaAxelor.assign(git);

		agaAxelor.completeAll();
		
		jsoAxelor.assign(eclipse);		
		ugoAxelor.assign(joiningReport);		
		tboAxelor.assign(gradle);
		
		mmahAxelor.assign(training);
		mmahAxelor.complete(training);
		
    	Team axelor= new Team("Axelor Trainees");
    	axelor.addMember(agaAxelor);
    	axelor.addMember(jsoAxelor);
    	axelor.addMember(ugoAxelor);
    	axelor.addMember(tboAxelor);
    	axelor.addMember(mmahAxelor);
    	
    	axelor.logReports();
    }
}