import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
    String firstName;
    String lastName;
    int monthOfBirth;
    int yearOfBirth;
    int dayOfBirth;
    String classId;


    public void initialGreeting(){
        Scanner scanObj = new Scanner(System.in);
        System.out.println("This is the log file starter.\nHere you can input your basic information and start up a log file for yourself!");
        System.out.println("Press enter to continue...");
        scanObj.nextLine();
    }

    public void getStringInfo(){
        boolean firstTwoValid;
        boolean lastFourValid = false;
        Scanner scanObj = new Scanner(System.in);
        System.out.println("Now for the basic information.\nPlease enter your name and DOB:");
        System.out.println("First name: ");
        firstName = scanObj.next();

        System.out.println("Last name: ");
        lastName = scanObj.next();

        scanObj.nextLine();

        System.out.println("Class ID: ");
        do{
            System.out.println("Please enter a valid Class id the first two characters must be letters then a space followed by four numbers");
            classId = scanObj.nextLine();
            if(classId.length() != 7){
                firstTwoValid = false;

                continue;
            }
            firstTwoValid = Character.isLetter(classId.charAt(0)) && Character.isLetter(classId.charAt(1));
            lastFourValid = Character.isDigit(classId.charAt(3)) && Character.isDigit(classId.charAt(4)) && Character.isDigit(classId.charAt(5)) && Character.isDigit(classId.charAt(6));
        } while(!firstTwoValid || classId.charAt(2) != ' ' || !lastFourValid);
    }
    public void getIntInfo(){
        System.out.println("Month of birth: ");
        scanMonth();

        System.out.println("Year of Birth: ");
        scanYear();

        System.out.println("Day of Birth: ");
        scanDay();
    }


    public void printAndDisplayInfo(){
        String dob = monthOfBirth + "/" + dayOfBirth + "/" + yearOfBirth;
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




    public void scanMonth(){// info int is a problem ebcause it doesn't actually change whatever is in it.
        Scanner scanObj = new Scanner(System.in);
        boolean flag = false;
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
    }

    public void scanDay(){// info int is a problem ebcause it doesn't actually change whatever is in it.
        Scanner scanObj = new Scanner(System.in);
        boolean flag = false;
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
    }

    public void scanYear(){// info int is a problem because it doesn't actually change whatever is in it.
        Scanner scanObj = new Scanner(System.in);
        boolean flag = false;
        do{
            try {
                yearOfBirth = scanObj.nextInt();
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanObj.nextLine();
                continue;
            }
            if(yearOfBirth < 1900 || yearOfBirth> 2024){
                flag = false;
                System.out.println("Please enter a number between 1900-2024");
            }
        } while (!flag);
    }
}

