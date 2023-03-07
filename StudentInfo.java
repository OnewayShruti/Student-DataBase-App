package Student_Database_App;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentInfo {
    private String  courseEnrollment ;
    private String firstName;
    private String lastName;
    private String collegeYear;
    private String studentID;
    private int courseCost = 600;
    private int balance;
    private int payment;
    private int TotalCourseCost = 0;
    private static int uniqueID = 1000;
    private int studentCount;



    public StudentInfo(){
        this.firstName = getFirstName();
        this.lastName = getLastName();
        this.collegeYear = getCollegeYear();
        this.studentID = getStudentID();
        this.courseEnrollment = getCourseEnrollment();
        this.balance =balancePayment();
    }
    ArrayList<String> coursesEnrolled = new ArrayList<>(5);
    Scanner userInput = new Scanner(System.in);
//  get no of objects to create
    public int getStudentCount() {
        System.out.print("Enter the number of students to add in DB : " );
        studentCount = userInput.nextInt();
        return studentCount;
    }
    public String getFirstName(){
        System.out.print("Enter firstName : ");
        firstName = userInput.next();
        return firstName;
    }
    public String getLastName(){
        System.out.print("Enter lastName : ");
        lastName = userInput.next();
        return lastName;
    }
    public String getCollegeYear(){
        System.out.println("a -> F.E\nb -> S.E\nc -> T.E\nd -> B.E");
        System.out.print("Enter a valid year : ");
        collegeYear = userInput.next();

        switch (collegeYear){
            case "a" : {
                collegeYear = "FE";
                break;
            }
            case "b" : {
                collegeYear = "SE";
                break;
            }
            case "c" : {
                collegeYear = "TE";
                break;
            }
            case "d" : {
                collegeYear = "BE";
                break;
            }
            default: {
                collegeYear = "invalid";
                break;
            }
        }
        return collegeYear;
    }
    public String getCourseEnrollment() {
        boolean answer;
        do {
            System.out.println("a -> History 101\nb -> Mathematics 101\nc -> English 101\nd -> Chemistry 101\ne -> Computer Science 101");
            System.out.print("Select course for enrollment : ");
            courseEnrollment = userInput.next();
            switch (courseEnrollment) {
                case "a": {
                    courseEnrollment = "History 101";
                    break;
                }
                case "b": {
                    courseEnrollment = "Mathematics 101";
                    break;
                }
                case "c": {
                    courseEnrollment = "English 101";
                    break;
                }
                case "d": {
                    courseEnrollment = "Chemistry 101";
                    break;
                }
                case "e": {
                    courseEnrollment = "Computer Science 101";
                    break;
                }
                default: {
                    System.out.println("Invalid Course selection");
                    break;
                }
            }
            this.coursesEnrolled.add(this.courseEnrollment);
            this.TotalCourseCost += this.courseCost;
            System.out.print("select 1 for futher enrollments and 0 to quit : ");
            int response = userInput.nextInt();
            answer = response == 1 ? true : false;
        } while(answer);
        return courseEnrollment;
    }
    public String getStudentID(){
        uniqueID++;
        return collegeYear + "" + uniqueID;
    }
    public int balancePayment(){
        System.out.print("Enter your amount to pay : " );
        payment = userInput.nextInt();
        this.balance = this.TotalCourseCost - payment;
        return this.balance;
    }

    public String display(){
        return "\n###################################\n" + "\nName : " + this.firstName + " " +
                this.lastName + "\nCollege Year : " + this.collegeYear + "\nStudent ID : " +
                this.studentID + "\nCourses Enrolled : " + this.coursesEnrolled.toString() +
                "\nTotal cost of enrolled courses : " + this.TotalCourseCost +
                "\nBalance payment : " + this.balance + "\n";
    }
}
// can we parse string to int & vice-versa
// debug while loop and check y its not running?

//creating static members allows to be independent of all objects & true for all objects of the class

//can add validations & checking for : [exception handing + edge cases]
// cannot enroll in same course twice
// balance must not be -ve
// max courses allowed is 5