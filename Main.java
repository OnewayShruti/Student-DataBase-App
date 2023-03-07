package Student_Database_App;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

//        get students count
        System.out.print("Enter the number of students to add in DB : " );
        int studentCount = userInput.nextInt();
        
//        create array of objects for studentInfo type 
        StudentInfo[] studentArray = new StudentInfo[studentCount];
        
        for (int iterator = 0; iterator < studentCount; iterator++) {
            studentArray[iterator] = new StudentInfo();
        }
//       display all details
        for (StudentInfo element:studentArray) {
            System.out.println(element.display());
        }
//        studentArray[]
    }
}
