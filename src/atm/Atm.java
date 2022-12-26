package atm;

import java.util.Scanner;
import atmOperation.Operation;
import user.User;

public class Atm {
  public static Scanner in = new Scanner(System.in);
  public static DatabaseHandler db = new DatabaseHandler();
  public static void main(String[] args) {
    while (true) {
      System.out.println("Welcome to the ATM Machine!!");
      System.out.println("Enter your account number: ");
      int accNo = in.nextInt();
      System.out.println("Enter your pin number: ");
      int pin = in.nextInt();
      User user = db.userExist(accNo, pin,"checking_account");

      if (user != null) {
        while (true) {
          
          System.out.println("Select the account you want to access: ");
          System.out.println("Type 1 - Checking Account\nType 2 - Saving Account\nType 3 - Exit");
          System.out.print("Enter Choice: ");
          int choice = in.nextInt();
          switch (choice) {
            case 1:
              user = db.userExist(accNo, pin,"checking_account");
              System.out.println("Checking Account:");
              Operation.accoutOperation(user,"checking_account");
              break;
            case 2:
              user = db.userExist(accNo, pin, "saving_account");
              System.out.println("Checking Account:");
              Operation.accoutOperation(user, "saving_account");
              break;
            case 3:
              System.out.println("Thank you for using this ATM,Bye.");
              return;
            default:
              break;
          }
        }
      }
      else{
        System.out.println("Wrong Account number and Pin number");
      }
    }
  }
}
