package com.poised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * Where main program will run
 * @author Kushal Gopee
 * @version 1.0
 *
 */
public class Main {

	/**
	 * Function to prompt user questions that require answers. This will only be for String inputs
	 * @param buf buffer reader for taking in user input
	 * @param message Message the user wants to display
	 * @return return Return the user choice
	 * @throws IOException
	 */
	private static String promptUser(BufferedReader buf, String message) throws IOException {
		System.out.println(message); // prompt message to user
		String userChoice = buf.readLine(); // read users choice
		if (userChoice.length() == 0) {
			userChoice = "NULL";
			return userChoice;
		}
		else {
		return userChoice; // return user choice
		}
	}
	
	/**
	 * Function to display the main menu option to the user
	 * @param in Scanner to take user input
	 * @param userOption This is for the user option i.e. the menu option of the user.
	 * @param userMessage This is for the user option i.e. the menu option of the user.
	 * @return userOption Return the user choice
	 */
	private static int mainMenuUserOption(Scanner in, int userOption, String userMessage,int numberOfProjectsInList) {
		boolean inputValid; // start valid input boolean
		inputValid = false; // set it to false
		// while not false
		while (!inputValid) {
			// display message to user
			System.out.println(userMessage);
			// take the user input
			String input = in.nextLine();

			try {
				// assign user input to userOption [cast to integer]
				userOption = Integer.parseInt(input);
				
				// if user option >= 1 or <=6 because there are 4 menu options
				if ((userOption >= 1 || userOption <=6) && numberOfProjectsInList > 0 ) {
					// return the user option
					return userOption;
				}
				// if user option == 1 because there are 1 menu options
				// This menu option is only available because no projects have been selected.
				else if (userOption == 1 && numberOfProjectsInList == 0) {
					// return the user option
					return userOption;
				}

				// invalid user option
				else {
					System.out.println("Incorrect user option");
					inputValid = false;
				}
			}
			// catch if user enter anything that is not a number
			catch (NumberFormatException e) {
				// tell the user they did not eneter a valid number
				System.out.println("You didn't enter a valid number");
			}
		}
		// return
		return userOption;
	}
	
	/**
	 * Function to take in the user option in order to determine which aspect of the project the user wishes to update
	 * @param in
	 * @param userOption
	 * @param userMessage
	 * @return userOption Return the user choice
	 */
	private static int updateUserDetailsMenuOfListOfProjects(Scanner in, int userOption, String userMessage) {
		boolean inputValid; // start valid input boolean
		inputValid = false; // set it to false
		// while not false
		while (!inputValid) {
			// display message to user
			System.out.println(userMessage);
			// take the user input
			String input = in.nextLine();

			try {
				// assign user input to userOption [cast to integer]
				userOption = Integer.parseInt(input);
				// if user option >= 1 or <=4 because there are 4 menu options
				if (userOption >= 1 || userOption <= 4) {
					// return the user option
					return userOption;
				}

				// invalid user option
				else {
					System.out.println("Incorrect user option");
					inputValid = false;
				}
			}
			// catch if user enter anything that is not a number
			catch (NumberFormatException e) {
				// tell the user they did not eneter a valid number
				System.out.println("You didn't enter a valid number");
			}
		}
		// return
		return userOption;
	}

	/*
	 * Function for sub Menu Option. It will display the sub menu option. It will
	 * take a message so you can customize the sub menu to the user.
	 * 
	 * @param in
	 * @param userOption
	 * @param menuMessage
	 */
	private static int subMenuOption(Scanner in, int userOption, String menuMessage) {
		boolean inputValid; // start valid input boolean
		inputValid = false; // set it to false
		// while not false
		while (!inputValid) {
			System.out.println(menuMessage); // prompt message to user
			String input = in.nextLine(); // read user Input

			try {
				userOption = Integer.parseInt(input); // assign input to userOption
				// if user option >= 1 or <=2 because there are 2 menu options
				if (userOption >= 1 || userOption <= 2) {
					return userOption;
				}
				// if userOption falls out of 1 and 2
				else {
					System.out.println("Enter a valid user option");
					inputValid = false; // start loop again
				}

			}
			// catch if user enter anything that is not a number
			catch (NumberFormatException e) {
				// tell the user they did not eneter a valid number
				System.out.println("You didn't enter a valid number");
			}
		}
		return userOption;
	}
	
	/**
	 * This function is used to read the file that contains the current projects
	 * The function used the class savePorject to set and get the elements from the text file
	 * @param fileName - File Name to read
	 * @return saveprojects - return the saved projects
	 */
    private static List<saveProject> readProjectsFromCSV(String fileName) {
    	//List of saveProject
    	 List<saveProject> saveprojects = new ArrayList<>();
    	 //path to the file name
    	 Path pathToFile = Paths.get(fileName);
    	 /*BEGIN TRY*/ 
    	 try (BufferedReader br = Files.newBufferedReader(pathToFile, //create a buffer reader and assign the path to file with a unicode encoding
                  StandardCharsets.US_ASCII)) {
    		  String line = br.readLine(); //read each line
    		  //while the line is not empty
    		  while (line != null) { 
    			  //assign each attribute picked and append to the array of attributes
    			  String[] attributes = line.split("; ");
    			  //get class save project and call funciton to create the projects by assigning each value in each line as attributes
    			  //e.g. Line 1 = [ProjectA; Dog house]
    			  // saveProject = ProjectA = (class saveProject to set projectName)
    			  saveProject saveproject = createProject(attributes);
    			  saveprojects.add(saveproject);
    			  //read line
    			  line = br.readLine();
    		  }
		  /*END TRY*/
    		      		  
    	  }catch (IOException ioe) {
              ioe.printStackTrace();
          } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	  return saveprojects;
    }
    /**
     * create a metadata structure to easily access values that are coming from the list of objects of savedProjects
     * @param metadata - will store the values from the saveProject file
     * @return new saveProject - i.e return each project back to the user
     * @throws ParseException
     */
    private static saveProject createProject(String[] metadata) throws ParseException {
    	
    	String projectName = metadata[0];
    	String buildingType = metadata[1];
    	String projectAddress = metadata[2];
    	String erfNumber = metadata[3];
    	double projectPrice = Double.parseDouble(metadata[4]);
    	double projectAmountPaidToDate = Double.parseDouble(metadata[5]);
    	//simple date format to take the time and day of the project i.e. the deadline date
    	Date deadlineDate = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy").parse(metadata[6]);
    	
    	String contractorName = metadata[7];    	
    	String contractorTelephoneNumber= metadata[8];
    	String contractorEmailAddress = metadata[9];
    	String contractorPhysicalAddress = metadata[10];
    	
    	String architectName = metadata[11];
    	String architectTelephoneNumber = metadata[12];
    	String architectEmailAddress = metadata[13];
    	String architectPhysicalAddress = metadata[14];
    	
    	String customerName = metadata[15];
    	String customerTelephoneNumber = metadata[16];
    	String customerEmailAddress = metadata[17];
    	String customerPhysicalAddress = metadata[18];
    	
    	return new saveProject(projectName, buildingType,projectAddress, erfNumber,projectPrice,projectAmountPaidToDate,deadlineDate,
    			contractorName,contractorTelephoneNumber,contractorEmailAddress,contractorPhysicalAddress,
    			architectName,architectTelephoneNumber,architectEmailAddress,architectPhysicalAddress,
    			customerName,customerTelephoneNumber,customerEmailAddress,customerPhysicalAddress);
    }
    
    

    /**
     * Main function where entire project will run
     * @param args
     * @throws ParseException
     * @throws IOException
     */
	public static void main(String[] args) throws ParseException, IOException {

		/**
		 * @param myFormat creates a simpldate format for user to eneter date e.g. 23/05/2020
		 */
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		/**
		 * create buffer reader to read user
		 */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * Scanner for input
		 */
		Scanner in = new Scanner(System.in); 
		/**
		 * variable for total fee for project 
		 * variable for total fee paid to date
		 */
		double totalFeeForProject = 0;
		double totalFeePaidToDate = 0; 
		/**
		 * 	user date
		 * 	get the current Date
		 */
		String userDate = "";
		Date currentDate = new Date();
		/**
		 * the sub user option variable i.e. 1 or 2 [1 for project number and 2 for project name]
		 */
		int sub_user_option = 0; 
		/**
		 * myWriter variable for saved project with true in order to append to the file
		 */
		FileWriter savedProjectFile = new FileWriter("..\\Poised\\src\\com\\poised\\savedProjects.txt",true); 
		/**
		 * boolean to start the menu is true
		 */
		boolean isTrueMainMenu = true; 
		
		//while loop to start the menu
		while(isTrueMainMenu == true) {
			//list of savePorject object that will call the function readProjectsFromCSV to read the saved project data
			List<saveProject> proj = readProjectsFromCSV("..\\Poised\\src\\com\\poised\\savedProjects.txt"); 
			//variable to store the number of projects in the list
			int numberOfProjectsInList = proj.size();
			//array of String to store the names of the projects
			String[] projectNamesInList = new String[numberOfProjectsInList];
			/**
			 * For loop to loop through list of objects size and assign the project names to the variable projectNameInList
			 */
			for (int counter = 0; counter < proj.size(); counter++) { 		      
				 projectNamesInList[counter] = proj.get(counter).projectName;
		      }
			
			//start counter for project list of objects
			int counterForProjectListOfObjects=0;
			System.out.println("===========Welcome to Poised===========");
			System.out.println("Here is a list of projects");
			//for saveProject in proj variable
			for (saveProject listOfProjectc : proj) 
			{ 
				counterForProjectListOfObjects++; // increment counter
				//print list of current projects
				System.out.println("project Number and Name: " + counterForProjectListOfObjects + " " + listOfProjectc.projectName); 
			}
			System.out.println("");
			System.out.println();
			
			//take in main menu first user option
			int takeInFirstUserOption = 0;
			// take in the users for which detail of the project they wish to update
			int updateDetailsUserOption =0;
			
			//if there is no project in the file
				//user will only be able to add project
			if (numberOfProjectsInList == 0) {
				System.out.println("There are no projects");
				 takeInFirstUserOption = mainMenuUserOption(in, takeInFirstUserOption,"Would you like to \n"
							+ "[1] Add a project to this list \n",numberOfProjectsInList);
		    //else there is projects show user the menu below
			}else {
			 takeInFirstUserOption = mainMenuUserOption(in, takeInFirstUserOption,"Would you like to \n"
					+ "[1] Add a project to this list \n"
					+ "[2] See list of projects that still need to be completed \n"
					+ "[3] See list of projects that are past the due date \n"
					+ "[4] Update project details \n"
					+ "[5] Finalise project \n"
					+ "[6] Exit Program",numberOfProjectsInList
					);
			}
			//if the user wants to add a project
			 if (takeInFirstUserOption == 1) {
					// Take user input for the number of projects.
					int numberOfProjects = Methods.createNumberOfProjects(in);

					Project[] projects = new Project[numberOfProjects]; // array for Projects to store the projects the index is the
					// number of projects i.e. what is in [numberOfProjects]
					Person[] contractor = new Person[numberOfProjects];// array for Contractor to store the projects the index is
					// the number of projects i.e. what is in [numberOfProjects]
					Person[] architect = new Person[numberOfProjects];// array for architect to store the projects the index is the
					// number of projects i.e. what is in [numberOfProjects]
					Person[] customer = new Person[numberOfProjects];// array for architect to store the projects the index is the
					// number of projects i.e. what is in [numberOfProjects]

					String[] projectNameStorage = new String[numberOfProjects];

					// loop through length of project
					for (int i = 0; i < projects.length; i++) {
						/* PROJECT DETAILS: BEGIN */
						String projectName = promptUser(buf, "For project " + (i + 1) + " enter the project name ");
						String buildingName = promptUser(buf, "What type of building is being designed");
						String physicalAddress = promptUser(buf, "What is the physical address for the project");
						String ERF = promptUser(buf, "What is the ERF number?");
						projectNameStorage[i] = projectName;

						totalFeeForProject = Methods.createProjectFee(in, totalFeeForProject,
								"Total fee for the project e.g. 300.50");

						totalFeePaidToDate = Methods.createProjectFee(in, totalFeePaidToDate, "Total fee paid so far e.g. 300.50");

						userDate = Methods.createProjectDueDate(in);
						/* PROJECT DETAILS: END */

						/* CONTRACTOR DETAILS: BEGIN */
						String contractorName = promptUser(buf, "Enter the contractors Name");
						String contractorTelephoneNumber = promptUser(buf,
								"Enter the cotractors telephone number e.g. (012) 807-6778");
						String contractorEmailAddress = promptUser(buf,
								"Enter the cotractors email address e.g. example@gmail.com");
						String contractorPyhsicalAddress = promptUser(buf, "Enter the cotractors physical address");
						/* CONTRACTOR DETAILS: END */

						/* ARCHITECT DETAILS: BEGIN */
						String architectName = promptUser(buf, "Enter the architects Name");
						String architectTelephoneNumber = promptUser(buf,
								"Enter the architect telephone number e.g. (012) 807-6778");
						String architectEmailAddress = promptUser(buf, "Enter the architect email address e.g. example@gmail.com");
						String architectPyhsicalAddress = promptUser(buf, "Enter the architect physical address");
						/* ARCHITECT DETAILS: END */

						/* CUSTOMER DETAILS: BEGIN */
						String customerName = promptUser(buf, "Enter the customers Name");
						String customerTelephoneNumber = promptUser(buf,
								"Enter the customers telephone number e.g. (012) 807-6778");
						String customerEmailAddress = promptUser(buf, "Enter the customers email address e.g. example@gmail.com");
						String customerPyhsicalAddress = promptUser(buf, "Enter the customers physical address");
						/* CUSTOMER DETAILS: END */

						// if the project name is empty
						if (projectName.isEmpty()) {
							projectName = buildingName + " " + customerName;
						}

						// insert into the array for each type of array declared a new instance of its
						// class
						projects[i] = new Project(i + 1, projectName, buildingName, physicalAddress, ERF, totalFeeForProject,
								totalFeePaidToDate, myFormat.parse(userDate));
						contractor[i] = new Person(i + 1, contractorName, contractorTelephoneNumber, contractorEmailAddress,
								contractorPyhsicalAddress);
						architect[i] = new Person(i + 1, architectName, architectTelephoneNumber, architectEmailAddress,
								architectPyhsicalAddress);
						customer[i] = new Person(i + 1, customerName, customerTelephoneNumber, customerEmailAddress,
								customerPyhsicalAddress);
					}

					// print out the projects since the length of all arrays are the same we can
					// loop through any array
					for (int i = 0; i < projects.length; i++) {
					
						   try {
							      
							      savedProjectFile.write(projects[i].getProjectName() + "; "
							    		  	   + projects[i].getBuildingType() + "; "
							    		  	   + projects[i].getPhysicalAddress() + "; "
							    		  	   + projects[i].getERF() + "; "
							    		  	   + projects[i].getTotalCharge() + "; "
							    		  	   + projects[i].getTotalPaidToDate() + "; "
							    		  	   + projects[i].getDeadlineDate() + "; "
							    		  	   + contractor[i].getName() + "; "
							    		  	   + contractor[i].getTelephoneNumber() + "; "
							    		  	   + contractor[i].getEmailAddress() + "; "
							    		  	   + contractor[i].getPhysicalAddress() + "; "
							    		  	   + customer[i].getName() + "; "
							    		  	   + customer[i].getTelephoneNumber() + "; "
							    		  	   + customer[i].getEmailAddress() + "; "
							    		  	   + customer[i].getPhysicalAddress() + "; "
							    		  	   + architect[i].getName() + "; "
							    		  	   + architect[i].getTelephoneNumber() + "; "
							    		  	   + architect[i].getEmailAddress() + "; "
							    		  	   + architect[i].getPhysicalAddress());
							      savedProjectFile.write("\n");
							    } catch (IOException e) {
							      System.out.println("An error occurred.");
							      e.printStackTrace();
							    }
						
						 
						
						System.out.println("\t\t==================== PROJECT NAME : " + projects[i].getProjectName()
								+ " ====================");
						System.out.println(" " + "Project Name: " + projects[i].getProjectName() + " " + projects[i].toString());
						System.out.println(" " + "Contractor Name: " + contractor[i].getName() + " " + contractor[i].toString());
						System.out.println(" " + "Customer Name: " + customer[i].getName() + " " + customer[i].toString());
						System.out.println(" " + "Architect Name: " + architect[i].getName() + " " + architect[i].toString());
						System.out.println("\n");

					}
					savedProjectFile.close();
					isTrueMainMenu = true;
			 
 
			 }
			 //See list of projects that still need to be completed
			 else if (takeInFirstUserOption == 2) {
			     System.out.println("\nHere is a list projects that still need to be completed"); 
			     counterForProjectListOfObjects=0;
				 //for each project
			     for (saveProject b : proj) 
					{ 
						counterForProjectListOfObjects++;//increment the counter
						//if the deadline date compared to the current date is > than 0
						if (b.deadlineDate.compareTo(currentDate) > 0 ) {
							System.out.println("project Number and Name: " + counterForProjectListOfObjects + " " + b.projectName); 
						}
					}
				 System.out.println("\n");
				 //exit from the menu option
				 isTrueMainMenu = true;
				 
			 }
			 
			 //See list of projects that are past the due date
			 else if (takeInFirstUserOption == 3) {
				 
				 System.out.println("\nHere is a list projects that are past the due date"); 
			     counterForProjectListOfObjects=0;
			     //for each project
				 for (saveProject b : proj) 
					{ 
						counterForProjectListOfObjects++; //increment the counter
						//if the deadline date compared to the current date is < than 0
						if (b.deadlineDate.compareTo(currentDate) < 0 ) {
							System.out.println("project Number and Name: " + counterForProjectListOfObjects + " " + b.projectName); 
						}
					}
				 System.out.println("\n");
				 //exit from the menu option
				 isTrueMainMenu = true;
			 }
			 //if user wants to Update project details aspects
			 else if (takeInFirstUserOption == 4) {
				 //take user option for which aspect of the project they wish to update
				 updateDetailsUserOption=updateUserDetailsMenuOfListOfProjects(in, takeInFirstUserOption,"What would you like to update \n"
					 		+ "[1] Project \n"
					 		+ "[2] Contractor \n"
					 		+ "[3] Architect \n"
					 		+ "[4] Customer  \n");
				 
				 //BEGIN: if user wants to update projects
				 if (updateDetailsUserOption == 1) {
						sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
								+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
						//if user want to search by project number
						if (sub_user_option == 1) {
							Methods.changeProjectDetailByProjectNumberFromListOfObjects(proj, numberOfProjectsInList);
						}
						//if user want to search by project name
						else if (sub_user_option == 2) {
							Methods.changeProjectDetailByProjectNameFromListOfObjects(proj, numberOfProjectsInList, projectNamesInList);
						}
				 }
				 //END: if user wants to update projects
				 
				 //BEGIN: if user wants to Contractor details
				 else if (updateDetailsUserOption ==2){
						sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
								+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
						//if user want to search by project number
						if (sub_user_option == 1) {
							Methods.changeContractorsDetailByProjectNumberFromListOfObjects(proj, numberOfProjectsInList);
						}
						//if user want to search by project name
						else if (sub_user_option == 2) {
							Methods.changeContractorsDetailByProjectNameFromListOfObjects(proj, numberOfProjectsInList, projectNamesInList);
						}
				 	}
				 //END: if user wants to Contractor details
				 
				 //BEGIN: if user wants to Architect details
				 else if (updateDetailsUserOption == 3) {
					 sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
								+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
					//if user want to search by project number
						if (sub_user_option == 1) {
							Methods.changeArchitectDetailByProjectNumberFromListOfObjects(proj, numberOfProjectsInList);
						}
					//if user want to search by project name
						else if (sub_user_option == 2) {
							Methods.changeArchitectDetailByProjectNameFromListOfObjects(proj, numberOfProjectsInList, projectNamesInList);
						}
				 }
				//END: if user wants to Architect details
				 
				 //BEGIN: if user wants to update Customer details
				 else if (updateDetailsUserOption == 4) {
					 sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
								+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
						//if user want to search by project number
						if (sub_user_option == 1) {
							Methods.changeCustomerDetailByProjectNumberFromListOfObjects(proj, numberOfProjectsInList);
						}
						//if user want to search by project name
						else if (sub_user_option == 2) {
							Methods.changeCustomerDetailByProjectNameFromListOfObjects(proj, numberOfProjectsInList, projectNamesInList);
						}
				 }
				 //END: if user wants to update Customer details
			 }
			 
			 //if user wants to Update project details aspects
			 else if (takeInFirstUserOption == 5) {
				 sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
							+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
				//if user want to search by project number
					if (sub_user_option == 1) {
						Methods.FinaliseProjectByProjectNumber(proj, numberOfProjectsInList);
					}
				//if user want to search by project name
					else if (sub_user_option == 2) {
						Methods.FinaliseProjectByProjectName(proj, numberOfProjectsInList, projectNamesInList);
					}
			 }
			 
			 //if user wants to exit the project
			 else if (takeInFirstUserOption == 6) {
				 System.out.println("Details saved");
				 System.out.println("Program exiting");
				 System.exit(0);
			 }
			
			
		}
		
	}

}
