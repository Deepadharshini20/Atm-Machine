package atmOperation;

import atm.Atm;
import user.User;

public class Operation {
  public static void accoutOperation(User u,String tableName) {
    boolean flag = true;
    while(flag){
      System.out.println("Type 1 - View Balance\nType 2 - Withdraw Funds\nType 3 - Deposit Funds\nType 4 - Exit");
      System.out.print("Enter Choice : ");
      int choice = Atm.in.nextInt();
      if (choice != 4)
        System.out.println("Checking Account Balance: $" + u.getBalance());
      switch (choice) {
        case 1:
          break;
        case 2: {
          System.out.println("Amount u want to withdraw from Checking Account: ");
          int withdraw = Atm.in.nextInt();
          if (u.getBalance() >= withdraw){
            u.setBalance(u.getBalance() - withdraw);
            System.out.println("New Checking Account balance: $" + u.getBalance());
            Atm.db.updateBalance(u,tableName);
          }
          else
            System.out.println("Balance is insuffient");
        }
          break;
        case 3: {
          System.out.println("Amount u want to deposit from Checking Account: ");
          int deposit = Atm.in.nextInt();
          u.setBalance(u.getBalance() + deposit);
          System.out.println("New Checking Account balance: $" + u.getBalance());
          Atm.db.updateBalance(u,tableName);
        }
          break;
        case 4:
          flag = false;
          break;
        default:
          System.out.println("Enter Valid!!");
          break;
      }
    }
    

  }
}
