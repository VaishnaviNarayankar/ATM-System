import java.util.Scanner;

public class atm {

    private static double balance = 0.0;

    // Store as String (Best Practice)
    private static final String ATM_NUMBER = "123456789012";
    private static final String PIN = "1234";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to ATM Machine =====");

        System.out.print("Enter your ATM Card Number: ");
        String enteredATM = sc.next();

        if (!enteredATM.equals(ATM_NUMBER)) {
            System.out.println("Invalid ATM Card Number. Access Denied!");
            return;
        }

        System.out.print("Enter your PIN: ");
        String enteredPin = sc.next();

        if (!enteredPin.equals(PIN)) {
            System.out.println("Incorrect PIN. Access Denied!");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Your Current Balance: Rs." + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("₹" + depositAmount + " deposited successfully!");
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount!");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient Balance!");
                    } else {
                        balance -= withdrawAmount;
                        System.out.println("₹" + withdrawAmount + " withdrawn successfully!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");

            }

        } while (choice != 4);

        sc.close();
    }
}