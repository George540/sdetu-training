package Labs;


public class StudentDatabase {

	public static void main(String[] args) throws java.io.IOException{
		StudentAccount s1 = new StudentAccount("George", "Mavroeidis", "47829845", 5000);
        
		s1.setCity("Athens");
        s1.setPhone("514 978 6561");
        s1.setState("Attiki");
        s1.setCountry("Greece");
        System.out.println();
        System.out.println();        
        System.out.println();
        System.out.println();
        
        // s1.showCourses();
        s1.enroll("Object Oriented Programming I");
        s1.enroll("Data Structures and Algorithms");
        s1.enroll("Computer Graphics");
        s1.enroll("Introduction to Game Development");
        s1.enroll("Animation for Video Games");
        System.out.println(s1.toString());
        s1.pay(3000);
	}
	}

class StudentAccount {
	// Properties of student account
	private String firstName;
	private String lastName;
    private String SSN;
	private static int ID = 1000;
    private String phone;
    private String email;
    private String city;
    private String state;
    private String country;
    private String userID;
    private int balance = 0;
    private String courses = "";
    private static final int costOfCourse = 800;

public StudentAccount(String firstName, String lastName, String SSN, int initDeposit) {
	balance = (int) initDeposit;
    this.SSN = SSN;
    this.firstName = firstName;
    this.lastName = lastName;
    this.firstName.toString();
    email = firstName.toLowerCase().charAt(0) + "." + lastName.toLowerCase() + "@hotmail.com";
    System.out.println("Your email address is: " + email);
    ID++;
    setUserId();
}

private void setUserId(){
	// Generate number between range 1000-9000
	int max = 9000;
	int min = 1000;
	int randomNumber = (int) (Math.random() * ((max - min)));
	randomNumber = randomNumber + min;
	userID = ID + "" + randomNumber + "" + SSN.substring(6);
    System.out.println("Your user ID is: " + userID);
}

public void setPhone(String phone){
    this.phone = phone;
}

public void setCity(String city) {
    this.city = city;
}
public void setState(String state) {
    this.state = state;
}
public void setCountry(String country) {
    this.country = country;
}

public void pay(int amount){
    balance -= amount;
    System.out.println("Paying monthly student fee of: " + amount);
    checkBalance();
}

public void checkBalance(){
    System.out.println("Current Balance: " + balance);
}

public void enroll(String course){
    this.courses = this.courses + "\n" + course;
    balance = balance + costOfCourse;
}

@Override
public String toString(){
	return "[Name: " + firstName + "" + lastName + "]\n[Email: " + email + "]\n[Place of birth: " + city + ", " + state + ", " + country + "]\n[Phone number: " + phone + "]\n[Initial Deposit: " + balance + "]\n\n[Courses Taken: " + courses + " ]\n" + "";
}
}



