public class CheckingAccount extends Account {

    public static double FEE = 2.5;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            balance -= FEE;
            System.out.printf("Fee %.2f applied%n", FEE);
            System.out.printf("Current balance is: %.2f%n", balance);


        } else {
            System.out.println("negative amount cannot be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if ((amount + FEE) <= balance) {
                System.out.printf("Amount of %.2f withdrawn from account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current balance is:  %.2f%n", balance);


            }
        } else {
            System.out.println("negative amount cannot be withdrawn");
        }
    }
}
