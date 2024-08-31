import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogStarter {
    public static void main(String[] args) {
        String firstName;
        String lastName;
        // Date will be initialized later
        int monthOfBirth=0;
        int yearOfBirth=0;
        int dayOfBirth=0;
        String dob;
        boolean flag = false;
        String classId;


        Scanner scanObj = new Scanner(System.in);
        System.out.println("This is the log file starter.\nHere you can input your basic information and start up a log file for yourself");
        System.out.println("Press enter to continue...");
        scanObj.nextLine();
        System.out.println("Now for the basic information.\nPlease enter your name and DOB:");

        System.out.println("First name: ");
        firstName = scanObj.next();

        System.out.println("Last name: ");
        lastName = scanObj.next();

        System.out.println("Class ID: ");
        scanObj.nextLine();
        classId = scanObj.nextLine();


        System.out.println("Month of birth: ");
        do{
            try {
                monthOfBirth = scanObj.nextInt();
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanObj.nextLine();
                continue;
            }
            if(monthOfBirth < 1 || monthOfBirth > 12){
                flag = false;
                System.out.println("Please enter a number between 1-12");
            }
        } while (!flag);
        flag = false;          // Setting the flag = to false after using it for later use

        System.out.println("Year of Birth: ");
        do{
            try {
                yearOfBirth = scanObj.nextInt();
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanObj.nextLine();
                continue;
            }
            if(yearOfBirth < 1900 || yearOfBirth > 2024){
                flag = false;
                System.out.println("Please enter a number between 1900-2024");
            }
        } while (!flag);
        flag = false;          // Setting the flag = to false after using it for later use


        System.out.println("Day of Birth: ");
        do{
            try {
                dayOfBirth = scanObj.nextInt();
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanObj.nextLine();
                continue;
            }
            if(dayOfBirth < 1 || dayOfBirth > 30){
                flag = false;
                System.out.println("Please enter a number between 1-30");
            }
        } while (!flag);

        dob = monthOfBirth + "/" + dayOfBirth + "/" + yearOfBirth;
        System.out.println(firstName + " " + lastName + " was born on " + dob);
        System.out.println("Class Id: " + classId);







        try(PrintWriter writer = new PrintWriter(lastName+firstName+"Log.csv")){
            writer.println(lastName + "," + firstName + "\n" + classId);  //This makes the format of the file x then the coefficients proceed after it
            writer.println("Date, StartTime, EndTime, HowManyPeople, ActivityCode, Notes");
            writer.flush();
//            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
