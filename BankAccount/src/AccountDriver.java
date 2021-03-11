import java.util.Scanner;

public class AccountDriver {

    public static int accountMenu(Scanner input) {
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = input.nextInt();
        } while (choice < 1 || choice > 2);

        return choice;
    }

    public static int searchAccount(Account accounts[], int count, int accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void doDeposit(Account accounts[], int count, Scanner keyboard) {

        System.out.println("Please enter account number: ");
        int accountNumber = keyboard.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            System.out.println("Please enter deposit amount: ");
            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void doWithdraw(Account accounts[], int count, Scanner keyboard) {

        System.out.println("Please enter account number: ");
        int accountNumber = keyboard.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            System.out.println("Please enter withdraw amount: ");
            double amount = keyboard.nextDouble();

            accounts[index].withdraw(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner keyboard) {
        System.out.println("Please enter account number: ");
        int accountNumber = keyboard.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            if (accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount) accounts[index]).applyInterest();
            }
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }


    public static Account createAccount(Scanner keyboard) {
        Account account = null;
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.println("Enter account number: ");
        accountNumber = keyboard.nextInt();

        if (choice == 1) {
            System.out.println("Enter transaction fee: ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else {
            System.out.println("Enter interest rate: ");
            double ir = keyboard.nextDouble();
            account = new SavingsAccount(accountNumber, ir);
        }
        return account;
    }


    public static int menu(Scanner keyboard) {
        System.out.println("Bank account menu");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit funds");
        System.out.println("3. Withdraw funds");
        System.out.println("3. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.println("Enter choice:");
            choice = keyboard.nextInt();
        } while (choice < 1 | choice > 5);

        return choice;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numAccounts = 0;

        Account accounts[] = new Account[10];

        int choice;

        do {
            choice = menu(input);
            System.out.println();

            if (choice == 1) {
                accounts[numAccounts++] = createAccount(input);
            } else if (choice == 2) {
                doDeposit(accounts, numAccounts, input);
            } else if (choice == 3) {
                doWithdraw(accounts, numAccounts, input);
            } else if (choice == 4) {
                applyInterest(accounts, numAccounts, input);
            } else {
                System.out.println("Goodbye!");
            }
        } while (choice != 5);
    }
}
