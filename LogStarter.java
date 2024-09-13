import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogStarter {
    public static void main(String[] args) {
        Person personObj = new Person();
        personObj.initialGreeting();
        personObj.getStringInfo();
        personObj.getIntInfo();
        personObj.printAndDisplayInfo();
    }
}
