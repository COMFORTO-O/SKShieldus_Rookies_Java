package workshop.bank.entity;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(int accountNumber, String ownerName, double withdrawalLimit) {
        super(accountNumber, ownerName);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= withdrawalLimit && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("CheckingAccount #%d (%s): %.2f, Limit: %.2f",
                accountNumber, ownerName, balance, withdrawalLimit);
    }
}
