package com.poised;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This will store methods that will be used in the project
 * @author Kushal Gopee
 *
 */
public class Methods {

	/**
	 * Function to create the number of projects
	 * @param in
	 * @return numberOfProjects - return the number of projects the user wants to input
	 */
	public static int createNumberOfProjects(Scanner in) {
		boolean inputValid = false;
		//init number of projects
		int numberOfProjects = 0;
		
		//while loop
		while (!inputValid) {
			System.out.println("How many projects will you be creating");
			//take user input
			String input = in.nextLine();

			try {
				//assign user input to number of Projects variable
				numberOfProjects = Integer.parseInt(input);
				//if number of projects is less than 0
				//User must enter 1 project min.
				if (numberOfProjects <= 0) {
					System.out.println("You must have 1 project minimum");
					inputValid = false;
				} 
				//user placed a correct number
				else {
					return numberOfProjects;
				}
			} catch (NumberFormatException e) {
				System.out.println("You didn't enter a valid number");

			}

		}
		return numberOfProjects;
	}

	/*
	 * Method to create a project fee
	 * @param in
	 * @param projectFee
	 * @param userMessage = allows to take a user message
	 * 
	 */
	public static double createProjectFee(Scanner in, double projectFee, String userMessage) {
		boolean inputValid;
		inputValid = false;
		
		//Start while loop
		while (!inputValid) {
			System.out.println(userMessage); // show user the message
			String input = in.nextLine(); //take the user message
			
			try {
				//assign project fee
				projectFee = Double.parseDouble(input);
				//if project fee is < 0 
				if (projectFee < 0) {
					System.out.println("Your project cannot cost less than 0");
					inputValid = false;
				} 
				//if project fee > 0
				else {
					inputValid = true;
				}
				// catch number format exception
			} catch (NumberFormatException e) {
				System.out.println("You didn't enter a valid amount");
			}
		}
		return projectFee;
	}

	
	/**
	 * This function allows the user to change the contractor details by the project number
	 * @param proj = take in the list of project objects
	 * @param numberOfProjects = take in the number of projects
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void changeContractorsDetailByProjectNumberFromListOfObjects(List<saveProject> proj,
			int numberOfProjects) throws IOException, ParseException {
		Scanner in = new Scanner(System.in); //take in the user scanner in as input
		int project_number = 0; // initialise project number
		boolean inputValid = false; //start loop
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
			inputValid = false; //set input valid to falses
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					project_number = Integer.parseInt(input);
					
					//if the project number is greater than number of projects or <=0
					// this is to ensure the user enters a  number in scope of the number of projects available
						//BEGIN: INVALID
					if (project_number > numberOfProjects || project_number <= 0) {
						System.out.println("invalid project number");
						inputValid = false;
					}
						//END: INVALID
					
					//BEGIN: VALID
					else {
						System.out.println("Current name: " + proj.get(project_number-1).contractorName); // current name
						System.out.println("Enter new name");
						newName = in.nextLine(); // take new name
						if (newName.length()== 0) {
							newName = "NULL";
						}
						proj.get(project_number-1).setContractorName(newName);  // update name
						System.out.println("New name: " + proj.get(project_number -1).contractorName); // new name

						System.out.println(
								"Current telephone number: " + proj.get(project_number -1).contractorTelephoneNumber); // current telephone number
						System.out.println("Enter new telephone number");
						newTelephoneNumber = in.nextLine(); //take new telephone number
						if (newTelephoneNumber.length()== 0) {
							newTelephoneNumber = "NULL";
						}
						proj.get(project_number-1).setContractorTelephoneNumber(newTelephoneNumber);  // update telephone number
						System.out.println(
								"New Telephone number: " +  proj.get(project_number-1).contractorTelephoneNumber); // new telephone number

						System.out
						.println("Current email address: " + proj.get(project_number-1).contractorEmailAddress); // current email address
						System.out.println("Enter new email address");
						newEmailAddress = in.nextLine(); // take email address
						if (newEmailAddress.length()== 0) {
							newEmailAddress = "NULL";
						}
						proj.get(project_number-1).setContractorEmailAddress(newEmailAddress); // update email address
						System.out.println("New email address: " + proj.get(project_number-1).contractorEmailAddress); // current email address

						System.out.println(
								"Current physical address: " + proj.get(project_number-1).contractorPhysicalAddress); // current physical address
						System.out.println("Enter new physical address");
						newPhysicalAddress = in.nextLine(); // take new physical address
						if (newPhysicalAddress.length()== 0) {
							newPhysicalAddress = "NULL";
						}
						proj.get(project_number-1).setContractorPhysicalAddress(newPhysicalAddress);  // update pyhsical address
						System.out.println(
								"New physical address: " + proj.get(project_number-1).contractorPhysicalAddress); // new physical address
						saveToFile(proj); // save the updated details 
						break;
					}
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
		

	}
	
	/**
	 * This function allows the user to change the architect details by the project number
	 * @param proj = take in the list of project objects
	 * @param numberOfProjects
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void changeArchitectDetailByProjectNumberFromListOfObjects(List<saveProject> proj,
			int numberOfProjects) throws IOException, ParseException {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
	
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					project_number = Integer.parseInt(input);
					
					//if the project number is greater than number of projects or <=0
					// this is to ensure the user enters a  number in scope of the number of projects available
						//BEGIN: INVALID
					if (project_number > numberOfProjects || project_number <= 0) {
						System.out.println("invalid project number");
						inputValid = false;
					}
						//END: INVALID
					
					//BEGIN: VALID
					else {
						System.out.println("Current name: " + proj.get(project_number-1).architectName); // current name
						System.out.println("Enter new name");
						newName = in.nextLine(); // take new name
						if (newName.length()== 0) {
							newName = "NULL";
						}
						proj.get(project_number-1).setArchitectName(newName);  // update name
						System.out.println("New name: " + proj.get(project_number -1).architectName); // new name

						System.out.println(
								"Current telephone number: " + proj.get(project_number -1).architectTelephoneNumber); // current telephone number
						System.out.println("Enter new telephone number");
						newTelephoneNumber = in.nextLine(); //take new telephone number
						if (newTelephoneNumber.length()== 0) {
							newTelephoneNumber = "NULL";
						}
						proj.get(project_number-1).setArchitectTelephoneNumber(newTelephoneNumber);  // update telephone number
						System.out.println(
								"New Telephone number: " +  proj.get(project_number-1).architectTelephoneNumber); // new telephone number

						System.out
						.println("Current email address: " + proj.get(project_number-1).architectEmailAddress); // current email address
						System.out.println("Enter new email address");
						newEmailAddress = in.nextLine(); // take email address
						if (newEmailAddress.length()== 0) {
							newEmailAddress = "NULL";
						}
						proj.get(project_number-1).setArchitectEmailAddress(newEmailAddress); // update email address
						System.out.println("New email address: " + proj.get(project_number-1).architectEmailAddress); // current email address

						System.out.println(
								"Current physical address: " + proj.get(project_number-1).architectPhysicalAddress); // current physical address
						System.out.println("Enter new physical address");
						newPhysicalAddress = in.nextLine(); // take new physical address
						if (newPhysicalAddress.length()== 0) {
							newPhysicalAddress = "NULL";
						}
						proj.get(project_number-1).setArchitectPhysicalAddress(newPhysicalAddress);  // update pyhsical address
						System.out.println(
								"New physical address: " + proj.get(project_number-1).architectPhysicalAddress); // new physical address
						saveToFile(proj);
						break;
					}
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
		

	}
	
	
	
	/**
	 * This function allows the user to change the customer details by the project number
	 * @param proj = take in the list of project objects
	 * @param numberOfProjects
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void changeCustomerDetailByProjectNumberFromListOfObjects( List<saveProject> proj,
			int numberOfProjects) throws IOException, ParseException {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					project_number = Integer.parseInt(input);
					
					//if the project number is greater than number of projects or <=0
					// this is to ensure the user enters a  number in scope of the number of projects available
						//BEGIN: INVALID
					if (project_number > numberOfProjects || project_number <= 0) {
						System.out.println("invalid project number");
						inputValid = false;
					}
						//END: INVALID
					
					//BEGIN: VALID
					else {
						System.out.println("Current name: " + proj.get(project_number-1).customerName); // current name
						System.out.println("Enter new name");
						newName = in.nextLine(); // take new name
						if (newName.length()== 0) {
							newName = "NULL";
						}
						proj.get(project_number-1).setCustomerName(newName);  // update name
						System.out.println("New name: " + proj.get(project_number -1).customerName); // new name

						System.out.println(
								"Current telephone number: " + proj.get(project_number -1).customerTelephoneNumber); // current telephone number
						System.out.println("Enter new telephone number");
						newTelephoneNumber = in.nextLine(); //take new telephone number
						if (newTelephoneNumber.length()== 0) {
							newTelephoneNumber = "NULL";
						}
						proj.get(project_number-1).setCustomerTelephoneNumber(newTelephoneNumber);  // update telephone number
						System.out.println(
								"New Telephone number: " +  proj.get(project_number-1).customerTelephoneNumber); // new telephone number

						System.out
						.println("Current email address: " + proj.get(project_number-1).customerEmailAddress); // current email address
						System.out.println("Enter new email address");
						newEmailAddress = in.nextLine(); // take email address
						if (newEmailAddress.length()== 0) {
							newEmailAddress = "NULL";
						}
						proj.get(project_number-1).setCustomerEmailAddress(newEmailAddress); // update email address
						System.out.println("New email address: " + proj.get(project_number-1).customerEmailAddress); // current email address

						System.out.println(
								"Current physical address: " + proj.get(project_number-1).customerPhysicalAddress); // current physical address
						System.out.println("Enter new physical address");
						newPhysicalAddress = in.nextLine(); // take new physical address
						if (newPhysicalAddress.length()== 0) {
							newPhysicalAddress = "NULL";
						}
						proj.get(project_number-1).setCustomerPhysicalAddress(newPhysicalAddress);  // update pyhsical address
						System.out.println(
								"New physical address: " + proj.get(project_number-1).customerPhysicalAddress); // new physical address
						saveToFile(proj);
						
						
						break;
					}
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
		

	}
	
	/**
	 * The following function allows the user to finalise a project by using the project number
	 * @param proj   = take in the list of project objects
	 * @param numberOfProjects - take in the number of projects
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void FinaliseProjectByProjectNumber( List<saveProject> proj,
			int numberOfProjects) throws IOException, ParseException {
		Scanner in = new Scanner(System.in);
		int project_number = 0; //init the project number
		boolean inputValid = false; //variable for while loop
		double totalProjectFee = 0d; //total project fee
		double totalAmountPaidToDate = 0d; // total amount due
		double balance = 0d; //total porject balance
		FileWriter finalisedProjectFile = new FileWriter("..\\Poised\\src\\com\\poised\\completedProject.txt",true); // variable for the finalisedProject File i.e. get the file for the finalised project
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //new simple date formatter  
		Date dateCompleted = new Date();  // date completed i.e. date user finalises the project
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					project_number = Integer.parseInt(input);
					
					//if the project number is greater than number of projects or <=0
					// this is to ensure the user enters a  number in scope of the number of projects available
						//BEGIN: INVALID
					if (project_number > numberOfProjects || project_number <= 0) {
						System.out.println("invalid project number");
						inputValid = false;
					}
						//END: INVALID
					
					//BEGIN: VALID
					else {
						totalProjectFee = proj.get(project_number-1).projectPrice; // get the total project fee
						totalAmountPaidToDate = proj.get(project_number-1).projectAmountPaidToDate; // get the total amount paid to date
						balance = totalProjectFee - totalAmountPaidToDate; // calculate the balance
						// if the the balance is greater than 0 then print the invice
						if (balance > 0d) { 
							System.out.println("==========INVOICE FOR: "+ proj.get(project_number-1).projectName +"==========");
							System.out.println("\n");
							System.out.println("Customer Name :" + proj.get(project_number-1).customerName);
							System.out.println("Customer Email :" + proj.get(project_number-1).customerEmailAddress);
							System.out.println("Customer Telephone Number :" + proj.get(project_number-1).customerTelephoneNumber);
							System.out.println("Customer Physical Address :" + proj.get(project_number-1).customerPhysicalAddress);
							System.out.println("Amount To still be paid R" + balance);
							System.out.println("\n");
							//write the detail to the finalised project file including the date completed
							finalisedProjectFile.write(proj.get(project_number-1).projectName + "; "
					    		  	   + proj.get(project_number-1).buildingType + "; "
					    		  	   + proj.get(project_number-1).projectAddress + "; "
					    		  	   + proj.get(project_number-1).erfNumber + "; "
					    		  	   + proj.get(project_number-1).projectPrice + "; "
					    		  	   + proj.get(project_number-1).projectAmountPaidToDate + "; "
					    		  	   + proj.get(project_number-1).deadlineDate + "; "
					    		  	   + proj.get(project_number-1).contractorName + "; "
					    		  	   + proj.get(project_number-1).contractorTelephoneNumber + "; "
					    		  	   + proj.get(project_number-1).contractorEmailAddress + "; "
					    		  	   + proj.get(project_number-1).contractorPhysicalAddress + "; "
					    		  	   + proj.get(project_number-1).architectName+ "; "
					    		  	   + proj.get(project_number-1).architectTelephoneNumber+ "; "
					    		  	   + proj.get(project_number-1).architectEmailAddress + "; "
					    		  	   + proj.get(project_number-1).architectPhysicalAddress + "; "
					    		  	   + proj.get(project_number-1).customerName+ "; "
					    		  	   + proj.get(project_number-1).customerTelephoneNumber + "; "
					    		  	   + proj.get(project_number-1).customerEmailAddress + "; "
					    		  	   + proj.get(project_number-1).customerPhysicalAddress + "; "
									   + formatter.format(dateCompleted));
							finalisedProjectFile.write("\n");
							//close the file
							finalisedProjectFile.close();
							//remove finalised project from the list of projects
							proj.remove(project_number-1);
							//save the updated project details the file that store the current projects
							saveToFile(proj);
						}
						//if the balance is <= 0 we don't generate an invoice
						else if (balance <= 0d) {
							System.out.println("No Invoice to generate as it has been fully paid");
							//write the detail to the finalised project file including the date completed
							finalisedProjectFile.write(proj.get(project_number-1).projectName + "; "
					    		  	   + proj.get(project_number-1).buildingType + "; "
					    		  	   + proj.get(project_number-1).projectAddress + "; "
					    		  	   + proj.get(project_number-1).erfNumber + "; "
					    		  	   + proj.get(project_number-1).projectPrice + "; "
					    		  	   + proj.get(project_number-1).projectAmountPaidToDate + "; "
					    		  	   + proj.get(project_number-1).deadlineDate + "; "
					    		  	   + proj.get(project_number-1).contractorName + "; "
					    		  	   + proj.get(project_number-1).contractorTelephoneNumber + "; "
					    		  	   + proj.get(project_number-1).contractorEmailAddress + "; "
					    		  	   + proj.get(project_number-1).contractorPhysicalAddress + "; "
					    		  	   + proj.get(project_number-1).architectName+ "; "
					    		  	   + proj.get(project_number-1).architectTelephoneNumber+ "; "
					    		  	   + proj.get(project_number-1).architectEmailAddress + "; "
					    		  	   + proj.get(project_number-1).architectPhysicalAddress + "; "
					    		  	   + proj.get(project_number-1).customerName+ "; "
					    		  	   + proj.get(project_number-1).customerTelephoneNumber + "; "
					    		  	   + proj.get(project_number-1).customerEmailAddress + "; "
					    		  	   + proj.get(project_number-1).customerPhysicalAddress + "; "
									   + formatter.format(dateCompleted));
							finalisedProjectFile.write("\n");
							//close the file
							finalisedProjectFile.close();
							//remove finalised project from the list of projects
							proj.remove(project_number-1);
							//save the updated project details the file that store the current projects
							saveToFile(proj);
						}
						
						break;
					}
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
	}


	
	
	
	/**
	 * 
	 * This function allows the user to change the project details by the project number
	 * @param proj = take in the list of project objects
	 * @param numberOfProjects - number of of projects in the list of objects
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void changeProjectDetailByProjectNumberFromListOfObjects(List<saveProject> proj,
			int numberOfProjects) throws IOException, ParseException {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newBuildingType = "";
		String newERFNumber = "";
		String newPhysicalAddress = "";
		double totalFeeForProject = 0;
		double totalFeePaidToDate = 0;
		String userDate = "";
		
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					project_number = Integer.parseInt(input);
					
					//if the project number is greater than number of projects or <=0
					// this is to ensure the user enters a  number in scope of the number of projects available
						//BEGIN: INVALID
					if (project_number > numberOfProjects || project_number <= 0) {
						System.out.println("invalid project number");
						inputValid = false;
					}
						//END: INVALID
					
					//BEGIN: VALID
					else {
						System.out.println("Current name: " + proj.get(project_number-1).projectName); // current name
						System.out.println("Enter new name");
						newName = in.nextLine(); // take new name
						if (newName.length()== 0) {
							newName = "NULL";
						}
						proj.get(project_number-1).setProjectName(newName);  // update name
						System.out.println("New name: " + proj.get(project_number -1).projectName); // new name

						System.out.println(
								"Current Building type: " + proj.get(project_number -1).buildingType); // current telephone number
						System.out.println("Enter new Building type");
						newBuildingType = in.nextLine(); //take new telephone number
						if (newBuildingType.length()== 0) {
							newBuildingType = "NULL";
						}
						proj.get(project_number-1).setBuildingType(newBuildingType);  // update telephone number
						System.out.println(
								"New Building type: " +  proj.get(project_number-1).buildingType); // new telephone number

						System.out.println(
								"Current physical address: " + proj.get(project_number-1).projectAddress); // current physical address
						System.out.println("Enter new physical address");
						newPhysicalAddress = in.nextLine(); // take new physical address
						if (newPhysicalAddress.length()== 0) {
						    newPhysicalAddress = "NULL";
						}
						proj.get(project_number-1).setProjectAddress(newPhysicalAddress);  // update pyhsical address
						System.out.println(
								"New physical address: " + proj.get(project_number-1).projectAddress); // new physical address
						
						
						System.out.println(
								"Current ERF: " + proj.get(project_number-1).erfNumber); // current physical address
						System.out.println("Enter ERF");
						newERFNumber = in.nextLine(); // take new physical address
						if (newERFNumber.length()== 0) {
							newERFNumber = "NULL";
						}
						proj.get(project_number-1).setErfNumber(newERFNumber);  // update pyhsical address
						System.out.println(
								"New ERF: " + proj.get(project_number-1).erfNumber); // new physical address
						
						
						System.out.println("Current total project fee " + proj.get(project_number-1).projectPrice); // current project fee
						System.out.println("Enter total project fee");
						totalFeeForProject = createProjectFee(in,totalFeeForProject, "Total fee for the project e.g. 300.50"); //create total fee for project by calling function create project fee
						proj.get(project_number-1).setProjectPrice(totalFeeForProject);  //update project fee
						System.out.println("New total project fee " + proj.get(project_number-1).projectPrice); //new project fee
						
						
						System.out.println("Current fee paid to date " + proj.get(project_number-1).projectAmountPaidToDate); // current amount paid to date
						System.out.println("Enter total project fee");
						totalFeePaidToDate = createProjectFee(in,totalFeePaidToDate, "Total fee for the project e.g. 300.50"); //create amount paid to date for project by calling function create project fee
						proj.get(project_number-1).setProjectAmountPaidToDate(totalFeePaidToDate);  //update amount paid to date
						System.out.println("New fee paid to date " + proj.get(project_number-1).projectAmountPaidToDate);  //new amount paid to date
						
						System.out.println("Current deadline" + proj.get(project_number-1).deadlineDate); // current deadline date
						userDate = createProjectDueDate(in); // new deadline date by calling create project due date function
						proj.get(project_number-1).setDeadlineDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate));  //set new project date
						System.out.println("New deadline" + proj.get(project_number-1).deadlineDate); //new project date
						saveToFile(proj); //write details to current project file
						break;
					}
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
	

	}
	

	
    /**
     * This function allows the user to change the project details by the project name
	 * @param proj = take in the list of project objects
	 * @param numberOfProjects - number of of projects in the list of objects
     * @param projectNames
     * @throws IOException
     * @throws ParseException
     */
	public static void changeContractorsDetailByProjectNameFromListOfObjects( List<saveProject> proj,
			int numberOfProjects, String[] projectNames) throws IOException, ParseException {
		Scanner in = new Scanner(System.in); //scanner for input
		boolean inputValid = false; 
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project Name ");
				//take user input
				String input = in.nextLine();
				
				//if the project names of array contains the user input
				if (Arrays.asList(projectNames).contains(input)) {
					for (int i = 0; i < proj.size(); i++) {
						if (proj.get(i).projectName.equals(input)) {

							System.out.println("Current name: " + proj.get(i).contractorName); // current name
							System.out.println("Enter new name");
							newName = in.nextLine(); // take new name
							if (newName.length()== 0) {
								newName = "NULL";
							}
							proj.get(i).setContractorName(newName);  // update name
							System.out.println("New name: " + proj.get(i).contractorName); // new name

							System.out.println(
									"Current telephone number: " + proj.get(i).contractorTelephoneNumber); // current telephone number
							System.out.println("Enter new telephone number");
							newTelephoneNumber = in.nextLine(); //take new telephone number
							if (newTelephoneNumber.length()== 0) {
								newTelephoneNumber = "NULL";
							}
							proj.get(i).setContractorTelephoneNumber(newTelephoneNumber);  // update telephone number
							System.out.println(
									"New Telephone number: " +  proj.get(i).contractorTelephoneNumber); // new telephone number

							System.out
							.println("Current email address: " + proj.get(i).contractorEmailAddress); // current email address
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine(); // take email address
							if (newEmailAddress.length()== 0) {
								newEmailAddress = "NULL";
							}
							proj.get(i).setContractorEmailAddress(newEmailAddress); // update email address
							System.out.println("New email address: " + proj.get(i).contractorEmailAddress); // current email address

							System.out.println(
									"Current physical address: " + proj.get(i).contractorPhysicalAddress); // current physical address
							System.out.println("Enter new physical address");
							newPhysicalAddress = in.nextLine(); // take new physical address
							if (newPhysicalAddress.length()== 0) {
							    newPhysicalAddress = "NULL";
							}
							proj.get(i).setContractorPhysicalAddress(newPhysicalAddress);  // update pyhsical address
							System.out.println(
									"New physical address: " + proj.get(i).contractorPhysicalAddress); // new physical address
							saveToFile(proj);
						}
					}
					break;
				} 
				// if incorrect project name entered
				else {
					System.out.println("Incorrect project name enter a valid project name");
					inputValid = false;
				}

			}
	

	}
	
	

    /**
     * This function allows the user to change the architect details by the project name
	 * @param proj = take in the list of project objects
	 * @param numberOfProjects - number of of projects in the list of objects
     * @param projectNames
     * @throws IOException
     * @throws ParseException
     */
	public static void changeArchitectDetailByProjectNameFromListOfObjects(List<saveProject> proj,
			int numberOfProjects, String[] projectNames) throws IOException, ParseException {
		Scanner in = new Scanner(System.in); //scanner for input
		boolean inputValid = false; 
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";

			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project Name ");
				//take user input
				String input = in.nextLine();
				
				//if the project names of array contains the user input
				if (Arrays.asList(projectNames).contains(input)) {
					for (int i = 0; i < proj.size(); i++) {
						if (proj.get(i).projectName.equals(input)) {

							System.out.println("Current name: " + proj.get(i).architectName); // current name
							System.out.println("Enter new name");
							newName = in.nextLine(); // take new name
							if (newName.length()== 0) {
								newName = "NULL";
							}
							proj.get(i).setArchitectName(newName);  // update name
							System.out.println("New name: " + proj.get(i).architectName); // new name

							System.out.println(
									"Current telephone number: " + proj.get(i).architectTelephoneNumber); // current telephone number
							System.out.println("Enter new telephone number");
							newTelephoneNumber = in.nextLine(); //take new telephone number
							if (newTelephoneNumber.length()== 0) {
								newTelephoneNumber = "NULL";
							}
							proj.get(i).setArchitectTelephoneNumber(newTelephoneNumber);  // update telephone number
							System.out.println(
									"New Telephone number: " +  proj.get(i).architectTelephoneNumber); // new telephone number

							System.out
							.println("Current email address: " + proj.get(i).architectEmailAddress); // current email address
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine(); // take email address
							if (newEmailAddress.length()== 0) {
								newEmailAddress = "NULL";
							}
							proj.get(i).setArchitectEmailAddress(newEmailAddress); // update email address
							System.out.println("New email address: " + proj.get(i).architectEmailAddress); // current email address

							System.out.println(
									"Current physical address: " + proj.get(i).architectPhysicalAddress); // current physical address
							System.out.println("Enter new physical address");
							newPhysicalAddress = in.nextLine(); // take new physical address
							if (newPhysicalAddress.length()== 0) {
								newPhysicalAddress = "NULL";
							}
							proj.get(i).setArchitectPhysicalAddress(newPhysicalAddress);  // update pyhsical address
							System.out.println(
									"New physical address: " + proj.get(i).architectPhysicalAddress); // new physical address
							saveToFile(proj);
						}
					}
					break;
				} 
				// if incorrect project name entered
				else {
					System.out.println("Incorrect project name enter a valid project name");
					inputValid = false;
				}

			}


	}
	
	

    /**
     * This function allows the user to change the customer details by the project name
	 * @param proj = take in the list of project objects
	 * @param numberOfProjects - number of of projects in the list of objects
     * @param projectNames
     * @throws IOException
     * @throws ParseException
     */
	public static void changeCustomerDetailByProjectNameFromListOfObjects(List<saveProject> proj,
			int numberOfProjects, String[] projectNames) throws IOException, ParseException {
		Scanner in = new Scanner(System.in); //scanner for input
		boolean inputValid = false; 
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
	
	
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project Name ");
				//take user input
				String input = in.nextLine();
				
				//if the project names of array contains the user input
				if (Arrays.asList(projectNames).contains(input)) {
					for (int i = 0; i < proj.size(); i++) {
						if (proj.get(i).projectName.equals(input)) {

							System.out.println("Current name: " + proj.get(i).customerName); // current name
							System.out.println("Enter new name");
							newName = in.nextLine(); // take new name
							if (newName.length()== 0) {
								newName = "NULL";
							}
							proj.get(i).setCustomerName(newName);  // update name
							System.out.println("New name: " + proj.get(i).customerName); // new name

							System.out.println(
									"Current telephone number: " + proj.get(i).customerTelephoneNumber); // current telephone number
							System.out.println("Enter new telephone number");
							newTelephoneNumber = in.nextLine(); //take new telephone number
							if (newTelephoneNumber.length()== 0) {
								newTelephoneNumber = "NULL";
							}
							proj.get(i).setCustomerTelephoneNumber(newTelephoneNumber);  // update telephone number
							System.out.println(
									"New Telephone number: " +  proj.get(i).customerTelephoneNumber); // new telephone number

							System.out
							.println("Current email address: " + proj.get(i).customerEmailAddress); // current email address
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine(); // take email address
							newEmailAddress = in.nextLine(); //take new telephone number
							if (newEmailAddress.length()== 0) {
								newEmailAddress = "NULL";
							}
							proj.get(i).setCustomerEmailAddress(newEmailAddress); // update email address
							System.out.println("New email address: " + proj.get(i).customerEmailAddress); // current email address

							System.out.println(
									"Current physical address: " + proj.get(i).customerPhysicalAddress); // current physical address
							System.out.println("Enter new physical address");
							newPhysicalAddress = in.nextLine(); // take new physical address
							if (newPhysicalAddress.length()== 0) {
								newPhysicalAddress = "NULL";
							}
							proj.get(i).setCustomerPhysicalAddress(newPhysicalAddress);  // update pyhsical address
							System.out.println(
									"New physical address: " + proj.get(i).customerPhysicalAddress); // new physical address
							saveToFile(proj);
						}
					}
					break;
				} 
				// if incorrect project name entered
				else {
					System.out.println("Incorrect project name enter a valid project name");
					inputValid = false;
				}

			}

	}
	
	
	
	
	
	/**
	 * The following function allows the user to finalise a project by using the project name
	 * @param proj   = take in the list of project objects
	 * @param numberOfProjects - take in the number of projects
	 * @param projectNames - array of project names
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void FinaliseProjectByProjectName(List<saveProject> proj,
			int numberOfProjects, String[] projectNames) throws IOException, ParseException {
		Scanner in = new Scanner(System.in); //scanner for input
		boolean inputValid = false; 
		double totalProjectFee = 0d; //total project fee
		double totalAmountPaidToDate = 0d; // total amount due
		double balance = 0d; //total porject balance
		FileWriter finalisedProjectFile = new FileWriter("..\\Poised\\src\\com\\poised\\completedProject.txt",true); // variable for the finalisedProject File i.e. get the file for the finalised project
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  //new simple date formatter 
		Date dateCompleted = new Date();  // date completed i.e. date user finalises the project
	
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project Name ");
				//take user input
				String input = in.nextLine();
				
				//if the project names of array contains the user input
				if (Arrays.asList(projectNames).contains(input)) {
					for (int i = 0; i < proj.size(); i++) {
						if (proj.get(i).projectName.equals(input)) {
							totalProjectFee = proj.get(i).projectPrice; // get the total project fee
							totalAmountPaidToDate = proj.get(i).projectAmountPaidToDate; // get the total amount paid to date
							balance = totalProjectFee - totalAmountPaidToDate; // calculate the balance
							// if the the balance is greater than 0 then print the invice
							if (balance > 0d) {
								System.out.println("==========INVOICE FOR: "+ proj.get(i).projectName +"==========");
								System.out.println("\n");
								System.out.println("Customer Name :" + proj.get(i).customerName);
								System.out.println("Customer Email :" + proj.get(i).customerEmailAddress);
								System.out.println("Customer Telephone Number :" + proj.get(i).customerTelephoneNumber);
								System.out.println("Customer Physical Address :" + proj.get(i).customerPhysicalAddress);
								System.out.println("Amount To still be paid R" + balance);
								System.out.println("\n");
								finalisedProjectFile.write(proj.get(i).projectName + "; "
						    		  	   + proj.get(i).buildingType + "; "
						    		  	   + proj.get(i).projectAddress + "; "
						    		  	   + proj.get(i).erfNumber + "; "
						    		  	   + proj.get(i).projectPrice + "; "
						    		  	   + proj.get(i).projectAmountPaidToDate + "; "
						    		  	   + proj.get(i).deadlineDate + "; "
						    		  	   + proj.get(i).contractorName + "; "
						    		  	   + proj.get(i).contractorTelephoneNumber + "; "
						    		  	   + proj.get(i).contractorEmailAddress + "; "
						    		  	   + proj.get(i).contractorPhysicalAddress + "; "
						    		  	   + proj.get(i).architectName+ "; "
						    		  	   + proj.get(i).architectTelephoneNumber+ "; "
						    		  	   + proj.get(i).architectEmailAddress + "; "
						    		  	   + proj.get(i).architectPhysicalAddress + "; "
						    		  	   + proj.get(i).customerName+ "; "
						    		  	   + proj.get(i).customerTelephoneNumber + "; "
						    		  	   + proj.get(i).customerEmailAddress + "; "
						    		  	   + proj.get(i).customerPhysicalAddress + "; "
										   + formatter.format(dateCompleted));
								finalisedProjectFile.write("\n");
								//close the file
								finalisedProjectFile.close();
								//remove finalised project from the list of projects
								proj.remove(i);
								//save the updated project details the file that store the current projects
								saveToFile(proj);
							}
							//if the balance is <= 0 we don't generate an invoice
							else if (balance <= 0d) {
								System.out.println("No Invoice to generate as it has been fully paid");
								//write the detail to the finalised project file including the date completed
								finalisedProjectFile.write(proj.get(i).projectName + "; "
						    		  	   + proj.get(i).buildingType + "; "
						    		  	   + proj.get(i).projectAddress + "; "
						    		  	   + proj.get(i).erfNumber + "; "
						    		  	   + proj.get(i).projectPrice + "; "
						    		  	   + proj.get(i).projectAmountPaidToDate + "; "
						    		  	   + proj.get(i).deadlineDate + "; "
						    		  	   + proj.get(i).contractorName + "; "
						    		  	   + proj.get(i).contractorTelephoneNumber + "; "
						    		  	   + proj.get(i).contractorEmailAddress + "; "
						    		  	   + proj.get(i).contractorPhysicalAddress + "; "
						    		  	   + proj.get(i).architectName+ "; "
						    		  	   + proj.get(i).architectTelephoneNumber+ "; "
						    		  	   + proj.get(i).architectEmailAddress + "; "
						    		  	   + proj.get(i).architectPhysicalAddress + "; "
						    		  	   + proj.get(i).customerName+ "; "
						    		  	   + proj.get(i).customerTelephoneNumber + "; "
						    		  	   + proj.get(i).customerEmailAddress + "; "
						    		  	   + proj.get(i).customerPhysicalAddress + "; "
										   + formatter.format(dateCompleted));
								finalisedProjectFile.write("\n");
								//close the file
								finalisedProjectFile.close();
								//remove finalised project from the list of projects
								proj.remove(i);
								//save the updated project details the file that store the current projects
								saveToFile(proj);
							}
						}
					}
					break;
				} 
				// if incorrect project name entered
				else {
					System.out.println("Incorrect project name enter a valid project name");
					inputValid = false;
				}

			}

	}
	
	
	
	
	/**
	 * Function to change the project details by the the project name
	 * @param proj - list of projects from object
	 * @param numberOfProjects - number of projects
	 * @param projectNames - array to store name of projects
	 * @throws IOException 
	 * @throws ParseException
	 */
	public static void changeProjectDetailByProjectNameFromListOfObjects(List<saveProject> proj,
			int numberOfProjects, String[] projectNames) throws IOException, ParseException {
		Scanner in = new Scanner(System.in); //scanner for input
		boolean inputValid = false; 
		String newName = "";
		String newBuildingType = "";
		String newERFNumber = "";
		String newPhysicalAddress = "";
		double totalFeeForProject = 0;
		double totalFeePaidToDate = 0;
		String userDate = "";
	
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project Name ");
				//take user input
				String input = in.nextLine();
				
				//if the project names of array contains the user input
				if (Arrays.asList(projectNames).contains(input)) {
					for (int i = 0; i < proj.size(); i++) {
						if (proj.get(i).projectName.equals(input)) {

			                System.out.println("Current name: " + proj.get(i).projectName); // current name
			                System.out.println("Enter new name");
			                newName = in.nextLine(); // take new name
			                if (newName.length()== 0) {
			                	newName = "NULL";
			                }
			                proj.get(i).setProjectName(newName);  // update name
			                System.out.println("New name: " + proj.get(i).projectName); // new name

			                System.out.println(
			                        "Current Building type: " + proj.get(i).buildingType); // current telephone number
			                System.out.println("Enter new Building type");
			                newBuildingType = in.nextLine(); //take new telephone number
			                if (newBuildingType.length()== 0) {
			                	newBuildingType = "NULL";
			                }
			                proj.get(i).setBuildingType(newBuildingType);  // update telephone number
			                System.out.println(
			                        "New Building type: " +  proj.get(i).buildingType); // new telephone number

			                System.out.println(
			                        "Current physical address: " + proj.get(i).projectAddress); // current physical address
			                System.out.println("Enter new physical address");
			                newPhysicalAddress = in.nextLine(); // take new physical address
			                if (newPhysicalAddress.length()== 0) {
			                	newPhysicalAddress = "NULL";
			                }
			                proj.get(i).setProjectAddress(newPhysicalAddress);  // update pyhsical address
			                System.out.println(
			                        "New physical address: " + proj.get(i).projectAddress); // new physical address
			                
			                
			                System.out.println(
			                        "Current ERF: " + proj.get(i).erfNumber); // current physical address
			                System.out.println("Enter ERF");
			                newERFNumber = in.nextLine(); // take new physical address
			                if (newERFNumber.length()== 0) {
			                	newERFNumber = "NULL";
			                }
			                proj.get(i).setErfNumber(newERFNumber);  // update pyhsical address
			                System.out.println(
			                        "New ERF: " + proj.get(i).erfNumber); // new physical address
			                
			                
			                System.out.println("Current total project fee " + proj.get(i).projectPrice);
			                System.out.println("Enter total project fee");
			                totalFeeForProject = createProjectFee(in,totalFeeForProject, "Total fee for the project e.g. 300.50");
			                proj.get(i).setProjectPrice(totalFeeForProject);  
			                System.out.println("New total project fee " + proj.get(i).projectPrice);
			                
			                
			                System.out.println("Current fee paid to date " + proj.get(i).projectAmountPaidToDate);
			                System.out.println("Enter total project fee");
			                totalFeePaidToDate = createProjectFee(in,totalFeePaidToDate, "Total fee for the project e.g. 300.50");
			                proj.get(i).setProjectAmountPaidToDate(totalFeePaidToDate);  
			                System.out.println("New fee paid to date " + proj.get(i).projectAmountPaidToDate);
			                
			                System.out.println("Current deadline" + proj.get(i).deadlineDate);
			                userDate = createProjectDueDate(in);
			                proj.get(i).setDeadlineDate(new SimpleDateFormat("dd/MM/yyyy").parse(userDate));  
			                System.out.println("New deadline" + proj.get(i).deadlineDate);
			              //save the updated project details the file that store the current projects
			                saveToFile(proj); 
						}
					}
					break;
				} 
				// if incorrect project name entered
				else {
					System.out.println("Incorrect project name enter a valid project name");
					inputValid = false;
				}

			}

	}
	
	

	
	/*
	 * Function to create a project due date
	 * @param in
	 */
	public static String createProjectDueDate(Scanner in) {
		boolean inputValid; // boolean for inputValid
		inputValid = false; // set to false
		String userDate = ""; // set user date
		//while not inputValid
		while (!inputValid) {
			//create Simple date format with dd/MM/yyyy
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			//setLenient handle when the user enters incorrect details
			sdf.setLenient(false);
			System.out.println("Please enter a date e.g (23/05/1993)");
			//take user date from input
			userDate = in.nextLine();
			
			try {
				sdf.parse(userDate); //parse the userDate variable
				System.out.println(userDate + " is a valid Date");
				return userDate;
				//catch when date is invalid
			} catch (Exception e) {
				System.out.println(userDate + " is not a valid Date");
				inputValid = false;
			}
		}
		return userDate;
	}
	
	/**
	 * Function to save to file of current projects
	 * @param proj - list of objects for projects
	 * @throws IOException
	 */
	private static void saveToFile(List<saveProject> proj) throws IOException {
		FileWriter writeToFileOfCurrentProjects = new FileWriter("..\\Poised\\src\\com\\poised\\savedProjects.txt");
		 for (int i = 0; i < proj.size(); i++) {
			   try {
				   writeToFileOfCurrentProjects.write(proj.get(i).projectName + "; "
				    		  	   + proj.get(i).buildingType + "; "
				    		  	   + proj.get(i).projectAddress + "; "
				    		  	   + proj.get(i).erfNumber + "; "
				    		  	   + proj.get(i).projectPrice + "; "
				    		  	   + proj.get(i).projectAmountPaidToDate + "; "
				    		  	   + proj.get(i).deadlineDate + "; "
				    		  	   + proj.get(i).contractorName + "; "
				    		  	   + proj.get(i).contractorTelephoneNumber + "; "
				    		  	   + proj.get(i).contractorEmailAddress + "; "
				    		  	   + proj.get(i).contractorPhysicalAddress + "; "
				    		  	   + proj.get(i).architectName+ "; "
				    		  	   + proj.get(i).architectTelephoneNumber+ "; "
				    		  	   + proj.get(i).architectEmailAddress + "; "
				    		  	   + proj.get(i).architectPhysicalAddress + "; "
				    		  	   + proj.get(i).customerName+ "; "
				    		  	   + proj.get(i).customerTelephoneNumber + "; "
				    		  	   + proj.get(i).customerEmailAddress + "; "
				    		  	   + proj.get(i).customerPhysicalAddress);
				   writeToFileOfCurrentProjects.write("\n");
				    } catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
		 }
		 writeToFileOfCurrentProjects.close();
	}

}
	
