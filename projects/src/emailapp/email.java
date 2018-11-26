package emailapp;

import java.util.Scanner;

public class email {
	private String firstName;
	private String lastName;
	private String fullName = (firstName + lastName);
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 256;
	private String alternateEmail;
	private String companySuffix = "abcompany.com";
	
	
	//constructor to get name
	
	public email(String firstName, String lastName) {
		
		this.fullName = setName();
		System.out.println("\n");
		
		//method to get department
		this.department = setDepartment();
		System.out.println("\nDepartment set to: " + this.department + "\n");
		
		
			
		//method for password  unnecessarily long and split by 16 char per line
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is:");
		
	   
		int x = 0;
	   	int y = password.length() / 16;	   

	   	while (y < 257) {
	
	   System.out.print(this.password.substring(x,y) + "\n");
		y+=password.length() / 16;
		x+=password.length() / 16;
	   		}
	   	
	   	
		//combine elements to generate email
		email = fullName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your email is: " + email);
		
	}
	
	
	//method to set department code
	
	private String setDepartment() {
		System.out.print("Department Codes Below \n1 for Sales\n2 for Development\n3 for Acounting\n0 for None\nEnter deparment code: ");
		Scanner ain = new Scanner(System.in);
		int depChoice = ain.nextInt();
		if (depChoice == 1) {
			return "sales"; 
		}
		else if (depChoice == 2) {
			return "dev";
		}
		else if (depChoice == 3) {
			return "acct";
		}
		
		else {
			return "";
				}
			
		}
	
	//Method to get firstName and lastName
	
	//first name
	private String setName() {
	System.out.print("Please enter your first name: "); 
	Scanner first1 = new Scanner(System.in);
	firstName = first1.nextLine();
	
	//last name
	System.out.print("Please enter your last name: "); 
	Scanner last1 = new Scanner(System.in);
	lastName = last1.nextLine();
	if (firstName.length() > 0) {
		
		fullName = firstName + "." + lastName;
		
		return new String(fullName);
	}
		
		else {
			return "failure";
		}
		
	}
	
	
	//method to create password
		
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNO!@#$%^&*PQRSTUVWXYZabcdefghijkl!@#$%^&*mnopqrstuvwxyz0123456789!@#$%^&*";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);	
			//System.out.println(passwordSet.charAt(rand));
			
		}
		
		return new String(password);
		
	}
	
	
	//mail capacity
	public void setMailboxCapacity(int capacity){
		
	this.mailboxCapacity = capacity;
	}
	
	//set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//change password
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapcity() {
		return mailboxCapacity;		
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}
	
	// use of System.lineSeparator() to show \n and line separators work
	
	public String showInfo() {
		return "\nDisplay name: " + firstName + " " + lastName + System.lineSeparator() 
		+ "Company Email: " + email +  System.lineSeparator() 
		+ "Mailbox Capacity: " + mailboxCapacity + "MB";
	}
	
}
