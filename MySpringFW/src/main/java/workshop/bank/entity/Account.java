package workshop.bank.entity;

public abstract class Account {
    protected int accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(int accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    // 계좌번호 반환
    public int getAccountNumber() {
        return accountNumber;
    }

    // 소유자 이름 반환
    public String getOwnerName() {
        return ownerName;
    }

    // 잔액 반환
    public double getBalance() {
        return balance;
    }

    // 입금
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // 출금 (계좌 종류에 따라 구현 방식 다름)
    public abstract boolean withdraw(double amount);

    @Override
    public String toString() {
        return String.format("Account #%d (%s): %.2f", accountNumber, ownerName, balance);
    }
}
