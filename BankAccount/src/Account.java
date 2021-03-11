public abstract class Account {
    private int accountNumber;
    protected double balance;

    public Account() {
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Function to deposit funds into account as long as account parameter is > 0
     *
     * Applying transaction fee for the checking account
     *
     * @param amount to be deposited
     */
    public abstract void deposit(double amount);

    /**
     * Function to withdraw funds into account as long as account parameter is > 0
     * 1. Amount to withdraw must be > 0
     * 2. Amount to withdraw must be <= balance
     * Applying transaction fee for the checking account
     *
     * @param amount to be withdraw
     */
    public abstract void withdraw(double amount);

}
