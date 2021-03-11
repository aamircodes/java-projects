public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Interest amoutn %.2f added to balance", interest);
        deposit(interest);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            System.out.printf("Current balance is: %.2f%n", balance);


        } else {
            System.out.println("negative amount cannot be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if ((amount) <= balance) {
                System.out.printf("Amount of %.2f withdrawn from account%n", amount);
                balance -= amount;
                System.out.printf("Current balance is:  %.2f%n", balance);
            }
        } else {
            System.out.println("negative amount cannot be withdrawn");
        }
    }
}
